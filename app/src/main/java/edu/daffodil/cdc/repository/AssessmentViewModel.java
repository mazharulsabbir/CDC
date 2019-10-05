package edu.daffodil.cdc.repository;

import android.app.Application;
import android.os.CountDownTimer;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.daffodil.cdc.model.Assessments;

public class AssessmentViewModel extends AndroidViewModel {

    public static final long START_TIME_IN_MILLIS = 15000;
    public int quesNumber = 0;
    public int sizeOfList;
    public boolean mTimerRunning;
    public CountDownTimer mCountDownTimer;
    public long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    public int orientedTimes = 0;

    private LiveData<List<Assessments>> listLiveData;

    public AssessmentViewModel(@NonNull Application application) {
        super(application);

        AssessmentRepository assessmentRepository = new AssessmentRepository(application);
        listLiveData = assessmentRepository.getAllAssessments();
    }

    public LiveData<List<Assessments>> getAllAssessments() {
        return listLiveData;
    }
}
