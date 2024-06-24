package com.example.shapes;

import com.example.common.AnswerFrame;
import com.example.common.DataManagerBase;

import java.util.ArrayList;

public class DataManagerShapes extends DataManagerBase {
    public enum Shapes { CIRCLE, TRIANGLE, RECTANGLE, PENTAGON }


    @Override
    public ArrayList<AnswerFrame> getTopImages() {
        ArrayList<AnswerFrame> topImages = new ArrayList<>();

        topImages.add(new AnswerFrame()
                .setImage("https://www.americasfinestlabels.com/includes/work/image_cache/92cc39724d2b0e9bc24bfff812e0ff1b.thumb.jpg")
                .setMatch(Shapes.CIRCLE.name()));
        topImages.add(new AnswerFrame()
                .setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Pink_triangle_up.svg/405px-Pink_triangle_up.svg.png")
                .setMatch(Shapes.TRIANGLE.name()));

        topImages.add(new AnswerFrame()
                .setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/Rectangle_example.svg/1200px-Rectangle_example.svg.png")
                .setMatch(Shapes.RECTANGLE.name()));

        topImages.add(new AnswerFrame()
                .setImage("https://images.twinkl.co.uk/tw1n/image/private/t_630/u/ux/pentagon2_ver_1.jpg")
                .setMatch(Shapes.PENTAGON.name()));


        return topImages;
    }

    @Override
    public ArrayList<AnswerFrame> getBotText() {
        ArrayList<AnswerFrame> botText = new ArrayList<>();

        botText.add(new AnswerFrame()
                .setImage("Circle")
                .setMatch(Shapes.CIRCLE.name()));
        botText.add(new AnswerFrame()
                .setImage("Triangle")
                .setMatch(Shapes.TRIANGLE.name()));

        botText.add(new AnswerFrame()
                .setImage("Rectangle")
                .setMatch(Shapes.RECTANGLE.name()));

        botText.add(new AnswerFrame()
                .setImage("Pentagon")
                .setMatch(Shapes.PENTAGON.name()));


        return botText;
    }

}
