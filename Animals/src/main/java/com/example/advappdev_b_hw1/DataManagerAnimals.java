package com.example.advappdev_b_hw1;

import com.example.common.AnswerFrame;
import com.example.common.DataManagerBase;

import java.util.ArrayList;

public class DataManagerAnimals extends DataManagerBase {
    public enum Animals { FROG, GATOR, SNAKE, DOG }
//    private static final int FROG = 0;
//    private static final int GATOR = 1;
//    private static final int SNAKE = 2;
//    private static final int DOG = 3;

    @Override
    public ArrayList<AnswerFrame> getTopImages() {
        ArrayList<AnswerFrame> topImages = new ArrayList<>();

        topImages.add(new AnswerFrame()
                .setImage("https://cdn.wcs.org/2024/03/13/21/14/05/2d2c6f1b-71c4-4390-b7e2-deb21a0bc11f/shutterstock_2331893385.jpg")
                .setMatch("FROG"));
        topImages.add(new AnswerFrame()
                .setImage("https://wallpapers.com/images/high/cute-alligator-with-butterflies-gt4wgam34qe2t6a3.webp")
                .setMatch("GATOR"));

        topImages.add(new AnswerFrame()
                .setImage("https://i.natgeofe.com/n/f80a6834-c7d0-4e93-b113-ae708652a527/snakes_01_square.jpg")
                .setMatch("SNAKE"));

        topImages.add(new AnswerFrame()
                .setImage("https://www.doggoneproblems.com/wp-content/uploads/2021/03/Ope-2048x1536.jpeg")
                .setMatch("DOG"));


        return topImages;
    }

    @Override
    public ArrayList<AnswerFrame> getBotText() {
        ArrayList<AnswerFrame> botText = new ArrayList<>();

        botText.add(new AnswerFrame()
                .setImage("Frog")
                .setMatch("FROG"));
        botText.add(new AnswerFrame()
                .setImage("Gator")
                .setMatch("GATOR"));

        botText.add(new AnswerFrame()
                .setImage("Snake")
                .setMatch("SNAKE"));

        botText.add(new AnswerFrame()
                .setImage("Dog")
                .setMatch("DOG"));


        return botText;
    }

}
