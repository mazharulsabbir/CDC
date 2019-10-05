package edu.daffodil.cdc.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import edu.daffodil.cdc.model.Assessments;

@Database(entities = {Assessments.class}, version = 1)
public abstract class AssessmentDatabase extends RoomDatabase {

    public static AssessmentDatabase assessmentDatabaseInstance;

    public static synchronized AssessmentDatabase getInstance(Context context) {
        if (assessmentDatabaseInstance == null) {
            assessmentDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                    AssessmentDatabase.class, "assessments")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }

        return assessmentDatabaseInstance;
    }

    public static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(assessmentDatabaseInstance).execute();
        }
    };

    public abstract AssessmentDao assessmentDao();

    public static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{

        private AssessmentDao assessmentDao;

        public PopulateDbAsyncTask(AssessmentDatabase db) {
            assessmentDao = db.assessmentDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            assessmentDao.insert(new Assessments("This is ques1",
                    "ans1",
                    "ans2",
                    "ans3",
                    "ans4"
            ));

            assessmentDao.insert(new Assessments("This is ques2",
                    "ans1",
                    "ans2",
                    "ans3",
                    "ans4"
            ));

            assessmentDao.insert(new Assessments("This is ques3",
                    "ans1",
                    "ans2",
                    "ans3",
                    "ans4"
            ));

            assessmentDao.insert(new Assessments("This is ques4",
                    "ans1",
                    "ans2",
                    "ans3",
                    "ans4"
            ));

            assessmentDao.insert(new Assessments("This is ques5",
                    "ans1",
                    "ans2",
                    "ans3",
                    "ans4"
            ));
            return null;
        }
    }
}
