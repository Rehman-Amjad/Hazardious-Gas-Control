package com.rehman.hazardousgasesusingiot;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

import java.util.HashMap;
import java.util.Map;

public class GasControlActivity extends AppCompatActivity {

    Button btnOn,btnOff;
    TextView tv_text;

    String value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gas_control);

        btnOn = findViewById(R.id.btnOn);
        btnOff = findViewById(R.id.btnOff);
        tv_text = findViewById(R.id.tv_text);


        btnOn.setOnClickListener(v -> {
            changeValue("1");
        });

        btnOff.setOnClickListener(v -> {
            changeValue("0");
        });


        DatabaseReference reference  = FirebaseDatabase.getInstance().getReference("CurrentInfo")
                .child("1000");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    value = snapshot.child("VHumidity").getValue(String.class);

                    assert value != null;
                    if(value.equals("0")){
                        tv_text.setText("Gas is Off");
                    }else{
                        tv_text.setText("Gas is On");
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    void changeValue(String value){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference()
                .child("Gaspump");

        Map<String, Object> updates = new HashMap<>();
        updates.put("Gaspump", value);  // Replace with your key-value pairs

        reference.updateChildren(updates).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // Update successful
                Toast.makeText(this, "Value Updated", Toast.LENGTH_SHORT).show();
//                Log.d("Firebase", "Update successful");
            } else {
                // Update failed
                Toast.makeText(this, "Value Updated Failed", Toast.LENGTH_SHORT).show();
//                Log.e("Firebase", "Update failed", task.getException());
            }
        });
    }

}