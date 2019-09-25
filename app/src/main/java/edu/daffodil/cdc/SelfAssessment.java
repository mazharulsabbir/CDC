package edu.daffodil.cdc;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class SelfAssessment extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar timeRemainingProgress;
    private TextView textViewQuestion;

    private MaterialButton answer1, answer2, answer3, answer4;

    private MaterialButton skipAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_assessment);

        timeRemainingProgress = findViewById(R.id.progressBar);
        textViewQuestion = findViewById(R.id.question);

        answer1 = findViewById(R.id.ans1);
        answer1.setOnClickListener(this);

        answer2 = findViewById(R.id.ans2);
        answer2.setOnClickListener(this);

        answer3 = findViewById(R.id.ans3);
        answer3.setOnClickListener(this);

        answer4 = findViewById(R.id.ans4);
        answer4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ans1 | v.getId() == R.id.ans2 | v.getId() == R.id.ans3 | v.getId() == R.id.ans4) {
            checkAnswer();
        }

        if (v.getId() == R.id.skip_ques) {
            nextQuestion();
        }
    }

    private void nextQuestion() {

    }

    private void checkAnswer() {

    }
}
