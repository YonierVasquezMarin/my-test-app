package com.yoniervasquez.mytestapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tmpText;
    private int textInScreen = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get views
        tmpText = findViewById(R.id.tmp_text);
        Button btnChangeText = findViewById(R.id.btn_change_text);

        // Load saved instance
        if (savedInstanceState != null) {
            textInScreen = savedInstanceState.getInt("textInScreen");
            changeText(textInScreen);
        }

        btnChangeText.setOnClickListener(view -> changeText(textInScreen));
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

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("textInScreen", textInScreen);
        super.onSaveInstanceState(outState);
    }
}