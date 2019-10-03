package edu.daffodil.cdc.helper;

import android.view.View;
import android.widget.TextView;


import edu.daffodil.cdc.R;

public class ChildViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder {
    private TextView mTextView;

    public ChildViewHolder(View itemView) {
        super(itemView);
        mTextView=itemView.findViewById(R.id.textView);
    }

    public void bind(ChildExpandable product){
        mTextView.setText(product.name);
    }
}
