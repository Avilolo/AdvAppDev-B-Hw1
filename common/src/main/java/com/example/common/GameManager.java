package com.example.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GameManager {
    protected List<AnswerFrame> imagesInFrame;
    protected List<AnswerFrame> textsInFrame;
    protected int topCardsIndex = -1; // -1 represents no card selected when game boot up
    protected int bottomCardsIndex = -1;
    protected  boolean isAnyImageSelected = false;
    protected  boolean isAnyTextSelected = false;
    protected int lastImageClicked = -1;
    protected int lastTextClicked = -1;
    int cardsLeft; // tracking the current number of cards

    public GameManager(DataManagerBase dataManager) {
        imagesInFrame = dataManager.getTopImages();
        textsInFrame = dataManager.getBotText();
        cardsLeft = imagesInFrame.size() - 1;
    }

    public GameManager(ArrayList<AnswerFrame> imagesInFrame, ArrayList<AnswerFrame> textsInFrame) {
        this.imagesInFrame = imagesInFrame;
        this.textsInFrame = textsInFrame;
        cardsLeft = imagesInFrame.size() - 1;
    }

    public int checkMatch() {
        int isOver = -1; // -1 one card selected, 0 not over, 1 over
        if (lastImageClicked == -1 || lastTextClicked == -1) { return isOver; }
        //check if both matching cards "match" attribute is the same
        if (imagesInFrame.get(lastImageClicked).getMatch().equals(
                textsInFrame.get(lastTextClicked).getMatch()) ) {
            if (cardsLeft == 0) { return isOver = 1; }
            lastTextClicked = -1;
            lastImageClicked = -1;
            isAnyImageSelected = false;
            isAnyTextSelected = false;
            isOver = 0;
            cardsLeft--;
        }
        return isOver;
    }

    public List<AnswerFrame> getImages() {
        // Shuffle the answers
        Collections.shuffle(imagesInFrame);

        return imagesInFrame;
    }

    public List<AnswerFrame> getTexts() {
        // Shuffle the answers
        Collections.shuffle(textsInFrame);

        return textsInFrame;
    }
}