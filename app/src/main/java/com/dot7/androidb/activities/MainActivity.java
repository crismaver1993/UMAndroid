package com.dot7.androidb.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dot7.androidb.R;
import com.dot7.androidb.adapters.ScheduleAdapter;
import com.dot7.androidb.models.Schedule;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private String TAG = "xxx"+MainActivity.class.getSimpleName();

    public FirebaseDatabase database;
    public DatabaseReference scheduleDB;

    private ScheduleAdapter scheduleAdapter = new ScheduleAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();


        scheduleDB = database.getReference("schedule");
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(scheduleAdapter);

        if(scheduleDB!=null)
            scheduleDB.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    try {

                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            Schedule response = postSnapshot.getValue(Schedule.class);
                            if (response != null) {
                                //Log.v(TAG,"-"+response.getDay());
                                //Log.v(TAG,"-"+response.getData().size());
                                scheduleAdapter.addSectionHeaderItem(response.getDay());
                                scheduleAdapter.addListItem(response.getData());
                            }
                        }

                    } catch (RuntimeException errorRuntime) {
                        Log.e(TAG, "Failed to read value." + errorRuntime.getLocalizedMessage(), errorRuntime);
                    } catch (Exception e) {
                        Log.e(TAG, "Exception." + e.getLocalizedMessage(), e);
                    }

                }

                @Override
                public void onCancelled(DatabaseError error) {

                    Log.e(TAG, "Failed to read value." + error.getMessage(), error.toException());
                }
            });

    }
}