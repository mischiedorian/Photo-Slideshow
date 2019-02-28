package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        int currentCounter = 0;
        List<Image> pics = new ArrayList<>();
        List<Image> slideshow = new ArrayList<>();

        URL path = Main.class.getResource("../files/a_example.txt");
        File file = new File(path.getPath());
        Scanner scanner = new Scanner(file);

        int numberOfPictures = Integer.valueOf(scanner.nextLine().split(" ")[0]);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] s = line.split(" ");
            String orientation = s[0];
            String numberOfTags = s[1];
            ArrayList<String> currentTags = new ArrayList<>(Arrays.asList(s).subList(2, s.length));
            char orient = orientation.toCharArray()[0];
            Image img = new Image(orient, Integer.valueOf(numberOfTags), currentTags,
                    Collections.singletonList(currentCounter++), Collections.emptyList());
            pics.add(img);
        }

        Image firstVerticalPic = null;
        for (int i = 0; i < numberOfPictures; i++) {
            Image currentImage = pics.get(i);
            if (firstVerticalPic == null && currentImage.getOrientation() == 'V') {
                firstVerticalPic = currentImage;
            } else if(currentImage.getOrientation() == 'V') {
                Image image = mergeTwoVerticalImages(firstVerticalPic, currentImage);
                pics.add(image);
                pics.remove(firstVerticalPic);
                pics.remove(currentImage);
            }
        }

    }

    private static int calculateIntersectFactor(Image firstImage, Image secondImage) {
        int firstIndice = getNumberOfCommonTags(firstImage, secondImage);
        int secondIndice = getNumberOfDifferencesBetweenLists(firstImage.getTags(), secondImage.getTags());
        int thirdIndice = getNumberOfDifferencesBetweenLists(secondImage.getTags(), firstImage.getTags());
        return Math.max(Math.max(firstIndice, secondIndice), thirdIndice);
    }

    private static int getNumberOfCommonTags(Image firstImage, Image secondImage) {
        int numberOfCommonElements = 0;

        LinkedHashSet<String> strings = new LinkedHashSet<>(firstImage.getTags());
        LinkedHashSet<String> moreStrings = new LinkedHashSet<>(secondImage.getTags());

        for (String string : strings) {
            if (!moreStrings.add(string))
                numberOfCommonElements++;
        }
        return numberOfCommonElements;
    }

    private static int getNumberOfDifferencesBetweenLists(List<String> array1, List<String> array2) {
        array1.removeAll(array2);
        return array1.size();
    }

    private static Image mergeTwoVerticalImages(Image firstImage, Image secondImage) {
        HashSet<String> bothListsTags = new HashSet<>();
        bothListsTags.addAll(firstImage.getTags());
        bothListsTags.addAll(secondImage.getTags());
        List<Integer> currentOutputIndex = firstImage.getOutputIndex();
        currentOutputIndex.addAll(secondImage.getOutputIndex());

        return new Image('H', bothListsTags.size(), new ArrayList<>(bothListsTags),
                currentOutputIndex, Collections.emptyList());
    }
}
