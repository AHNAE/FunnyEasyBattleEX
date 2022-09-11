package com.example.funnyeasybattleex;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnUserDaily, btnUserMission, btnUserInfo;
    FragmentManager fm;
    FragmentTransaction tran;
    Frag_daily frag1;
    Frag_mission frag2;
    Frag_user frag3;

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawerLayout;
    private View drawerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavigationView navigationView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        btnUserDaily = (Button) findViewById(R.id.btnUserDaily);
        btnUserMission = (Button) findViewById(R.id.btnUserMission);
        btnUserInfo = (Button) findViewById(R.id.btnUserInfo);
        btnUserDaily.setOnClickListener(this);
        btnUserMission.setOnClickListener(this);
        btnUserInfo.setOnClickListener(this);
        frag1 = new Frag_daily();
        frag2 = new Frag_mission();
        frag3 = new Frag_user();

        fm = getSupportFragmentManager();
        tran = fm.beginTransaction();
        tran.replace(R.id.frame_main, frag1).commitAllowingStateLoss();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onClick(View view) {
        tran = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.btnUserDaily:
                tran.replace(R.id.frame_main, frag1).commitAllowingStateLoss();
                break;
            case R.id.btnUserMission:
                tran.replace(R.id.frame_main, frag2).commitAllowingStateLoss();
                break;
            case R.id.btnUserInfo:
                tran.replace(R.id.frame_main, frag3).commitAllowingStateLoss();
                break;
        }
    }
}