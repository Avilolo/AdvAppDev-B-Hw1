package com.example.advappdev_b_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.appcompat.widget.AppCompatImageView;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class Activity_PanelBase extends AppCompatActivity {

    private static int IMAGES_NUM = 4;
    protected DataManager dataManagerBase;

    private ImageButton[] panel_BTN_top_answers;
    private TextView[] panel_BTN_bottom_answers;
    private AppCompatImageView[] panel_IMG_hearts;
    private int current_health_num = 3;
    private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        findViews();

        gameManager = new GameManager(dataManagerBase);
        setImagesAndTexts();

        panel_BTN_bottom_answers[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropHealth();
            }
        });
    }

    private void setImagesAndTexts() {
//        List<String> images = gameManager.getImages();
//        List<String> texts = gameManager.getTexts();
//
//        for (int i = 0; i < IMAGES_NUM; i++) {
//            String imageUrl = images.get(i);
//            String text = texts.get(i);
//
//            // Load question image using Glide into panel_IMG_questions[i]
//            Glide.with(this).load(imageUrl).into(panel_BTN_top_answers[i]);
//
//            // Set text for panel_BTN_bottom_answers[i]
//            panel_BTN_bottom_answers[i].setText(text);
//        }
    }


    private void findViews() {
        panel_BTN_top_answers = new ImageButton[]{
                findViewById(R.id.top_image_2),
                findViewById(R.id.top_image_1),
                findViewById(R.id.top_image_4),
                findViewById(R.id.top_image_3),
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

    public void dropHealth() {
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