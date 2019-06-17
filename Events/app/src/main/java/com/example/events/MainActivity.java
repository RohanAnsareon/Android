package com.example.events;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickEvent(View view) {
        DisplayMetrics parent = this.getResources().getDisplayMetrics();
        Button btn = (Button)view;
        if(view.getWidth() < parent.widthPixels && view.getHeight() < parent.heightPixels) {
            view.setMinimumWidth(view.getWidth() + 50);
            view.setMinimumHeight(view.getHeight() + 50);
        } else {
            btn.setText(R.string.bigger_button_text);
            btn.setTextColor(Color.RED);
            btn.setTextSize(36);
            btn.setEnabled(false);
        }
    }
}
