package com.example.android.quizapp;

import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText mq1; // prague
    String mg1_ok_answer = "prague";

    RadioGroup mq2_ag;
    RadioButton mg2_a1, mg2_a2, mg2_a3, mg2_a4; // 3

    CheckBox mg3_a1, mg3_a2, mg3_a3, mg3_a4; // 1,4

    RadioGroup mq4_ag;
    RadioButton mg4_a1, mg4_a2, mg4_a3, mg4_a4; // 4

    RadioGroup mq5_ag;
    RadioButton mg5_a1, mg5_a2, mg5_a3, mg5_a4; // 4

    Button mSubmit, mReset;

    int score;
    Boolean allAnswered;

    Drawable imgOk, imgBad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mq1 = findViewById(R.id.q1_et);

        mq2_ag = findViewById(R.id.q2_ag);
        mg2_a1 = findViewById(R.id.q2_a1);
        mg2_a2 = findViewById(R.id.q2_a2);
        mg2_a3 = findViewById(R.id.q2_a3);
        mg2_a4 = findViewById(R.id.q2_a4);

        mg3_a1 = findViewById(R.id.q3_a1);
        mg3_a2 = findViewById(R.id.q3_a2);
        mg3_a3 = findViewById(R.id.q3_a3);
        mg3_a4 = findViewById(R.id.q3_a4);

        mq4_ag = findViewById(R.id.q4_ag);
        mg4_a1 = findViewById(R.id.q4_a1);
        mg4_a2 = findViewById(R.id.q4_a2);
        mg4_a3 = findViewById(R.id.q4_a3);
        mg4_a4 = findViewById(R.id.q4_a4);

        mq5_ag = findViewById(R.id.q5_ag);
        mg5_a1 = findViewById(R.id.q5_a1);
        mg5_a2 = findViewById(R.id.q5_a2);
        mg5_a3 = findViewById(R.id.q5_a3);
        mg5_a4 = findViewById(R.id.q5_a4);

        mSubmit = findViewById(R.id.buttonSubmit);
        mReset = findViewById(R.id.buttonReset);

        mSubmit.setClickable(true);
        mReset.setClickable(true);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitQuiz();
            }
        });

        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetQuiz();
            }
        });

        imgOk = ResourcesCompat.getDrawable(getResources(), R.drawable.ok, null);
        imgBad = ResourcesCompat.getDrawable(getResources(), R.drawable.bad, null);

        if (savedInstanceState != null) {
            allAnswered = savedInstanceState.getBoolean("allAnswered");
            score = savedInstanceState.getInt("score");
        } else {
            score = 0;
            allAnswered = false;
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("allAnswered", allAnswered);
        outState.putInt("score", score);

        super.onSaveInstanceState(outState);

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        allAnswered = savedInstanceState.getBoolean("allAnswered");
        score = savedInstanceState.getInt("score");
    }

    public void clearImages() {
        mq1.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

        mg2_a1.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mg2_a2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mg2_a3.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mg2_a4.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);


        mg3_a1.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mg3_a2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mg3_a3.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mg3_a4.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

        mg4_a1.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mg4_a2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mg4_a3.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mg4_a4.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

        mg5_a1.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mg5_a2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mg5_a3.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        mg5_a4.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }

    public void resetQuiz() {
        clearImages();

        score = 0;
        allAnswered = false;

        mq1.setText(null);

        mq2_ag.clearCheck();

        mg3_a1.setChecked(false);
        mg3_a2.setChecked(false);
        mg3_a3.setChecked(false);
        mg3_a4.setChecked(false);

        mq4_ag.clearCheck();

        mq5_ag.clearCheck();

    }

    public void submitQuiz() {
        clearImages();

        score = 0;

        if (mq1.getText().toString().equalsIgnoreCase(mg1_ok_answer)) {
            score += 1;
            mq1.setCompoundDrawablesWithIntrinsicBounds(null, null, imgOk, null);
        } else {
            mq1.setCompoundDrawablesWithIntrinsicBounds(null, null, imgBad, null);
        }

        if (mg2_a1.isChecked()) {
            mg2_a1.setCompoundDrawablesWithIntrinsicBounds(null, null, imgBad, null);
        } else if (mg2_a2.isChecked()) {
            mg2_a2.setCompoundDrawablesWithIntrinsicBounds(null, null, imgBad, null);
        } else if (mg2_a3.isChecked()) {
            score += 1;
            mg2_a3.setCompoundDrawablesWithIntrinsicBounds(null, null, imgOk, null);
        } else if (mg2_a4.isChecked()) {
            mg2_a4.setCompoundDrawablesWithIntrinsicBounds(null, null, imgBad, null);
        }

        if (mg3_a1.isChecked() && !mg3_a2.isChecked() && !mg3_a3.isChecked() && mg3_a4.isChecked()) {
            score += 1;
        }

        if (mg3_a1.isChecked()) {
            mg3_a1.setCompoundDrawablesWithIntrinsicBounds(null, null, imgOk, null);
        }

        if (mg3_a2.isChecked()) {
            mg3_a2.setCompoundDrawablesWithIntrinsicBounds(null, null, imgBad, null);
        }

        if (mg3_a3.isChecked()) {
            mg3_a3.setCompoundDrawablesWithIntrinsicBounds(null, null, imgBad, null);
        }

        if (mg3_a4.isChecked()) {
            mg3_a4.setCompoundDrawablesWithIntrinsicBounds(null, null, imgOk, null);
        }

        if (mg4_a1.isChecked()) {
            mg4_a1.setCompoundDrawablesWithIntrinsicBounds(null, null, imgBad, null);
        } else if (mg4_a2.isChecked()) {
            mg4_a2.setCompoundDrawablesWithIntrinsicBounds(null, null, imgBad, null);
        } else if (mg4_a3.isChecked()) {
            mg4_a3.setCompoundDrawablesWithIntrinsicBounds(null, null, imgBad, null);
        } else if (mg4_a4.isChecked()) {
            score += 1;
            mg4_a4.setCompoundDrawablesWithIntrinsicBounds(null, null, imgOk, null);
        }

        if (mg5_a1.isChecked()) {
            mg5_a1.setCompoundDrawablesWithIntrinsicBounds(null, null, imgBad, null);
        } else if (mg5_a2.isChecked()) {
            mg5_a2.setCompoundDrawablesWithIntrinsicBounds(null, null, imgBad, null);
        } else if (mg5_a3.isChecked()) {
            mg5_a3.setCompoundDrawablesWithIntrinsicBounds(null, null, imgBad, null);
        } else if (mg5_a4.isChecked()) {
            score += 1;
            mg5_a4.setCompoundDrawablesWithIntrinsicBounds(null, null, imgOk, null);
        }

        allAnswered = true;
        showScore();

    }

    public void showScore() {

        String message = "";

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        if (score == 5) {
            message += "Perfect. You have all answers right. You have 5 from 5 points.";
        } else if (score < 5 && score > 0) {
            message += "Not bad. You have " + String.valueOf(score) + " points from 5 possible.";
        } else if (score == 0) {
            message += "No good answer. Try it again!";
        }

        dialog.setMessage(message);
        AlertDialog alert = dialog.create();
        alert.show();

    }

}




