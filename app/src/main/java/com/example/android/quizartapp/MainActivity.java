package com.example.android.quizartapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Checks if the given answers are correct.
     */

    public void submitAnswers(View view) {

        /** Question 1 - RadioGroup 1
         */

        RadioButton cubism;
        cubism = findViewById(R.id.question1answer2);
        boolean checkedCubism = cubism.isChecked();

        /** Question 2 - CheckBoxes
         */

        CheckBox picasso;
        picasso = findViewById(R.id.question2answer1);
        boolean checkedPicasso = picasso.isChecked();

        CheckBox gris;
        gris = findViewById(R.id.question2answer2);
        boolean checkedGris = gris.isChecked();

        CheckBox leger;
        leger = findViewById(R.id.question2answer3);
        boolean checkedLeger = leger.isChecked();

        /** Question 3 - EditText (case sensitive)
         */

        EditText masterpieceTitle = findViewById(R.id.question3);
        String name = masterpieceTitle.getText().toString();

        /** Question 4 - RadioGroup 2
         */

        RadioButton museum;
        museum = findViewById(R.id.question4answer3);
        boolean checkedReina = museum.isChecked();

        int score = getPoints(checkedCubism, checkedPicasso, checkedGris, checkedLeger, name, checkedReina);

        /** Displays a toast message.
         */

        if (points >= 4) {
            Toast.makeText(getApplicationContext(), "Your score: " + points + "/4 \nBravo! Max points!", Toast.LENGTH_LONG).show();
        }

      else if (points >=3) {
            Toast.makeText(getApplicationContext(), "Your score: " + points + "/4 \nNice! \nYour points have been reset. \nYou can now try again.", Toast.LENGTH_LONG).show();
        }
else {
            Toast.makeText(getApplicationContext(), "Oh... \nYour score: " + points + "/4 \nYour points have been reset. \nYou can now try again.", Toast.LENGTH_LONG).show();
        }

        /** Resets points.
         */

        points = 0;

        /**Clears answers.
         */

        RadioGroup styleUncheck = findViewById(R.id.radioGroup1);
        styleUncheck.clearCheck();

        CheckBox picassoUncheck = findViewById(R.id.question2answer1);
        picassoUncheck.setChecked(false);

        CheckBox grisUncheck = findViewById(R.id.question2answer2);
        grisUncheck.setChecked(false);

        CheckBox legerUncheck = findViewById(R.id.question2answer3);
        legerUncheck.setChecked(false);

        EditText masterpieceTitleClearEditText = (EditText) findViewById(R.id.question3);
        masterpieceTitleClearEditText.getText().clear();

        RadioGroup museumUncheck = findViewById(R.id.radioGroup2);
        museumUncheck.clearCheck();

    }

    /**
     * Calculates points based on given answers.
     */

    public int getPoints(boolean checkedCubism, boolean checkedPicasso, boolean checkedGris, boolean checkedLeger, String name, boolean checkedReina) {

        /** Question 1 points
         */

        if (checkedCubism) {
            points = points + 1;
        }

        /** Question 2 points
         */

        if (checkedPicasso && checkedGris && checkedLeger) {
            points = points + 1;
        }

        /** Question 3 points
         */

        if (name.equals("Guernica")) {
            points = points + 1;
        }

        /** Question 4 points
         */

        if (checkedReina) {
            points = points + 1;
        }

        return points;
    }

}
