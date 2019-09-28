package edu.daffodil.cdc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import edu.daffodil.cdc.Adapters.AnnounceAdapters;

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
