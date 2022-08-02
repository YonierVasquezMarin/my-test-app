package com.yoniervasquez.mytestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tmpText;
    private int textInScreen = 1;
    private boolean imagesInScreen = false;
    private Button btnShowImages;
    private LinearLayout imagesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get views
        tmpText = findViewById(R.id.tmp_text);
        Button btnChangeText = findViewById(R.id.btn_change_text);
        imagesList = findViewById(R.id.imagesList);
        btnShowImages = findViewById(R.id.btn_show_images);

        // Onclick: change text on screen
        btnChangeText.setOnClickListener(view -> onClickChangeText());

        // Onclick: show images
        btnShowImages.setOnClickListener(view -> imagesListControl());
    }

    /**
     * When main btn is on click text in screen will change.
     */
    private void onClickChangeText() {
        if (textInScreen == 1) {
            changeText(2);
        } else if (textInScreen == 2) {
            changeText(1);
        }
    }

    /**
     * Receive an idText and show corresponding text.
     * If idText is 1 text in screen will "first text",
     * however if is 2 text in screen will "second text".
     * @param idText only can be 1 or 2.
     */
    private void changeText(int idText) {
        if (idText == 1) {
            tmpText.setText(R.string.txt_main_layout_first_text);
        } else if (idText == 2) {
            tmpText.setText(R.string.txt_main_layout_second_text);
        }
        textInScreen = idText;
    }

    /**
     * If imagesInScreen is true is changed to false,
     * however if is false is changed to true.
     */
    private void switchStateOfImagesView() {
        imagesInScreen = !imagesInScreen;
    }

    /**
     * If imagesInScreen is false the button "show images"
     * change to "hide images", however, if is true the
     * button change to "show images".
     */
    private void changeTitleBtnShowImages() {
        if (imagesInScreen) {
            btnShowImages.setText(R.string.mostrar_imagenes_btn);
        } else {
            btnShowImages.setText(R.string.ocultar_imagenes_btn);
        }
    }

    /**
     * Generate an ImageView that contain the Android robot.
     * @return a new ImageView
     */
    private ImageView createImageviewElement() {
        ImageView newImageToInsert = new ImageView(this);
        newImageToInsert.setMaxWidth(255);
        newImageToInsert.setMaxHeight(150);
        newImageToInsert.setImageResource(R.drawable.robot_android);
        return newImageToInsert;
    }

    /**
     * Insert a new image in screen.
     */
    private void insertImages() {
        ImageView newImageToInsert = createImageviewElement();
        int count = 4;
        for (int i=0; i<count; i++) {
            // remove parent if this have one
            if (newImageToInsert.getParent() != null) {
                ((ViewGroup)newImageToInsert.getParent()).removeView(newImageToInsert);
            }
            imagesList.addView(newImageToInsert);
        }
    }

    private void insertImages2() {
        View newImage = new View(this);

        int count = 2;
        for (int i=0; i<count; i++) {

            //imagesList.addView();
        }
    }

    /**
     * Remove all images of screen.
     */
    private void quitImages() {
        imagesList.removeAllViews();
    }

    /**
     * Control if show or hide images.
     */
    private void imagesListControl() {
        changeTitleBtnShowImages();
        switchStateOfImagesView();
        if (imagesInScreen) {
            insertImages();
        } else {
            quitImages();
        }
    }

}