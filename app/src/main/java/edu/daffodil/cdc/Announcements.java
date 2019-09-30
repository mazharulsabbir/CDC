package edu.daffodil.cdc;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.daffodil.cdc.Adapters.AnnounceAdapters;
import edu.daffodil.cdc.model.AnnouncementHelper;

public class Announcements extends AppCompatActivity {

    private RecyclerView annoucementRV;
    private AnnounceAdapters announceAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Announcements");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        annoucementRV = findViewById(R.id.announceRV);
        annoucementRV.setHasFixedSize(true);
        annoucementRV.setLayoutManager(new LinearLayoutManager(this));

        List<AnnouncementHelper> helpers = new ArrayList<>();
        helpers.add(new AnnouncementHelper("Title", "Message", "Date"));

        announceAdapters = new AnnounceAdapters(this, helpers);
        annoucementRV.setAdapter(announceAdapters);

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
