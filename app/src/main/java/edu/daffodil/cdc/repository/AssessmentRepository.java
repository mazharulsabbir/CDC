package edu.daffodil.cdc.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.daffodil.cdc.model.Assessments;

public class AssessmentRepository {
    private AssessmentDao assessmentDao;
    private LiveData<List<Assessments>> assessmentsList;


    public AssessmentRepository(Application application) {
        AssessmentDatabase assessmentDatabase = AssessmentDatabase.getInstance(application);

        assessmentDao = assessmentDatabase.assessmentDao();
        assessmentsList = assessmentDao.getAllAssessments();
    }

    public LiveData<List<Assessments>> getAllAssessments(){
        return assessmentsList;
    }
}
