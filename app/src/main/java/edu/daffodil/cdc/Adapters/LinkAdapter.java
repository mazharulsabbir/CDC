package edu.daffodil.cdc.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.daffodil.cdc.R;
import edu.daffodil.cdc.UsefulLinkHelper;

public class LinkAdapter extends RecyclerView.Adapter<LinkAdapter.LinkViewHolder> {
    private Context context;
    private ArrayList<UsefulLinkHelper> linkList;

    public LinkAdapter(Context context, ArrayList<UsefulLinkHelper> linkList) {
        this.context = context;
        this.linkList = linkList;
    }

    @NonNull
    @Override
    public LinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_card,parent,false);
        return new LinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LinkViewHolder holder, int position) {
        holder.linkName.setText(linkList.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return linkList.size();
    }


    public class LinkViewHolder extends RecyclerView.ViewHolder {
        TextView linkName;
        public LinkViewHolder(@NonNull View itemView) {
            super(itemView);

            linkName = itemView.findViewById(R.id.linkNameTV);
        }
    }
}
