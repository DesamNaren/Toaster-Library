package com.example.customlibrary;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.customlib.ToasterMessage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
        ToasterMessage.showToast(this, "Hey Toast");
    }

    public void showSnackBar(View view) {
        ToasterMessage.showSnackBar(findViewById(R.id.root_layout), "Hey Snackbar", Snackbar.LENGTH_SHORT);
    }

    public void showSnackBarColor(View view) {
        ToasterMessage.showSnackBar(findViewById(R.id.root_layout), "Hey Snackbar", Snackbar.LENGTH_SHORT, R.color.colorPrimary);
    }

    public void showOKAlert(View view) {
        ToasterMessage.showAlertOK(this, getResources().getString(R.string.app_name), "Hey Alert","OK", true);
    }

    public void showOKCanAlert(View view) {
        ToasterMessage.showAlertOKCancel(this, getResources().getString(R.string.app_name), "Hey Alert","OK", "Cancel", true);
    }
}
