package edu.daffodil.cdc.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import edu.daffodil.cdc.R;
import edu.daffodil.cdc.helper.ChildExpandable;
import edu.daffodil.cdc.helper.ParentExpandable;
import edu.daffodil.cdc.helper.ParentViewHolder;

public class ExpandableAdapter extends ExpandableRecyclerViewAdapter<ParentViewHolder, ExpandableAdapter.ChildViewHolder> {
    private OnClickListenerChild onClickListenerChild;

    public ExpandableAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public ParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recyclerview_paren, parent, false);
        return new ParentViewHolder(v);
    }

    @Override
    public ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recyclerview_child, parent, false);

        return new ChildViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder holder, int flatPosition, final ExpandableGroup group, final int childIndex) {
        holder.position(childIndex);
        final ChildExpandable product = (ChildExpandable) group.getItems().get(childIndex);
        holder.bind(product);
    }

    @Override
    public void onBindGroupViewHolder(ParentViewHolder holder, int flatPosition, ExpandableGroup group) {

        final ParentExpandable company = (ParentExpandable) group;
        holder.bind(company);
    }

    public class ChildViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder {
        private TextView mTextView;
        private int pos;

        public ChildViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (onClickListenerChild != null) {
                        int index = getAdapterPosition();
                        if (index != RecyclerView.NO_POSITION) {
                            onClickListenerChild.clickListener(pos);
                        }
                    }
                }
            });
        }

        public void bind(ChildExpandable product) {
            mTextView.setText(product.name);
        }

        public void position(int pos) {
            this.pos = pos;
        }

    }

    public void onChildClickListener(OnClickListenerChild clickListenerChild) {
        this.onClickListenerChild = clickListenerChild;
    }

    public interface OnClickListenerChild {
        void clickListener(int position);
    }

}
