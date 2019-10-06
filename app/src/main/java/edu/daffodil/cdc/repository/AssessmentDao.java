package edu.daffodil.cdc.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import edu.daffodil.cdc.model.Assessments;

@Dao
public interface AssessmentDao {

    @Insert
    void insert(Assessments assessments);

    @Query("DELETE FROM assessments")
    void deleteAllQuestions();

    @Query("SELECT * FROM assessments ORDER BY question")
    LiveData<List<Assessments>> getAllAssessments();
}
