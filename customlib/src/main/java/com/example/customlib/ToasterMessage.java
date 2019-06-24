package com.example.customlib;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class ToasterMessage {
    public static void showToast(Context c, String message){
        Toast.makeText(c,message,Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Activity a, String message){
        Toast.makeText(a,message,Toast.LENGTH_SHORT).show();
    }
}
