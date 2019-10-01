package edu.daffodil.cdc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.daffodil.cdc.R;
import edu.daffodil.cdc.model.JobDetailsViewHelper;
import edu.daffodil.cdc.model.OnItemClick;

public class JobDetailsAdapter extends RecyclerView.Adapter<JobDetailsAdapter.Holder> {
    private List<JobDetailsViewHelper> info;
    private Context context;

    public JobDetailsAdapter(List<JobDetailsViewHelper> info, Context context) {
        this.info = info;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.example_preview_job_details, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        JobDetailsViewHelper helper = info.get(position);
        holder.title.setText(helper.getTitle());
        holder.info.setText(helper.getDescription());

    }

    @Override
    public int getItemCount() {
        return info.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView title, info;

        public Holder(@NonNull View i) {
            super(i);

            title = i.findViewById(R.id.tv_title);
            info = i.findViewById(R.id.tv_info);

        }
    }
}
