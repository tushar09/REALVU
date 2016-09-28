package tech.triumphit.realvu.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.triumphit.realvu.CheckStock;
import tech.triumphit.realvu.R;

/**
 * Created by Tushar on 9/5/2016.
 */
public class VromonPoricolpona extends BaseAdapter {

    ArrayList relTracker;

    Context context;
    ArrayList name, dth, recharge, address;
    LayoutInflater layoutInflater;

    public VromonPoricolpona(Context context, ArrayList name, ArrayList dth, ArrayList recharge, ArrayList address){
        this.context = context;
        this.name = name;
        this.dth = dth;
        this.recharge = recharge;
        this.address = address;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        relTracker = new ArrayList();
    }

    @Override
    public int getCount() {
        return name.size();
    }

    @Override
    public Object getItem(int i) {
        return name.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {

        final Holder holder;
        if(view == null){
            view = layoutInflater.inflate(R.layout.row_vromon_poricolpona, null);
            holder = new Holder(view);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        holder.name.setText("" + name.get(position));
        holder.dth.setText("" + dth.get(position));
        holder.recharge.setText("" + recharge.get(position));
        holder.address.setText("" + address.get(position));

        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(holder.rel.getVisibility() == View.VISIBLE){
                    Animation a = AnimationUtils.loadAnimation(context, R.anim.left_to_right);
                    holder.rel.startAnimation(a);
                    relTracker.remove("" + position);
                    a.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            //holder.rel.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            holder.rel.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                }else{
                    Animation a = AnimationUtils.loadAnimation(context, R.anim.right_to_left);
                    holder.rel.startAnimation(a);
                    relTracker.add("" + position);
                    a.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            holder.rel.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                }

            }
        });

        if(relTracker.contains("" + position)){
            holder.rel.setVisibility(View.VISIBLE);
            Log.e("pos", "" + position);
        }else{
            holder.rel.setVisibility(View.INVISIBLE);
            Log.e("pos nai", "" + position);
        }

        holder.checkStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, CheckStock.class));
            }
        });

        return view;
    }

    static class Holder{
        @BindView(R.id.textView6) TextView name;
        @BindView(R.id.textView8) TextView dth;
        @BindView(R.id.textView9) TextView recharge;
        @BindView(R.id.textView7) TextView address;

        @BindView(R.id.checkStock) CheckBox checkStock;

        @BindView(R.id.imageButton) ImageButton imageButton;
        @BindView(R.id.rel) RelativeLayout rel;

        public Holder(View view){
            ButterKnife.bind(this, view);
        }

    }
}
