package tech.triumphit.realvu.adapters;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.triumphit.realvu.FloatingSheba;
import tech.triumphit.realvu.R;

/**
 * Created by Tushar on 9/4/2016.
 */
public class CustomerSheba extends BaseAdapter {

    Context context;
    ArrayList name, numbers,status;
    LayoutInflater layoutInflater;

    public CustomerSheba(Context context, ArrayList name, ArrayList numbers, ArrayList status){
        this.context = context;
        this.name = name;
        this.numbers = numbers;
        this.status = status;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
    public View getView(int position, View view, ViewGroup viewGroup) {

        Holder holder;
        if(view == null){
            view = layoutInflater.inflate(R.layout.row_customer_sheba, null);
            holder = new Holder(view);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        holder.name.setText("" + name.get(position));
        holder.number.setText("" + numbers.get(position));
        holder.status.setText("" + status.get(position));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, FloatingSheba.class));
            }
        });

        return view;
    }

    static class Holder{
        @BindView(R.id.textView) TextView name;
        @BindView(R.id.textView2) TextView number;
        @BindView(R.id.textView3) TextView status;

        public Holder(View view){
            ButterKnife.bind(this, view);
        }

    }

}
