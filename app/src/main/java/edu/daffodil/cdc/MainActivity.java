package edu.daffodil.cdc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;


    int[] icon = {R.drawable.career_planning, R.drawable.self_assessment, R.drawable.schedule_appointment,
            R.drawable.career_option, R.drawable.briefcase_96px, R.drawable.ic_announcement,
            R.drawable.link_104px, R.drawable.feedback_100px,R.drawable.phone_96px};

    String[] name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Dashboard");

        CollapsingToolbarLayout layout  = findViewById(R.id.collapsing_toolbar);
        layout.setTitleEnabled(true);
        layout.setTitle("Dashboard");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        name = new String[9];
        name = getResources().getStringArray(R.array.dashboard);/*GET NAME FROM STRING RESOURCES*/

        CustomAdapter adapter = new CustomAdapter(this, icon, name);
        recyclerView.setAdapter(adapter);


    }


    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
        Context context;
        int[] icon;
        String[] name;


        CustomAdapter(Context context, int[] icon, String[] name) {
            this.context = context;
            this.icon = icon;
            this.name = name;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.dashboard_sample, parent, false);
            return new ViewHolder(v);

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            holder.imageView.setImageResource(icon[position]);
            holder.textView.setText(name[position]);
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (position) {
                        case 0:
                            //career planning map
                            startActivity(new Intent(MainActivity.this, CareerPlanningMap.class));
                            break;

                        case 1:
                            //self assessment
                            startActivity(new Intent(MainActivity.this, SelfAssessment.class));
                            break;

                        case 2:
                            /*SCHEDULE AN APPOINTMENT*/
                            startActivity(new Intent(MainActivity.this, AppointmentScheduling.class));
                            break;

                        case 3:
                            /*CAREER OPTION*/
                            startActivity(new Intent(MainActivity.this, CareerOptionActivity.class));
                            break;

                        case 4:
                            /*JOB NOTICE*/
                            startActivity(new Intent(MainActivity.this, JobNotice.class));
                            break;

                        case 5:
                            /*ANNOUNCEMENT*/
                            startActivity(new Intent(MainActivity.this, Announcements.class));
                            break;

                        case 6:
                            /*USEFUL LINKS*/
                            startActivity(new Intent(MainActivity.this, UsefulLinks.class));
                            break;

                        case 7:
                            /*FEEDBACK*/
                            startActivity(new Intent(MainActivity.this, Feedback.class));
                            break;

                        case 8:
                            /*CONTACT US*/
                            startActivity(new Intent(MainActivity.this, ContactUs.class));
                            break;

                    }
                }
            });


        }

        @Override
        public int getItemCount() {
            return name.length;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView textView;
            CardView cardView;

            ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageViewId);
                textView = itemView.findViewById(R.id.textViewId);
                cardView = itemView.findViewById(R.id.cardView);

            }
        }


    }
}
