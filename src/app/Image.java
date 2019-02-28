package app;

import java.util.List;

public class Image {
    private char orientation;
    private int numberOfTags;
    private List<String> tags;

    public Image(char orientation, int numberOfTags, List<String> tags) {
        this.orientation = orientation;
        this.numberOfTags = numberOfTags;
        this.tags = tags;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    public int getNumberOfTags() {
        return numberOfTags;
    }

    public void setNumberOfTags(int numberOfTags) {
        this.numberOfTags = numberOfTags;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Image{" +
                "orientation=" + orientation +
                ", numberOfTags=" + numberOfTags +
                ", tags=" + tags +
                '}';
    }
}
