package edu.daffodil.cdc;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Feedback extends AppCompatActivity {

    private TextInputLayout userName, userEmail, userFeedBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("FeedBack");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        userName = findViewById(R.id.user_name);
        userEmail = findViewById(R.id.email_address);
        userFeedBack = findViewById(R.id.write_feedback);

        findViewById(R.id.sent_feedback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean emptyString = false;
                String name = "", email = "", feedback = "";

                name = userName.getEditText().getText().toString().trim();
                email = userEmail.getEditText().getText().toString().trim();
                feedback = userFeedBack.getEditText().getText().toString().trim();

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

                if (feedback.length() == 0) {
                    userFeedBack.setErrorEnabled(true);
                    userFeedBack.setError("This field is required!");
                    emptyString = true;
                } else {
                    userFeedBack.setErrorEnabled(false);
                }

                if (emptyString)
                    return;

                sendFeedBack(name, email, feedback);
            }
        });
    }

    private void sendFeedBack(String name, String email, String feedback) {
        String msg = "Name: " + name +
                "\nEmail: " + email +
                "\nFeedback: " + feedback;

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
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }
}
