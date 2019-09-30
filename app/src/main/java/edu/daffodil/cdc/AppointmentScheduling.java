package edu.daffodil.cdc;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class AppointmentScheduling extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private TextInputLayout userName, userEmail, userMessage, appointmentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_scheduling);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Appointment Scheduling");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        userName = findViewById(R.id.user_name);
        userEmail = findViewById(R.id.email_address);
        userMessage = findViewById(R.id.describe_reason);
        appointmentDate = findViewById(R.id.appointment_date);

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
        boolean emptyString = false;
        String name = "", email = "", date = "", appointmentReason = "";

        name = userName.getEditText().getText().toString().trim();
        email = userEmail.getEditText().getText().toString().trim();
        date = appointmentDate.getEditText().getText().toString().trim();
        appointmentReason = userMessage.getEditText().getText().toString().trim();

        if (name.length() == 0) {
            userName.setErrorEnabled(true);
            userName.setError("This field is required!");
            emptyString = true;
        } else {
            userName.setErrorEnabled(false);
        }

        if (email.length() == 0) {
            userEmail.setErrorEnabled(true);
            userEmail.setError("This field is required!");
            emptyString = true;
        } else {
            userEmail.setErrorEnabled(false);
        }

        if (date.length() == 0) {
            appointmentDate.setErrorEnabled(true);
            appointmentDate.setError("This field is required!");
            emptyString = true;
        } else {
            appointmentDate.setErrorEnabled(false);
        }

        if (appointmentReason.length() == 0) {
            userMessage.setErrorEnabled(true);
            userMessage.setError("This field is required!");
            emptyString = true;
        } else {
            userMessage.setErrorEnabled(false);
        }

        if (emptyString)
            return;


        sendMail(name,email,date,appointmentReason);


    }

    private void sendMail(String name, String email, String date, String appointmentReason) {
        String msg = "Name: "+name+
                "\nEmail: "+email+
                "\nDate: "+date+
                "\nReason: "+appointmentReason;

        Intent intent = new Intent(Intent.ACTION_SEND);

        String[] strTo = {"ncdc@daffodilvarsity.edu.bd"};

        intent.putExtra(Intent.EXTRA_EMAIL, strTo);
        intent.putExtra(Intent.EXTRA_SUBJECT, "CDC App Contact");
        intent.putExtra(Intent.EXTRA_TEXT, msg);

        intent.setType("message/rfc822");
        intent.setPackage("com.google.android.gm");
        startActivity(intent);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + " / " + month + " / " + year;
        appointmentDate.getEditText().setText(date);
    }
}
