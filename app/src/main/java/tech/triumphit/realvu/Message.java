package tech.triumphit.realvu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Message extends AppCompatActivity {

    @BindView(R.id.lv) ListView lv;
    @BindView(R.id.msgRel) RelativeLayout msgRel;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(msgRel.getVisibility() == View.VISIBLE){
                    msgRel.setVisibility(View.GONE);
                }else{
                    msgRel.setVisibility(View.VISIBLE);
                    fab.setVisibility(View.GONE);
                }
            }
        });

        ArrayList number, msgHead, date;

        number = new ArrayList();
        msgHead = new ArrayList();
        date = new ArrayList();

        for(int t = 0; t < 100; t++){
            number.add("" + t);
            msgHead.add("Lorem Ipsum Doler");
            date.add("10 Oct 2015 4:30 pm");
        }

        lv.setAdapter(new tech.triumphit.realvu.adapters.Message(this, number, msgHead, date));

    }

    @Override
    public void onBackPressed() {
        if(fab.getVisibility() == View.VISIBLE){
            super.onBackPressed();
        }else{
            msgRel.setVisibility(View.GONE);
            fab.setVisibility(View.VISIBLE);
        }
    }
}
