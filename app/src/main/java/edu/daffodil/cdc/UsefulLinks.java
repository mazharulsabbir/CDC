package edu.daffodil.cdc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

import edu.daffodil.cdc.adapters.LinkAdapter;

import edu.daffodil.cdc.model.UsefulLinkHelper;

public class UsefulLinks extends AppCompatActivity {
    private RecyclerView linkRV;
    private LinkAdapter linkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useful_links);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Useful links");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        linkRV = findViewById(R.id.linkRV);

        linkAdapter = new LinkAdapter(this,getUsefulLinks());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        linkRV.setLayoutManager(layoutManager);
        linkRV.setAdapter(linkAdapter);



    }

    private ArrayList<UsefulLinkHelper> getUsefulLinks(){
        ArrayList<UsefulLinkHelper> linkList = new ArrayList<>();
        linkList.add(new UsefulLinkHelper("Guide to writing your CV (PDF)","https://cdc.daffodilvarsity.edu.bd/images/home/Guide-to-writing-your_CV.pdf"));
        linkList.add(new UsefulLinkHelper("How to tailor your CV (PDF)","https://cdc.daffodilvarsity.edu.bd/images/home/How-to-tailor-your-CV.pdf"));
        linkList.add(new UsefulLinkHelper("Interview Preparation Checklist (PDF)","https://cdc.daffodilvarsity.edu.bd/images/home/Interview-checklist.pdf"));
        linkList.add(new UsefulLinkHelper("Building and improving your LinkedIn profile","https://cdc.daffodilvarsity.edu.bd/images/home/LinkedIn-profile.pdf"));
        linkList.add(new UsefulLinkHelper("Preparing for an interview","https://cdc.daffodilvarsity.edu.bd/images/home/Preparing-for-an-interview.pdf"));
        linkList.add(new UsefulLinkHelper("Best Cover Letters","http://www.bestcoverletters.com/"));
        linkList.add(new UsefulLinkHelper("Free Resume Samples & Examples","https://www.livecareer.com/resumes/samples"));
        linkList.add(new UsefulLinkHelper("Employability 360 Channel","https://www.youtube.com/channel/UCTPyiQe9BjUkp5xxLsVDCcA/videos"));
        linkList.add(new UsefulLinkHelper("Video Resume Demo","https://www.youtube.com/watch?v=oRBKNk-AXvw&t=1s"));
        linkList.add(new UsefulLinkHelper("Guideline on Video Resume preparation (PDF)-","https://cdc.daffodilvarsity.edu.bd/images/home/Guideline-for-VideoResume.pdf"));
        linkList.add(new UsefulLinkHelper("CV vs Résumé ","https://www.youtube.com/watch?v=F50XNq8yaZ0"));
        linkList.add(new UsefulLinkHelper("Corporate Grooming/Formal etiquette for job","https://www.youtube.com/watch?v=hzm5OIOrwNs"));
        linkList.add(new UsefulLinkHelper("How to write a CV/Résume","https://www.youtube.com/watch?v=3klRgz1F6fE"));
        linkList.add(new UsefulLinkHelper("Introduce yourself Common interview question and answer","https://www.youtube.com/watch?v=CR7nV2KkLds"));
        linkList.add(new UsefulLinkHelper("How to prepare CV by Prothom Alo","https://www.prothomalo.com/education/article/1558674/%E0%A6%95%E0%A7%80%E0%A6%AD%E0%A6%BE%E0%A6%AC%E0%A7%87-" +
                "%E0%A6%B8%E0%A6%BF%E0%A6%AD%E0%A6%BF-%E0%A6%A4%E0%A7%88%E0%A6%B0%E0%A6%BF-%E0%A6%95%E0%A6%B0%E0%A6%AC"));
        linkList.add(new UsefulLinkHelper("Career related Articles","https://docs.google.com/document/d/14SAlKfB5-DB2EwMS53pXrfHnHDbsXraEZ4ST6T_eRmQ/edit"));

        return linkList;


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
