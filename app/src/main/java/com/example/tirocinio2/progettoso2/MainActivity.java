package com.example.tirocinio2.progettoso2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.places.Places;
import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnConnectionFailedListener {
    private GoogleApiClient mGoogleApiClient;
    final ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] values = new String[]{"Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS"};
        makeList(values);

        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();
    }

    public void makeList(String[] values){
        final ListView listview = (ListView) findViewById(R.id.listView);
        for (int i = 0; i < values.length; ++i)
            list.add(values[i]);
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listview.setAdapter((ListAdapter) adapter);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // Fare qualcosa se non c'è la connessione
    }

    public void zecond(View v) {
        // definisco l'intenzione
        Intent openPage1 = new Intent(MainActivity.this,NewTaskActivity.class);
        // passo all'attivazione dell'activity Pagina.java
        startActivity(openPage1);
    }
}