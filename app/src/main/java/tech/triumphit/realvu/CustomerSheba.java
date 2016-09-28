package tech.triumphit.realvu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerSheba extends AppCompatActivity {

    @BindView(R.id.listView) ListView lv;
    ArrayList name, numbers,status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sheba);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ButterKnife.bind(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                startActivity(new Intent(CustomerSheba.this, VromonPoricolpona.class));
            }
        });

        numbers = new ArrayList();
        name = new ArrayList();
        status = new ArrayList();

        for(int t = 0; t < 100; t++){
            numbers.add("0" + (1722043601 + t));
            name.add("asdf");
            if(t % 2 == 0){
                status.add("repair");
            }else{
                status.add("install");
            }

        }

        lv.setAdapter(new tech.triumphit.realvu.adapters.CustomerSheba(CustomerSheba.this, name, numbers,status));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.customer_sheba, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if(id == R.id.msg){
            startActivity(new Intent(CustomerSheba.this, Message.class));
        }
        // test change will be shown here
        return super.onOptionsItemSelected(item);
    }
}
