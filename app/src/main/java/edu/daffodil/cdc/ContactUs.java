package edu.daffodil.cdc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ContactUs extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Contact Us");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        findViewById(R.id.fab_phone).setOnClickListener(this);
        findViewById(R.id.fab_call).setOnClickListener(this);
        findViewById(R.id.fab_email).setOnClickListener(this);
        findViewById(R.id.fab_location).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_phone:

            case R.id.fab_call:
                actionCall("");
            case R.id.fab_email:
                actionEmail("");
            case R.id.fab_location:
                actionLocation();
        }
    }

    private void actionLocation() {

    }

    private void actionEmail(String email) {

        Intent intent = new Intent(Intent.ACTION_SEND);
//        String[] strTo = {"someone@host.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.EXTRA_SUBJECT, "CDC App Contact");
        intent.setType("message/rfc822");
        intent.setPackage("com.google.android.gm");
        startActivity(intent);
    }

    private void actionCall(String number) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        startActivity(intent);
    }
}
