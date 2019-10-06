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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Dashboard");
//            getSupportActionBar().setHomeButtonEnabled(true);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_settings);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        /*set the background image of profiles*/
        ImageView imageView = findViewById(R.id.profile_background);
        Picasso.get()
                .load(R.drawable.pro_background)
                .resize(100,100)
                .into(imageView);

        /*item name array for dashboard items*/
        String[] name = getResources().getStringArray(R.array.dashboard);/*GET NAME FROM STRING RESOURCES*/
        /*image resources for dashboard items*/
        int[] icon = {R.drawable.career_planning,
                R.drawable.self_assessment,
                R.drawable.schedule_appointment,
                R.drawable.career_option,
                R.drawable.briefcase_96px,
                R.drawable.ic_announcement,
                R.drawable.link_104px,
                R.drawable.feedback_100px,
                R.drawable.phone_96px};
        CustomAdapter adapter = new CustomAdapter(this, icon, name);
        recyclerView.setAdapter(adapter);
    }


    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
        private Context context;
        private int[] icon;
        private String[] name;

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
