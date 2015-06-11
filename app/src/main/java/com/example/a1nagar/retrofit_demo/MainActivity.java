package com.example.a1nagar.retrofit_demo;

import android.app.ListActivity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.a1nagar.retrofit_demo.model.Flower;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ListActivity {

    public static final String IMAGE_URL = "http://services.hanselandpetal.com/photos/";
    public static final String END_POINT = "http://services.hanselandpetal.com";

    List<Flower> flowerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        boolean handled = true;

        switch (id) {
            case R.id.action_do_task:
                if(isOnline())
                    requestData();
                else
                    Toast.makeText(this,"Network not Available",Toast.LENGTH_LONG).show();
                break;
             default:
                 handled = super.onOptionsItemSelected(item);

        }

        return handled;
    }

    private void requestData() {

        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(END_POINT).build();
        FlowersAPI api =adapter.create(FlowersAPI.class);
        api.getFeed( new Callback<List<Flower>>() {
            @Override
            public void success(List<Flower> flowers, Response response) {

                flowerList = flowers;
                updateDisplay();

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });


    }

    private void updateDisplay(){
        FlowerAdapter adapter = new FlowerAdapter(this,R.layout.item_flower,flowerList);
        setListAdapter(adapter);
    }

    public boolean isOnline()
    {
        ConnectivityManager cm = (ConnectivityManager) getSystemService
                (CONNECTIVITY_SERVICE);
        NetworkInfo nwk = cm.getActiveNetworkInfo();
        if ( nwk!= null && nwk.isConnectedOrConnecting() )
            return true;
        else
            return false;


    }
}
