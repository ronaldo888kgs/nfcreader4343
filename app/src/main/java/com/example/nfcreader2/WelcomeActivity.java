package com.example.nfcreader2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import org.bson.types.ObjectId;

import java.util.concurrent.ExecutionException;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.exceptions.RealmFileException;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);


        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("default-realm")
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .compactOnLaunch()
                .inMemory()
                .build();
// set this config as the default realm
        Realm.setDefaultConfiguration(config);

        Realm realm;
        try {
            realm = Realm.getInstance(config);
            Log.v("EXAMPLE", "Successfully opened a realm at: " + realm.getPath());
        } catch (RealmFileException ex) {
            Log.v("EXAMPLE", "Error opening the realm.");
            Log.v("EXAMPLE", ex.toString());
            return;

        }

//        LogModel task = realm.where(LogModel.class).equalTo("_id", PRIMARY_KEY_VALUE.get()).findFirst();

        realm.executeTransaction(r -> {
            try{
                LogModel logObject = r.createObject(LogModel.class, new ObjectId());
                logObject.setCustomerId(1);
                logObject.setDateIn("2023-04-06");
                logObject.setTimeIn("22-09-12");
                logObject.setDateOut("2023-04-06");
                logObject.setTimeOut("23-11-11");
                logObject.setLocationID(1);
            }catch(Exception e){
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }

        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i =  new Intent(WelcomeActivity.this, MainActivity.class);

                WelcomeActivity.this.startActivity(i);
            }
        }, 5000);
    }
}