package edu.daffodil.cdc.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import edu.daffodil.cdc.R;
import edu.daffodil.cdc.helper.ChildViewHolder;
import edu.daffodil.cdc.helper.ParentExpandable;
import edu.daffodil.cdc.helper.ParentViewHolder;
import edu.daffodil.cdc.helper.ChildExpandable;

public class ProductAdapter extends ExpandableRecyclerViewAdapter<ParentViewHolder, ChildViewHolder> {
    public ProductAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public ParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recyclerview_paren,parent,false);
        return new ParentViewHolder(v);
    }

    @Override
    public ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recyclerview_child,parent,false);
        return new ChildViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {

        final ChildExpandable product= (ChildExpandable) group.getItems().get(childIndex);
        holder.bind(product);
    }

    @Override
    public void onBindGroupViewHolder(ParentViewHolder holder, int flatPosition, ExpandableGroup group) {

        final ParentExpandable company= (ParentExpandable) group;
        holder.bind(company);
    }
}
