package edu.daffodil.cdc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.daffodil.cdc.R;
import edu.daffodil.cdc.model.AnnouncementHelper;

public class AnnounceAdapters extends RecyclerView.Adapter<AnnounceAdapters.AnnounceViewHolder> {

    private Context context;
    private List<AnnouncementHelper> announcementHelperList;

    public AnnounceAdapters(Context context, List<AnnouncementHelper> announcementHelperList) {
        this.context = context;
        this.announcementHelperList = announcementHelperList;
    }

    @NonNull
    @Override
    public AnnounceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.example_announcement, parent, false);
        return new AnnounceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnounceViewHolder holder, int position) {
        AnnouncementHelper helper = announcementHelperList.get(position);

        holder.titleTV.setText(helper.getTitle());
        holder.messageTV.setText(helper.getMessage());
        holder.dateTV.setText(helper.getDate());

    }

    @Override
    public int getItemCount() {
        return announcementHelperList.size();
    }

    public class AnnounceViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTV, dateTV, messageTV;

        public AnnounceViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.m_Image_View);
            titleTV = itemView.findViewById(R.id.m_title);
            dateTV = itemView.findViewById(R.id.m_date);
            messageTV = itemView.findViewById(R.id.expandable_text);
        }
    }
}
