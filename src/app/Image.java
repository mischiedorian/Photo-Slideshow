package app;

import java.util.List;

public class Image {
    private char orientation;
    private int numberOfTags;
    private List<String> tags;
    private List<Integer> outputIndex;
    private List<Integer> tagPriorities;

    public Image(char orientation, int numberOfTags, List<String> tags, List<Integer> outputIndex, List<Integer> tagPriorities) {
        this.orientation = orientation;
        this.numberOfTags = numberOfTags;
        this.tags = tags;
        this.outputIndex = outputIndex;
        this.tagPriorities = tagPriorities;
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

    public List<Integer> getOutputIndex() {
        return outputIndex;
    }

    public void setOutputIndex(List<Integer> outputIndex) {
        this.outputIndex = outputIndex;
    }

    public List<Integer> getTagPriorities() {
        return tagPriorities;
    }

    public void setTagPriorities(List<Integer> tagPriorities) {
        this.tagPriorities = tagPriorities;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Integer value : outputIndex) {
            builder.append(value);
            builder.append(" ");
        }
        return builder.toString();
    }
}
