package edu.daffodil.cdc.view.model;

import android.app.Application;
import android.os.CountDownTimer;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.daffodil.cdc.model.Assessments;
import edu.daffodil.cdc.repository.AssessmentRepository;

public class AssessmentViewModel extends AndroidViewModel {

    public static final long START_TIME_IN_MILLIS = 15000;
    public int quesNumber = 0;
    public int sizeOfList;
    public boolean mTimerRunning;
    public CountDownTimer mCountDownTimer;
    public long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    private LiveData<List<Assessments>> listLiveData;

    private AssessmentRepository assessmentRepository;

    public AssessmentViewModel(@NonNull Application application) {
        super(application);

        assessmentRepository = new AssessmentRepository(application);
        listLiveData = assessmentRepository.getAllAssessments();
    }

    public void deleteAllQuestions() {
        assessmentRepository.deleteAllQuestions();
    }

    public LiveData<List<Assessments>> getAllAssessments() {
        return listLiveData;
    }
}
