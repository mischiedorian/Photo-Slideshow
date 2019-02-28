package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws FileNotFoundException {
        List<Image> horizontalPics = new ArrayList<>();
        List<Image> verticalPics = new ArrayList<>();

        URL path = Main.class.getResource("../files/a_example.txt");
        File file = new File(path.getPath());
        Scanner scanner = new Scanner(file);

        int numberOfPictures = Integer.valueOf(scanner.nextLine().split(" ")[0]);

        int nrOfHorizontalPics = 0;
        int nrOfVerticalPics = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] s = line.split(" ");
            String orientation = s[0];
            String numberOfTags = s[1];
            ArrayList<String> currentTags = new ArrayList<>(Arrays.asList(s).subList(2, s.length));
            char orient = orientation.toCharArray()[0];
            Image img = new Image(orient, Integer.valueOf(numberOfTags), currentTags);
            if(orient == 'H') {
                nrOfHorizontalPics++;
                horizontalPics.add(img);
            } else {
                nrOfVerticalPics++;
                verticalPics.add(img);
            }
        }
        int nrOfTotalSlides = nrOfHorizontalPics + (nrOfVerticalPics)/2;

        System.out.println(horizontalPics);
        System.out.println(verticalPics);
        System.out.println(nrOfTotalSlides);
    }

    private static int getNumberOfCommonElements(List<String> array1, List<String> array2) {
        int numberOfCommonElements = 0;

        LinkedHashSet<String> strings = new LinkedHashSet<>(array1);
        LinkedHashSet<String> moreStrings = new LinkedHashSet<>(array2);

        for(String string: strings) {
            if (!moreStrings.add(string))
                numberOfCommonElements++;
        }
        return numberOfCommonElements;
    }
}
