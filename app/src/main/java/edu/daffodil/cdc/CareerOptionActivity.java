package edu.daffodil.cdc;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import edu.daffodil.cdc.fragment.DepartmentList;

public class CareerOptionActivity extends AppCompatActivity {
    TextView title_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_option);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Career Option");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        openFragment();

    }

    private void openFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.disallowAddToBackStack(); //to remove back fragment
        transaction.replace(R.id.container, new DepartmentList())
                .commit();
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
