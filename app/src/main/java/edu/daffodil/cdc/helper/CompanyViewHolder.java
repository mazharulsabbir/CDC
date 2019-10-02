package edu.daffodil.cdc.helper;

import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import edu.daffodil.cdc.R;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class CompanyViewHolder extends GroupViewHolder {
    TextView mTextView;
    ImageView arrow;

    public CompanyViewHolder(View itemView) {
        super(itemView);
        mTextView=itemView.findViewById(R.id.textView);
        arrow=itemView.findViewById(R.id.arrow);
    }

    public void bind(Company company){
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
        RotateAnimation rotate =
                new RotateAnimation(0f, 180f, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
        Log.d("animation----","open");
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(180f, 0f, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(100);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
        Log.d("animation----","close");

    }

}
