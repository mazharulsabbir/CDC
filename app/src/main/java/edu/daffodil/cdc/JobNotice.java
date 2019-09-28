package edu.daffodil.cdc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }
}
