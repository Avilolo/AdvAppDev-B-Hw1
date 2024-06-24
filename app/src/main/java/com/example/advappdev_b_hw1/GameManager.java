package com.example.advappdev_b_hw1;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GameManager {
    protected ArrayList<AnswerFrame> imagesInFrame;
    protected ArrayList<AnswerFrame> textsInFrame;
    protected int topCardsIndex = -1; // -1 represents no card selected
    protected int bottomCardsIndex = -1;
    protected  boolean isAnyImageSelected = false;
    protected  boolean isAnyTextSelected = false;
    protected int lastImageClicked = -1;
    protected int lastTextClicked = -1;

    public GameManager(DataManager dataManager) {
        imagesInFrame = dataManager.getTopImages();
        textsInFrame = dataManager.getBotText();
    }

    public GameManager(ArrayList<AnswerFrame> imagesInFrame, ArrayList<AnswerFrame> textsInFrame) {
        this.imagesInFrame = imagesInFrame;
        this.textsInFrame = textsInFrame;
    }

    public boolean selectedCard(int index) {
        if (topCardsIndex == -1) { topCardsIndex = index; }
        else if (bottomCardsIndex == -1) { bottomCardsIndex = index; }

        //check if the current selected cards are matching
        boolean isMatch = checkMatch();

        //reset top & bot cards index selected
        reset();

        return isMatch;
    }


    private boolean checkMatch() {
        return imagesInFrame.get(topCardsIndex).getMatch() == textsInFrame.get(bottomCardsIndex).getMatch();
    }

    public void reset() {
        topCardsIndex = -1; // -1 represents no card selected
        bottomCardsIndex = -1;
    }

    public List<String> getImages() {
        List<String> images = new ArrayList<>();
        for (AnswerFrame frame : imagesInFrame) {
            images.add(frame.getImage());
        }

        // Shuffle the answers
        Collections.shuffle(images);

        return images;
    }

    public List<String> getTexts() {
        List<String> images = new ArrayList<>();
        for (AnswerFrame frame : textsInFrame) {
            images.add(frame.getImage());
        }

        // Shuffle the answers
        Collections.shuffle(images);

        return images;
    }


}