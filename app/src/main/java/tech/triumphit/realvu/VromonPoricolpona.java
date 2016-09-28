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
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VromonPoricolpona extends AppCompatActivity {

    @BindView(R.id.lv)ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vromon_poricolpona);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VromonPoricolpona.this, RegestrationerOnurodh.class));
            }
        });


        ArrayList name, dth, recharge, address;
        name = new ArrayList();
        dth = new ArrayList();
        recharge = new ArrayList();
        address = new ArrayList();
        for(int t = 0; t < 100; t++){
            name.add("asdf");
            address.add("Road no: 20, Basha: 05 \nBlock-B, Banani, Dhaka");
            dth.add("" + t);
            recharge.add("" + (t + 10));
        }

        lv.setAdapter(new tech.triumphit.realvu.adapters.VromonPoricolpona(VromonPoricolpona.this, name, dth, recharge, address));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.customer_sheba, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
