package edu.daffodil.cdc.repository;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.daffodil.cdc.model.Assessments;

public class AssessmentViewModel extends AndroidViewModel {
    private AssessmentRepository assessmentRepository;

    private LiveData<List<Assessments>> listLiveData;

    public AssessmentViewModel(@NonNull Application application) {
        super(application);

        assessmentRepository = new AssessmentRepository(application);
        listLiveData = assessmentRepository.getAllAssessments();
    }

    public LiveData<List<Assessments>> getAllAssessments() {
        return listLiveData;
    }
}
