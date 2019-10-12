package edu.daffodil.cdc.helper;

import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import edu.daffodil.cdc.R;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class ParentViewHolder extends GroupViewHolder {
    TextView mTextView;
    ImageView arrow;

    public ParentViewHolder(View itemView) {
        super(itemView);
        mTextView=itemView.findViewById(R.id.textView);
        arrow=itemView.findViewById(R.id.arrow);
    }

    public void bind(ParentExpandable company){
        mTextView.setText(company.getTitle());
    }



    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }

    private void animateExpand() {
        ObjectAnimator.ofFloat(arrow, "rotation", 0, 180).start();
    }

    private void animateCollapse() {
        ObjectAnimator.ofFloat(arrow, "rotation", 180, 0).start();

    }

}
