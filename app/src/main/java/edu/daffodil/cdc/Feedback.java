package edu.daffodil.cdc;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Feedback extends AppCompatActivity {

    private TextInputLayout userName, userEmail, userFeedBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        userName = findViewById(R.id.user_name);
        userEmail = findViewById(R.id.email_address);
        userFeedBack = findViewById(R.id.write_feedback);

        findViewById(R.id.sent_feedback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, email, feedback;

                name = userName.getEditText().getText().toString().trim();
                email = userEmail.getEditText().getText().toString().trim();
                feedback = userFeedBack.getEditText().getText().toString().trim();


                sendFeedBack(name,email,feedback);
            }
        });
    }

    private void sendFeedBack(String name, String email, String feedback) {

    }
}
