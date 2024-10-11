package com.rehman.hazardousgasesusingiot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FireActivity extends AppCompatActivity {

    ImageView back_image,image;
    TextView text,text2,text3,tv_DateTime;
    String value,date,temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);

        back_image = findViewById(R.id.back_image);
        image = findViewById(R.id.image);
        text = findViewById(R.id.text);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        tv_DateTime = findViewById(R.id.tv_DateTime);

        back_image.setOnClickListener(v -> {
            onBackPressed();
        });

        DatabaseReference reference  = FirebaseDatabase.getInstance().getReference("CurrentInfo")
                .child("1000");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    value = snapshot.child("VHumidity").getValue(String.class);
                    temp = snapshot.child("Vtemp").getValue(String.class);
                    date = snapshot.child("DateTime").getValue(String.class);

                    tv_DateTime.setText("DateTime: " + date);

                    text.setText("Humidity: " + value + "%");
                    text2.setText("Temperature: " + temp + "°C");


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}