package momocorp.groupfit;

import android.content.Intent;
import android.os.Bundle;
import momocorp.groupfit.Adapters.GroupInfoAdapter;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class
MainActivity extends AppCompatActivity implements Universal.UniversalInterface
{

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    RecyclerView group_info_recycler;
    public enum Fragments {
        details("details");

        Fragments(String s) {
            this.s = s;
        }
        String s;

    }

    @Override
    public void detailGroupFragment() {
        //create detailfragment here
        Intent intent = new Intent(MainActivity.this, GroupDetailActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        group_info_recycler = (RecyclerView) findViewById(R.id.group_recycler_view);
        group_info_recycler.setLayoutManager(new LinearLayoutManager(this));
        group_info_recycler.setAdapter(new GroupInfoAdapter(this));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void intentToDetail(View view) {
        Intent i = new Intent(this, GroupDetailActivity.class);
        startActivity(i);
    }

    public void toLogin(View view) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}
