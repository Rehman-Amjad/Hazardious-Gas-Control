package com.rehman.hazardousgasesusingiot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;

public class ImageActivity extends AppCompatActivity {

    ImageView back_image,image;
    String value,date,humidity,mq1,mq2,mq3,mq4,mq5,mq6,temp;
    TextView tv_DateTime,tvHumidity,tvmq1,tvmq2,tvmq3,tvmq4,tvmq5,tvmq6,tvTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        back_image = findViewById(R.id.back_image);
        image = findViewById(R.id.image);

        tv_DateTime = findViewById(R.id.tv_DateTime);
        tvHumidity = findViewById(R.id.tvHumidity);
        tvmq1 = findViewById(R.id.tvmq1);
        tvmq2 = findViewById(R.id.tvmq2);
        tvmq3 = findViewById(R.id.tvmq3);
        tvmq4 = findViewById(R.id.tvmq4);
        tvmq5 = findViewById(R.id.tvmq5);
        tvmq6 = findViewById(R.id.tvmq6);
        tvTemp = findViewById(R.id.tvTemp);


        back_image.setOnClickListener(v -> {
            onBackPressed();
        });

        DatabaseReference reference  = FirebaseDatabase.getInstance().getReference("CurrentInfo")
                .child("1000");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    value = snapshot.child("img").getValue(String.class);
                    humidity = snapshot.child("VHumidity").getValue(String.class);
                    mq1 = snapshot.child("VMQ137").getValue(String.class);
                    mq2 = snapshot.child("VMQ2").getValue(String.class);
                    mq3 = snapshot.child("VMQ3").getValue(String.class);
                    mq4 = snapshot.child("VMQ4").getValue(String.class);
                    mq5 = snapshot.child("VMQ5").getValue(String.class);
                    mq6 = snapshot.child("VMQ6").getValue(String.class);
                    temp = snapshot.child("Vtemp").getValue(String.class);
                    date = snapshot.child("DateTime").getValue(String.class);

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] imageBytes = baos.toByteArray();
                    imageBytes = Base64.decode(value, Base64.DEFAULT);
                    Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);

                    image.setImageBitmap(decodedImage);

                    tv_DateTime.setText("DateTime: " + date);
                    tvHumidity.setText("Humidity: " + humidity);
                    tvmq1.setText("MQ137: " + mq1);
                    tvmq2.setText("MQ2: " + mq2);
                    tvmq3.setText("MQ3: " + mq3);
                    tvmq4.setText("MQ4: " + mq4);
                    tvmq5.setText("MQ5: " + mq5);
                    tvmq6.setText("MQ6: " + mq6);
                    tvTemp.setText("Temperature: " + temp);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}