package com.rehman.hazardousgasesusingiot;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MQSixActivity extends AppCompatActivity {

    ImageView back_image;
    String value,date;
    TextView text,tv_DateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqsix);

        back_image = findViewById(R.id.back_image);
        text = findViewById(R.id.text);
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
                    value = snapshot.child("VMQ6").getValue(String.class);
                    date = snapshot.child("DateTime").getValue(String.class);
                    text.setText("MQ-6 value: " + value);

                    tv_DateTime.setText("DateTime: " + date);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}