package edu.daffodil.cdc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CareerOptionActivity extends AppCompatActivity {

    String [] departmentList;
    private Spinner spinner;
    private RecyclerView careerRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_option);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Career option");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        careerRV = findViewById(R.id.careerRV);


        departmentList = getResources().getStringArray(R.array.depertmentList);
        spinner = findViewById(R.id.depSp);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.spinner_dep_list,R.id.depTV,departmentList);
        spinner.setAdapter(adapter);

    }
}
