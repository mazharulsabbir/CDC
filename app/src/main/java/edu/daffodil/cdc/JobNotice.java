package edu.daffodil.cdc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class JobNotice extends AppCompatActivity {

    private RecyclerView jobNoticeRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_notice);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Job notice");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        jobNoticeRV = findViewById(R.id.jobNoticeRV);
    }
}
