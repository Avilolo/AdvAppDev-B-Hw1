package com.example.advappdev_b_hw1;

import com.example.common.AnswerFrame;
import com.example.common.DataManagerBase;

import java.util.ArrayList;

public class DataManagerAnimals extends DataManagerBase {
    public enum Animals { FROG, GATOR, SNAKE, DOG }

    @Override
    public ArrayList<AnswerFrame> getTopImages() {
        ArrayList<AnswerFrame> topImages = new ArrayList<>();

        topImages.add(new AnswerFrame()
                .setImage("https://cdn.wcs.org/2024/03/13/21/14/05/2d2c6f1b-71c4-4390-b7e2-deb21a0bc11f/shutterstock_2331893385.jpg")
                .setMatch(Animals.FROG.name()));
        topImages.add(new AnswerFrame()
                .setImage("https://wallpapers.com/images/high/cute-alligator-with-butterflies-gt4wgam34qe2t6a3.webp")
                .setMatch(Animals.GATOR.name()));

        topImages.add(new AnswerFrame()
                .setImage("https://i.natgeofe.com/n/f80a6834-c7d0-4e93-b113-ae708652a527/snakes_01_square.jpg")
                .setMatch(Animals.SNAKE.name()));

        topImages.add(new AnswerFrame()
                .setImage("https://www.doggoneproblems.com/wp-content/uploads/2021/03/Ope-2048x1536.jpeg")
                .setMatch(Animals.DOG.name()));


        return topImages;
    }

    @Override
    public ArrayList<AnswerFrame> getBotText() {
        ArrayList<AnswerFrame> botText = new ArrayList<>();

        botText.add(new AnswerFrame()
                .setImage("Frog")
                .setMatch(Animals.FROG.name()));
        botText.add(new AnswerFrame()
                .setImage("Gator")
                .setMatch(Animals.GATOR.name()));

        botText.add(new AnswerFrame()
                .setImage("Snake")
                .setMatch(Animals.SNAKE.name()));

        botText.add(new AnswerFrame()
                .setImage("Dog")
                .setMatch(Animals.DOG.name()));


        return botText;
    }

}
