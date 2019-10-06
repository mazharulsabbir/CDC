package edu.daffodil.cdc;

import android.annotation.SuppressLint;
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

    private static final String TAG = "SelfAssessment";

    private List<Assessments> assessmentsList;
    private ProgressBar timeRemainingProgress;
    private TextView textViewQuestion;
    private MaterialButton answer1, answer2, answer3, answer4;
    private MaterialButton skipAns;

    private AssessmentViewModel assessmentViewModel;

    private Toast toast;

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

        assessmentViewModel = ViewModelProviders.of(this)
                .get(AssessmentViewModel.class);

        assessmentViewModel.getAllAssessments().observe(this,
                new Observer<List<Assessments>>() {
                    @Override
                    public void onChanged(List<Assessments> assessments) {
                        assessmentsList.clear();
                        assessmentsList = assessments;

                        assessmentViewModel.sizeOfList = assessmentsList.size();

                        showQuestion();

                        startTimer();
                        updateTimerProgress();
                    }
                }
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        assessmentViewModel.mCountDownTimer.cancel();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (assessmentViewModel.mTimerRunning)
            assessmentViewModel.mCountDownTimer.cancel();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ans1 | v.getId() == R.id.ans2 | v.getId() == R.id.ans3 | v.getId() == R.id.ans4) {
            checkAnswer();
        }

        if (v.getId() == R.id.skip_ques) {
            showQuestion();
            resetTimer();
        }
    }

    @SuppressLint("SetTextI18n")
    private void showQuestion() {

        if (assessmentsList.size() == 0)
            return;

        if (assessmentsList.size() > assessmentViewModel.quesNumber) {
            TextView n = findViewById(R.id.question_number);
            int m = assessmentViewModel.quesNumber;
            n.setText("Q" + (m + 1));

            Assessments assessments = assessmentsList.get(assessmentViewModel.quesNumber);
            textViewQuestion.setText(assessments.getQuestion());
            answer1.setText(assessments.getAns1());
            answer2.setText(assessments.getAns2());
            answer3.setText(assessments.getAns3());
            answer4.setText(assessments.getAns4());

        } else {
            assessmentViewModel.mCountDownTimer.cancel();
            resetTimer();

            TextView n = findViewById(R.id.question_number);
            int m = assessmentViewModel.quesNumber;
            n.setText("Q" + (m));

            Assessments assessments = assessmentsList.get(assessmentViewModel.quesNumber - 1);
            textViewQuestion.setText(assessments.getQuestion());
            answer1.setText(assessments.getAns1());
            answer2.setText(assessments.getAns2());
            answer3.setText(assessments.getAns3());
            answer4.setText(assessments.getAns4());

            Toast.makeText(this, "No More Questions!", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkAnswer() {

        /*check the answer is correct or not*/
        /*TODO: CHECK THE GIVEN ANSWER*/

        /*show next questions*/
        resetTimer();

        showQuestion();
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
        assessmentViewModel.mCountDownTimer = new CountDownTimer(assessmentViewModel.mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                assessmentViewModel.mTimeLeftInMillis = millisUntilFinished;
                updateTimerProgress();
            }

            @Override
            public void onFinish() {
                assessmentViewModel.quesNumber++;

                if (assessmentViewModel.quesNumber < assessmentViewModel.sizeOfList) {
                    resetTimer();
                    startTimer();
                    showQuestion();
                } else {
                    timeRemainingProgress.setProgress(15);
                }
                /*TODO: SHOW RESULT*/
            }

        }.start();

        assessmentViewModel.mTimerRunning = true;
    }

    private void resetTimer() {
        assessmentViewModel.mTimeLeftInMillis = AssessmentViewModel.START_TIME_IN_MILLIS;
        updateTimerProgress();
    }

    private void updateTimerProgress() {
        int seconds = (int) (assessmentViewModel.mTimeLeftInMillis / 1000) % 60;
        timeRemainingProgress.setProgress(seconds);
    }
}
