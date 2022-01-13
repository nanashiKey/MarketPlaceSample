package com.tokosample.tokopediasample.helpers;

import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MethodHelper {
    public static void setNotificationbar(AppCompatActivity saved, int color){
        Window window = saved.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(saved, color));
    }

    public static void setNavigationColor(AppCompatActivity saved, int color){
        Window window = saved.getWindow();
        window.setNavigationBarColor(ContextCompat.getColor(saved, color));
    }
}
