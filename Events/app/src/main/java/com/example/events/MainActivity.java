package com.example.events;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int count = 0;
    private Random rndm = new Random();
    private ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.actionBar = getSupportActionBar();
    }

    public void clickEvent(View view) {
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(
                new ColorDrawable(
                    Color.rgb(rndm.nextInt(256),
                                rndm.nextInt(256),
                                rndm.nextInt(256)
                    )
                )
            );
            Date date = new Date();
            int diff;
            if(date.getHours() <= 12) {
                diff = 12 - date.getHours();
            } else {
                diff = 36 - date.getHours();
            }
            int minutes = 0;
            if(date.getMinutes() != 0) {
                diff--;
                minutes = 60 - date.getMinutes();
            }
            actionBar.setTitle(diff + ":" + minutes);
        }
        if(count < 20) {
            view.setMinimumWidth(view.getWidth() + 20);
            view.setMinimumHeight(view.getHeight() + 20);
            view.setBackgroundColor(Color.rgb(rndm.nextInt(256), rndm.nextInt(256), rndm.nextInt(256)));
            count++;
            ((Button) view).setText(count + "");
            ((Button) view).setTextSize(rndm.nextInt(23) + 13);
            ((Button) view).setTextColor(Color.rgb(rndm.nextInt(256), rndm.nextInt(256), rndm.nextInt(256)));
        } else {
            ((Button) view).setText(R.string.bigger_button_text);
            ((Button) view).setTextColor(Color.RED);
            ((Button) view).setTextSize(36);
            ((Button) view).setEnabled(false);
        }
    }
}
