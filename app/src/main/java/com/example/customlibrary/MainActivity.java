package com.example.customlibrary;

import android.Manifest;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.customlib.CustomDialog;
import com.example.customlib.ToasterMessage;

public class MainActivity extends AppCompatActivity implements CustomDialog.myOnClickListener {

    private CustomDialog customDialog;

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
        customDialog = new CustomDialog(this, "Hello", "Hey, Alert1", "OK", "Cancel","1",  this);
        customDialog.show();

//        DialogsUtil dialogsUtil = new DialogsUtil(this);
//        dialogsUtil.openAlertDialog(MainActivity.this, "text message", "Hey Alert", R.drawable.ic_launcher_background, "positive button msg", "Negative button msg", MainActivity.this);
    }

    public void showOKCanAlert(View view) {
        CustomDialog customDialog = new CustomDialog(this, "Hello", "Hey, Alert2", "OK", "Cancel","2", this);
        customDialog.show();
    }

    public void chkPermission(View view) {
        ToasterMessage.checkPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    @Override
    public void onYesButtonClick(String type) {
        if (type.equalsIgnoreCase("1")) {
            customDialog.dismiss();
            ToasterMessage.showSnackBar(findViewById(R.id.root_layout), "Hey 1", Snackbar.LENGTH_SHORT);
        }

        if (type.equalsIgnoreCase("2")) {
            ToasterMessage.showSnackBar(findViewById(R.id.root_layout), "Hey 2", Snackbar.LENGTH_SHORT);
        }
    }

    @Override
    public void onNoButtonClick(String type) {
        ToasterMessage.showSnackBar(findViewById(R.id.root_layout), "Hey NO", Snackbar.LENGTH_SHORT);
    }

//    @Override
//    public void onPositiveButtonClicked() {
//        ToasterMessage.showToast(this, "Hey Custom Alert");
//    }
//
//    @Override
//    public void onNegativeButtonClicked() {
//
//    }
}
