package edu.daffodil.cdc;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.daffodil.cdc.Adapters.JobNoticeAdapter;
import edu.daffodil.cdc.RESTApi.AllJobs;
import edu.daffodil.cdc.RESTApi.JobsData;
import edu.daffodil.cdc.RESTApi.JsonPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JobNotice extends AppCompatActivity {
    private static final String TAG = "JobNotice";

    private List<JobsData> data;
    private List<JobsData> limitedData;

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

        getResponse();
    }

    private void getResponse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JsonPlaceHolderApi.BASE_JOBS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi api = retrofit.create(JsonPlaceHolderApi.class);

        Call<AllJobs> call = api.getAllJobs();
        call.enqueue(new Callback<AllJobs>() {
                         @Override
                         public void onResponse(Call<AllJobs> call, Response<AllJobs> response) {
                             if (!response.isSuccessful()) {
                                 Log.i(TAG, "onResponse: " + response.message() + ":" + response.code());
                                 Toast.makeText(JobNotice.this, response.code(), Toast.LENGTH_SHORT).show();
                                 return;
                             }

                             data = new ArrayList<>();
                             limitedData = new ArrayList<>();

                             data = response.body().getJobsData();
                             jobNoticeAdapter = new JobNoticeAdapter(JobNotice.this, data);

                             mRecyclerViewJobs.setAdapter(jobNoticeAdapter);
                         }

                         @Override
                         public void onFailure(Call<AllJobs> call, Throwable t) {
                             Log.e(TAG, "onFailure: ", t);
                             //Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                         }
                     }
        );
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
