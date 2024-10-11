package com.rehman.hazardousgasesusingiot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;
import com.rehman.hazardousgasesusingiot.Adapter.HistoryAdapter;
import com.rehman.hazardousgasesusingiot.Adapter.HistoryModel;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HistoryAdapter mUserAdapter;
    private List<HistoryModel> mDatalist;

    FirebaseDatabase database;
    DatabaseReference myRef;

    Button btnDeleteAll;

    ImageView back_image;
    private DatabaseReference historyRef;
    private ChildEventListener MyChildEventListener;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myRef.removeEventListener(MyChildEventListener);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("SensorsInformation");
        historyRef = FirebaseDatabase.getInstance().getReference("SensorsInformation");

        btnDeleteAll = findViewById(R.id.btnDeleteAll);
        back_image = findViewById(R.id.back_image);

        mDatalist=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mUserAdapter=new HistoryAdapter(this,mDatalist);
        recyclerView.setAdapter(mUserAdapter);

        back_image.setOnClickListener(v -> {
            onBackPressed();
        });

        btnDeleteAll.setOnClickListener(v -> {
            deleteAllHistoryData();
        });

        MyChildEventListener=new ChildEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                HistoryModel user=snapshot.getValue(HistoryModel.class);
            /*Log.d(TAG,"User Name :" + user.getUserName());
            Log.d(TAG,"User Name :" + user.getUserPassword());*/
                mDatalist.add(user);
                mUserAdapter.notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        };
        myRef.addChildEventListener(MyChildEventListener);
    }

    private void deleteAllHistoryData() {
        // Show a confirmation toast before deletion
        Toast.makeText(HistoryActivity.this, "Deleting all history...", Toast.LENGTH_SHORT).show();

        // Delete all data under "History" in Firebase
        historyRef.removeValue().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                mDatalist.clear();
                mUserAdapter.notifyDataSetChanged();
                Toast.makeText(HistoryActivity.this, "All history deleted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(HistoryActivity.this, "Failed to delete history", Toast.LENGTH_SHORT).show();
            }
        });
    }
}