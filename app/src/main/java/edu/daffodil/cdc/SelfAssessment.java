package edu.daffodil.cdc;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import edu.daffodil.cdc.model.Assessments;
import edu.daffodil.cdc.repository.AssessmentViewModel;

public class SelfAssessment extends AppCompatActivity implements View.OnClickListener {

    private static final long START_TIME_IN_MILLIS = 15000;
    List<Assessments> assessmentsList;
    private ProgressBar timeRemainingProgress;
    private TextView textViewQuestion;
    private MaterialButton answer1, answer2, answer3, answer4;
    private MaterialButton skipAns;

    private boolean mTimerRunning;

    private int quesNumber = 0;
    private int sizeOfList = 0;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

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
        assessmentsList = new ArrayList<>();

        AssessmentViewModel assessmentViewModel = ViewModelProviders.of(this).get(AssessmentViewModel.class);
        assessmentViewModel.getAllAssessments().observe(this, new Observer<List<Assessments>>() {
                    @Override
                    public void onChanged(List<Assessments> assessments) {
                        assessmentsList.clear();
                        assessmentsList = assessments;

                        sizeOfList = assessmentsList.size();
                        nextQuestion();
                    }
                }
        );
        startTimer();

        updateTimerProgress();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ans1 | v.getId() == R.id.ans2 | v.getId() == R.id.ans3 | v.getId() == R.id.ans4) {
            checkAnswer();

        }

        if (v.getId() == R.id.skip_ques) {
            nextQuestion();
            resetTimer();
        }
    }

    private void nextQuestion() {
        if (assessmentsList.size() == 0)
            return;
        if (assessmentsList.size() > quesNumber) {
            TextView n = findViewById(R.id.question_number);
            n.setText("Q" + (quesNumber + 1));

            Assessments assessments = assessmentsList.get(quesNumber);
            textViewQuestion.setText(assessments.getQuestion());
            answer1.setText(assessments.getAns1());
            answer2.setText(assessments.getAns2());
            answer3.setText(assessments.getAns3());
            answer4.setText(assessments.getAns4());

            quesNumber++;
        }
    }

    private void checkAnswer() {

        /*check the answer is correct or not*/
        /*TODO: CHECK THE GIVEN ANSWER*/


        /*show next questions*/
        nextQuestion();
        resetTimer();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

    /*COUNT DOWN TIMER SECTION*/
    private void startTimer() {
        new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateTimerProgress();
            }

            @Override
            public void onFinish() {
                if (quesNumber != sizeOfList) {
                    resetTimer();
                    startTimer();
                    nextQuestion();
                }
                /*TODO: SHOW RESULT*/
            }
        }.start();

        mTimerRunning = true;
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateTimerProgress();
    }

    private void updateTimerProgress() {
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        timeRemainingProgress.setProgress(seconds*4);
    }
}
