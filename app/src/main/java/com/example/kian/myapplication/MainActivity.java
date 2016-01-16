package com.example.kian.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int computerChoose;
    private int userChoose;
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateNumber();
    }

    public void generateNumber() {
        Button gButton = (Button) findViewById(R.id.guessButton);
        Random randy = new Random();
        computerChoose =  randy.nextInt(1000);
    }

    public void guess_click(View view) {
        // Track the number taped by the user in the EditText
        EditText text = (EditText)findViewById(R.id.usertext);
        userChoose = Integer.valueOf(text.getText().toString());
        if (userChoose < computerChoose) {
            Toast.makeText(this, "Guess Higher!", Toast.LENGTH_SHORT).show();
        } else if (userChoose > computerChoose) {
            Toast.makeText(this, "Guess Lower!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You Got It !", Toast.LENGTH_SHORT).show();
            points++;
            // counting the number of number found
            TextView pointsView = (TextView) findViewById(R.id.pointsView );
            pointsView.setText("Points: " + points);
            // replay
            generateNumber();
        }
    }
}
