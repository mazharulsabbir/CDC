package edu.daffodil.cdc.repository;

import android.app.Application;
import android.os.AsyncTask;

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

    public void deleteAllQuestions() {
        new DeleteAllQuestions(assessmentDao).execute();
    }

    public LiveData<List<Assessments>> getAllAssessments() {
        return assessmentsList;
    }

    public static class DeleteAllQuestions extends AsyncTask<Void, Void, Void> {

        private AssessmentDao assessmentDao;

        public DeleteAllQuestions(AssessmentDao assessmentDao) {
            this.assessmentDao = assessmentDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            assessmentDao.deleteAllQuestions();
            return null;
        }
    }
}
