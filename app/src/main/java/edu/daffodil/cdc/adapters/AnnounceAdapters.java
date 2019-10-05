package edu.daffodil.cdc.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.daffodil.cdc.R;
import edu.daffodil.cdc.resources.Announcement;

public class AnnounceAdapters extends RecyclerView.Adapter<AnnounceAdapters.AnnounceViewHolder> {

    private Context context;
    private List<Announcement> announcementList;

    public AnnounceAdapters(Context context, List<Announcement> announcementList) {
        this.context = context;
        this.announcementList = announcementList;
    }

    @NonNull
    @Override
    public AnnounceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.example_announcement, parent, false);
        return new AnnounceViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AnnounceViewHolder holder, int position) {
        Announcement helper = announcementList.get(position);

        holder.titleTV.setText(helper.getFileName());
        holder.department.setText(helper.getDepeartment());
        holder.iconText.setText(String.valueOf(helper.getDepeartment().charAt(0)));
        holder.dateTV.setText("Published On: " + helper.getDate());

    }

    @Override
    public int getItemCount() {
        return announcementList.size();
    }

    public class AnnounceViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV, dateTV, iconText, department;

        public AnnounceViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.m_title);
            dateTV = itemView.findViewById(R.id.m_date);
            iconText = itemView.findViewById(R.id.textView);
            department = itemView.findViewById(R.id.department);
        }
    }

}
