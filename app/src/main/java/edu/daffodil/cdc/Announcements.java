package edu.daffodil.cdc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Announcements extends AppCompatActivity {

    private RecyclerView annoucementRV;

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
}
