package edu.daffodil.cdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class UsefulLinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useful_links);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Useful links");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void Link1(View view) {
       String url = "https://cdc.daffodilvarsity.edu.bd/images/home/Guide-to-writing-your_CV.pdf";
       LinkIntent(url);
    }

    public void Link2(View view) {
        String url = "https://cdc.daffodilvarsity.edu.bd/images/home/How-to-tailor-your-CV.pdf";
        LinkIntent(url);

    }

    public void Link3(View view) {
        String url = "https://cdc.daffodilvarsity.edu.bd/images/home/Interview-checklist.pdf";
        LinkIntent(url);
    }

    public void Link4(View view) {
        String url = "https://cdc.daffodilvarsity.edu.bd/images/home/LinkedIn-profile.pdf";
        LinkIntent(url);
    }

    public void Link5(View view) {
        String url = "https://cdc.daffodilvarsity.edu.bd/images/home/Preparing-for-an-interview.pdf";
        LinkIntent(url);
    }

    public void Link6(View view) {
        String url = "http://www.bestcoverletters.com/";
        LinkIntent(url);
    }

    public void Link7(View view) {
        String url = "https://www.livecareer.com/resumes/samples";
        LinkIntent(url);
    }

    public void Link8(View view) {
        String url = "https://www.youtube.com/channel/UCTPyiQe9BjUkp5xxLsVDCcA/videos";
        LinkIntent(url);
    }

    public void Link9(View view) {
        String url = "https://www.youtube.com/watch?v=oRBKNk-AXvw&t=1s";
        LinkIntent(url);
    }

    public void Link10(View view) {
        String url = "https://cdc.daffodilvarsity.edu.bd/images/home/Guideline-for-VideoResume.pdf";
        LinkIntent(url);
    }

    public void Link11(View view) {
        String url = "https://www.youtube.com/watch?v=F50XNq8yaZ0";
        LinkIntent(url);
    }

    public void Link12(View view) {
        String url = "https://www.youtube.com/watch?v=hzm5OIOrwNs";
        LinkIntent(url);
    }

    public void Link13(View view) {
        String url = "https://www.youtube.com/watch?v=3klRgz1F6fE";
        LinkIntent(url);
    }

    public void Link14(View view) {
        String url = "https://www.youtube.com/watch?v=CR7nV2KkLds";
        LinkIntent(url);
    }

    public void Link15(View view) {
        String url = "https://www.prothomalo.com/education/article/1558674/%E0%A6%95%E0%A7%80%E0%A6%AD%E0%A6%BE%E0%A6%AC%E0%A7%87-%E0%A6%B8%E0%A6%BF%E0%A6%AD%E0%A6%BF-%E0%A6%A4%E0%A7%88%E0%A6%B0%E0%A6%BF-%E0%A6%95%E0%A6%B0%E0%A6%AC";
        LinkIntent(url);
    }

    public void Link16(View view) {
        String url = "https://docs.google.com/document/d/14SAlKfB5-DB2EwMS53pXrfHnHDbsXraEZ4ST6T_eRmQ/edit";
        LinkIntent(url);
    }

    private void LinkIntent(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
