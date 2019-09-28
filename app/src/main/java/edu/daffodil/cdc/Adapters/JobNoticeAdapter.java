package edu.daffodil.cdc.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.daffodil.cdc.R;

public class JobNoticeAdapter extends RecyclerView.Adapter<JobNoticeAdapter.JobNoticeViewHolder> {
    private Context context;

    @NonNull
    @Override
    public JobNoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.example_layout_job_notice,parent,false);
        return new JobNoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobNoticeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class JobNoticeViewHolder extends RecyclerView.ViewHolder {
        ImageView jobIV;
        TextView jobCompanyName,jobVacancyName,jobLocation,jobSalary,jobDeadLine,jobExperience;
        ImageButton menuFavorite,menuNotFavorite,menuShareJob;
        public JobNoticeViewHolder(@NonNull View itemView) {
            super(itemView);
            jobIV = itemView.findViewById(R.id.imageView2);
            jobCompanyName = itemView.findViewById(R.id.job_company_name);
            jobVacancyName = itemView.findViewById(R.id.job_vacancy_name);
            jobLocation = itemView.findViewById(R.id.job_location);
            jobSalary = itemView.findViewById(R.id.job_salary);
            jobDeadLine = itemView.findViewById(R.id.job_dead_line);
            jobExperience = itemView.findViewById(R.id.job_experience);
            menuFavorite = itemView.findViewById(R.id.menu_favorite);
            menuNotFavorite = itemView.findViewById(R.id.menu_not_favorite);
            menuShareJob = itemView.findViewById(R.id.menu_share_job);
        }
    }
}
