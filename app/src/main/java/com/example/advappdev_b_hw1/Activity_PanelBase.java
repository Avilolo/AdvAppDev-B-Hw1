package com.example.advappdev_b_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;


import androidx.appcompat.widget.AppCompatImageView;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class Activity_PanelBase extends AppCompatActivity {

    private static int IMAGES_NUM = 4;
    protected DataManagerAnimals dataManagerBase;
    private ImageButton[] panel_BTN_top_answers;
    private TextView[] panel_BTN_bottom_answers;
    private AppCompatImageView[] panel_IMG_hearts;
    private int current_health_num = 2;
    private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        findViews();

        dataManagerBase = new DataManagerAnimals();
        gameManager = new GameManager(dataManagerBase);

        setImagesAndTexts();

        setClickListeners();
    }

    private void setImagesAndTexts() {
        List<String> images = gameManager.getImages();
        List<String> texts = gameManager.getTexts();

        for (int i = 0; i < IMAGES_NUM; i++) {
            String imageUrl = images.get(i);
            String text = texts.get(i);

            // Load question image using Glide into panel_IMG_questions[i]
            Glide.with(this).load(imageUrl).into(panel_BTN_top_answers[i]);

            // Set text for panel_BTN_bottom_answers[i]
            panel_BTN_bottom_answers[i].setText(text);
        }
    }


    private void findViews() {
        panel_BTN_top_answers = new ImageButton[]{
                findViewById(R.id.top_image_1),
                findViewById(R.id.top_image_2),
                findViewById(R.id.top_image_3),
                findViewById(R.id.top_image_4),
        };
        panel_BTN_bottom_answers = new TextView[]{
                findViewById(R.id.bottom_text_1),
                findViewById(R.id.bottom_text_2),
                findViewById(R.id.bottom_text_3),
                findViewById(R.id.bottom_text_4),
        };

        panel_IMG_hearts = new AppCompatImageView[]{
                findViewById(R.id.heart1),
                findViewById(R.id.heart2),
                findViewById(R.id.heart3)
        };
    }

    private void dropHealth() {
        if (panel_IMG_hearts[0].getVisibility() == View.INVISIBLE) {
            Toast.makeText(this, "Game over", Toast.LENGTH_SHORT).show();
            return;
        }
        panel_IMG_hearts[current_health_num--].setVisibility(View.INVISIBLE);

        if (panel_IMG_hearts[0].getVisibility() == View.INVISIBLE) {
            Toast.makeText(this, "Game over", Toast.LENGTH_SHORT).show();
            for (int i = 0; i < IMAGES_NUM; i++) {
                panel_BTN_top_answers[i].setVisibility(View.INVISIBLE);
                panel_BTN_bottom_answers[i].setVisibility(View.INVISIBLE);
            }
        }
    }
    
    private void setClickListeners() {
        for (int i = 0; i < IMAGES_NUM; i++) {
            // using index so function blocks have access to variable
            int index = i;
            panel_BTN_top_answers[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     toggleImageSelection(panel_BTN_top_answers[index], index);
                }
            });
            panel_BTN_bottom_answers[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    toggleTextSelection(panel_BTN_bottom_answers[index], index);
                }
            });
        }
    }

    private void toggleImageSelection(ImageButton panelBtnTopAnswer, int i) {
        gameManager.topCardsIndex = i;
        Boolean shouldChangeColor = Boolean.valueOf(panelBtnTopAnswer.getTag().toString());
        if (panelBtnTopAnswer == null ||
                (gameManager.isAnyImageSelected && i != gameManager.lastImageClicked)) { return; }
        //check if we should change the bg color based on the tag
        else if (shouldChangeColor) {
            panelBtnTopAnswer.setBackgroundColor(Color.LTGRAY);
            panelBtnTopAnswer.setTag("false");
            gameManager.isAnyImageSelected = true;
        }
        else {
            panelBtnTopAnswer.setBackgroundColor(Color.TRANSPARENT);
            panelBtnTopAnswer.setTag("true");
            gameManager.isAnyImageSelected = false;
        }
        gameManager.lastImageClicked = i;
//        gameManager.selectedCard(i);
    }

    private void toggleTextSelection(TextView panelBtnBottomAnswer, int i) {
        gameManager.bottomCardsIndex = i;
        Boolean shouldChangeColor = Boolean.valueOf(panelBtnBottomAnswer.getTag().toString());
        //if the object is null or card already selected ( != -1 means we got card selected. return
        if (panelBtnBottomAnswer == null ||
                (gameManager.isAnyTextSelected && i != gameManager.lastTextClicked)) { return; }
        //check if we should change the bg color based on the tag
        else if (shouldChangeColor) {
            panelBtnBottomAnswer.setBackgroundResource(R.drawable.text_view_unclicked);
            panelBtnBottomAnswer.setTag("false");
            gameManager.isAnyTextSelected = true;
        }
        else {
            panelBtnBottomAnswer.setBackgroundResource(R.drawable.text_view_clicked);
            panelBtnBottomAnswer.setTag("true");
            gameManager.isAnyTextSelected = false;
        }
        gameManager.lastTextClicked = i;
        //TODO check if true. if true delete images
//        gameManager.selectedCard(i);
    }
}




/*
Fog img - https://cdn.wcs.org/2024/03/13/21/14/05/2d2c6f1b-71c4-4390-b7e2-deb21a0bc11f/shutterstock_2331893385.jpg
Gator - https://wallpapers.com/images/high/cute-alligator-with-butterflies-gt4wgam34qe2t6a3.webp
Snake - https://i.natgeofe.com/n/f80a6834-c7d0-4e93-b113-ae708652a527/snakes_01_square.jpg
Dog - https://www.doggoneproblems.com/wp-content/uploads/2021/03/Ope-2048x1536.jpeg

Tri - https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Pink_triangle_up.svg/405px-Pink_triangle_up.svg.png
Rec - https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/Rectangle_example.svg/1200px-Rectangle_example.svg.png
pentagon - https://images.twinkl.co.uk/tw1n/image/private/t_630/u/ux/pentagon2_ver_1.jpg
Circle -  https://www.americasfinestlabels.com/includes/work/image_cache/92cc39724d2b0e9bc24bfff812e0ff1b.thumb.jpg
 */