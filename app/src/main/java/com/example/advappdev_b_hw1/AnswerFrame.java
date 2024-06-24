package com.example.advappdev_b_hw1;

public class AnswerFrame {
    /* image will contain either image url for image view
    or text for text view */
    private String image = "";
    private String match;


    public AnswerFrame() {}

    public AnswerFrame(String image, String match) {
        this.image = image;
        this.match = match;
    }

    public String getImage() {
        return image;
    }

    public String getMatch() {
        return match;
    }

    public AnswerFrame setImage(String image) {
        this.image = image;
        return this;
    }

    public AnswerFrame setMatch(String match) {
        this.match = match;
        return this;
    }
}
