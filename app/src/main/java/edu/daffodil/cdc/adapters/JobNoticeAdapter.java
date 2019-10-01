package edu.daffodil.cdc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.daffodil.cdc.R;
import edu.daffodil.cdc.resources.JobsData;

public class JobNoticeAdapter extends RecyclerView.Adapter<JobNoticeAdapter.JobNoticeViewHolder> {
    private Context context;
    private List<JobsData> data;

    public JobNoticeAdapter(Context context, List<JobsData> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public JobNoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.example_layout_job_notice, parent, false);
        return new JobNoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobNoticeViewHolder holder, int position) {
        JobsData jobsData = data.get(position);

        holder.jobCompanyName.setText(jobsData.getCompanyName());
        holder.jobVacancyName.setText(jobsData.getJobTitle());
        holder.jobDeadLine.setText(jobsData.getJobDeadline().getDate());
        holder.jobLocation.setText(jobsData.getJobDeadline().getTimezone());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class JobNoticeViewHolder extends RecyclerView.ViewHolder {
        ImageView jobIV;
        TextView jobCompanyName, jobVacancyName, jobLocation, jobSalary, jobDeadLine, jobExperience;
        ImageButton menuFavorite, menuNotFavorite, menuShareJob;

        public JobNoticeViewHolder(@NonNull View itemView) {
            super(itemView);
            jobIV = itemView.findViewById(R.id.imageView2);
            jobCompanyName = itemView.findViewById(R.id.job_company_name);
            jobVacancyName = itemView.findViewById(R.id.job_vacancy_name);
            jobLocation = itemView.findViewById(R.id.job_location);
            jobSalary = itemView.findViewById(R.id.job_salary);
            jobDeadLine = itemView.findViewById(R.id.job_dead_line);
            jobExperience = itemView.findViewById(R.id.job_experience);
//            menuFavorite = itemView.findViewById(R.id.menu_favorite);
//            menuNotFavorite = itemView.findViewById(R.id.menu_not_favorite);
//            menuShareJob = itemView.findViewById(R.id.menu_share_job);
        }
    }
}
