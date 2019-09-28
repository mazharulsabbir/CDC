package edu.daffodil.cdc;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AppointmentScheduling extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_scheduling);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Appointment Scheduling");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        findViewById(R.id.submit_appointment_form).setOnClickListener(this);
        findViewById(R.id.date_picker_btn).setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_appointment_form:
                submitRequest();
                break;

            case R.id.date_picker_btn:

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        this,
                        AppointmentScheduling.this,
                        year,
                        month + 1,
                        day);

                datePickerDialog.show();
                break;


        }

    }

    private void submitRequest() {

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }
}
