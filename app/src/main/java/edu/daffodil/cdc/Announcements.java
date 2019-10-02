package edu.daffodil.cdc;

import android.annotation.SuppressLint;
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

import edu.daffodil.cdc.adapters.AnnounceAdapters;
import edu.daffodil.cdc.resources.AllAnnouncement;
import edu.daffodil.cdc.resources.Announcement;
import edu.daffodil.cdc.resources.JsonPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Announcements extends AppCompatActivity {

    private RecyclerView annoucementRV;
    private AnnounceAdapters announceAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Announcement");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        annoucementRV = findViewById(R.id.announceRV);
        annoucementRV.setHasFixedSize(true);
        annoucementRV.setLayoutManager(new LinearLayoutManager(this));

        new AnnouncementApiCall().execute();

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
    class AnnouncementApiCall extends AsyncTask<Void, Void, AllAnnouncement> {


        @Override
        protected AllAnnouncement doInBackground(Void... voids) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(JsonPlaceHolderApi.BASE_ANNOUNCEMENT_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            JsonPlaceHolderApi api = retrofit.create(JsonPlaceHolderApi.class);

            Call<AllAnnouncement> call = api.getAnnouncements();
            try {
                return call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(AllAnnouncement announcement) {

            ProgressBar loading = findViewById(R.id.progressBar);
            loading.setVisibility(View.INVISIBLE);

            if (announcement == null) {
                Toast.makeText(Announcements.this, "Something went wrong! Please try again later.", Toast.LENGTH_SHORT).show();
                return;
            }


            List<Announcement> announcementList = announcement.getAnnouncements();

            announceAdapters = new AnnounceAdapters(Announcements.this, announcementList);
            annoucementRV.setAdapter(announceAdapters);

        }
    }
}
