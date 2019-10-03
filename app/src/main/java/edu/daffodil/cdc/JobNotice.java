package edu.daffodil.cdc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

import edu.daffodil.cdc.adapters.JobNoticeAdapter;
import edu.daffodil.cdc.model.OnItemClick;
import edu.daffodil.cdc.resources.AllJobs;
import edu.daffodil.cdc.resources.JobsData;
import edu.daffodil.cdc.resources.JsonPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JobNotice extends AppCompatActivity {
    private static final String TAG = "JobNotice";

    private List<JobsData> data;

    private RecyclerView mRecyclerViewJobs;

    private JobNoticeAdapter jobNoticeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_notice);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Job notice");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mRecyclerViewJobs = findViewById(R.id.jobNoticeRV);
        mRecyclerViewJobs.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerViewJobs.setHasFixedSize(true);

        new JobNoticeApiCall().execute();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }


    @SuppressLint("StaticFieldLeak")
    class JobNoticeApiCall extends AsyncTask<Void, Void, AllJobs> {


        @Override
        protected AllJobs doInBackground(Void... voids) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(JsonPlaceHolderApi.BASE_JOBS_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            JsonPlaceHolderApi api = retrofit.create(JsonPlaceHolderApi.class);

            Call<AllJobs> call = api.getAllJobs();
            try {
                return call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(AllJobs allJobs) {

            ProgressBar loading = findViewById(R.id.progressBar);
            loading.setVisibility(View.INVISIBLE);

            if (allJobs == null) {
                Toast.makeText(JobNotice.this, "Something went wrong! Please try again later.", Toast.LENGTH_SHORT).show();
                return;
            }

            data = allJobs.getJobsData();
            jobNoticeAdapter = new JobNoticeAdapter(JobNotice.this, data);

            mRecyclerViewJobs.setAdapter(jobNoticeAdapter);

            jobNoticeAdapter.setOnItemClickListener(new OnItemClick() {
                @Override
                public void onItemClicked(int position) {
                    Intent sharedIntent = new Intent(JobNotice.this, JobInfoViewerActivity.class);
                    sharedIntent.putExtra("JOB_ID", data.get(position).getId());
                    sharedIntent.putExtra("JOB_TITLE", data.get(position).getJobTitle());
                    sharedIntent.putExtra("COMPANY_NAME", data.get(position).getCompanyName());
                    sharedIntent.putExtra("LOCATION", data.get(position).getJobDeadline().getTimezone());

                    startActivity(sharedIntent);
                }
            });

        }
    }
}
