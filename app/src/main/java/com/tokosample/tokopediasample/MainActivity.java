package com.tokosample.tokopediasample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tokosample.tokopediasample.adapters.BannerAdapter;
import com.tokosample.tokopediasample.adapters.SampleProductAdapter;
import com.tokosample.tokopediasample.fragments.HomeFragment;
import com.tokosample.tokopediasample.fragments.MessageFragment;
import com.tokosample.tokopediasample.fragments.ProfileFragment;
import com.tokosample.tokopediasample.helpers.ApiServices;
import com.tokosample.tokopediasample.helpers.Const;
import com.tokosample.tokopediasample.helpers.MethodHelper;
import com.tokosample.tokopediasample.responsemodel.banner.ImagesResponse;
import com.tokosample.tokopediasample.responsemodel.sampleproduct.SampleProductResponse;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomMenu = findViewById(R.id.bottomMenu);
        MethodHelper.setNotificationbar(this, R.color.green);
        MethodHelper.setNavigationColor(this, R.color.green);
        callFragment(new HomeFragment());
        bottomMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home: {
                        callFragment(new HomeFragment());
                    }
                    break;
                    case R.id.message: {
                        callFragment(new MessageFragment());
                    }
                    break;
                    case R.id.profile: {
                        callFragment(new ProfileFragment());
                    }
                    break;
                    default:
                        //do nothing
                }
                return true;
            }
        });
    }

    private void callFragment(Fragment fr){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frLayout, fr)
                .commit();
    }

}