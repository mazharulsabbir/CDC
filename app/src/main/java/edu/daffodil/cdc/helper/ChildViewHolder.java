package edu.daffodil.cdc.helper;

import android.view.View;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import edu.daffodil.cdc.R;

public class ChildViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder {
    private TextView mTextView;

    private OnClickListenerChild onClickListenerChild;


    public ChildViewHolder(View itemView) {
        super(itemView);
        mTextView=itemView.findViewById(R.id.textView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListenerChild!=null){
                    int position=getAdapterPosition();
                    if (position!= RecyclerView.NO_POSITION){

                        onClickListenerChild.clickListener(position);
                    }
                }
            }
        });
    }

    public void bind(ChildExpandable product){
        mTextView.setText(product.name);
    }

    public void ItemClickListener(OnClickListenerChild child){

        onClickListenerChild=child;
    }


    public interface OnClickListenerChild{
        void clickListener(int position);

    }
}
