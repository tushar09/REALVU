package tech.triumphit.realvu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.triumphit.realvu.R;

/**
 * Created by Tushar on 9/21/2016.
 */
public class Message extends BaseAdapter {

    Context context;
    ArrayList number, msgHead, date;
    LayoutInflater layoutInflater;

    public Message(Context context, ArrayList number, ArrayList msgHead, ArrayList date ){
        this.context = context;
        this.number = number;
        this.msgHead = msgHead;
        this.date = date;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return number.size();
    }

    @Override
    public Object getItem(int i) {
        return number.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Holder holder;

        if(view == null){
            view = layoutInflater.inflate(R.layout.row_message, null);
            holder = new Holder(view);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }

        holder.number.setText("" + number.get(i));
        holder.date.setText("" + date.get(i));
        holder.msgHead.setText("" + msgHead.get(i));

        return view;
    }

    class Holder{
        @BindView(R.id.textView23) TextView number;
        @BindView(R.id.textView24) TextView date;
        @BindView(R.id.textView25) TextView msgHead;

        public Holder(View view){
            ButterKnife.bind(this, view);
        }
    }

}
