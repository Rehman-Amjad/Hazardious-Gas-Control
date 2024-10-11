package com.rehman.hazardousgasesusingiot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavigationView navMenu;
    ActionBarDrawerToggle toggle;
    DrawerLayout drayerLayout;

    Fragment temp=null;

    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);

        navMenu=findViewById(R.id.navMenu);
        drayerLayout=findViewById(R.id.drawerlayout);

        //    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new Fragment_MainDashboard_cat()).commit();


        toggle=new ActionBarDrawerToggle(this,drayerLayout,toolbar,R.string.app_name,R.string.app_name);
        drayerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navMenu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {


                    case R.id.menu_fire:
                        Intent intent=new Intent(MainActivity.this,FireActivity.class);
                        startActivity(intent);
                        drayerLayout.closeDrawer(GravityCompat.START);
                        break;

                        case R.id.menu_vmq1:
                        Intent fireIntent=new Intent(MainActivity.this,MQOneAcivity.class);
                        startActivity(fireIntent);
                        drayerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_vmq2:
                        Intent smokeIntent=new Intent(MainActivity.this,MQTwoActivity.class);
                        startActivity(smokeIntent);
                        drayerLayout.closeDrawer(GravityCompat.START);
                        break;


                    case R.id.menu_vmq3:
                        Intent UltraAlert=new Intent(MainActivity.this,MQThreeActivity.class);
                        startActivity(UltraAlert);
                        drayerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_vmq4:
                        Intent LDRIntent=new Intent(MainActivity.this,MQFourActivity.class);
                        startActivity(LDRIntent);
                        drayerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_vmq5:
                        Intent mq5Intent=new Intent(MainActivity.this, MQFiveActivity.class);
                        startActivity(mq5Intent);
                        drayerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_history:
                        Intent showIntent=new Intent(MainActivity.this,HistoryActivity.class);
                        startActivity(showIntent);
                        drayerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_image:
                        Intent imageIntent=new Intent(MainActivity.this,ImageActivity.class);
                        startActivity(imageIntent);
                        drayerLayout.closeDrawer(GravityCompat.START);
                        break;

                        case R.id.menuGasPump:
                        Intent gasIntent=new Intent(MainActivity.this,GasControlActivity.class);
                        startActivity(gasIntent);
                        drayerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_logout:
                        Intent logIntent=new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(logIntent);
                        finish();
                        Toast.makeText(MainActivity.this, "Logout", Toast.LENGTH_SHORT).show();
                        drayerLayout.closeDrawer(GravityCompat.START);
                        break;

                }

                return false;
            }
        });
    }
}