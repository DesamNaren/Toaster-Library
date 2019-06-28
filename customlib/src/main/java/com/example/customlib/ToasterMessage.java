package com.example.customlib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ToasterMessage {

    private Context context;
    public ToasterMessage(Context  context){
        this.context = context;
    }

    //Use context
    public static void showToast(Context c, String message) {
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show();
    }


    //Use activity context
    public static void showToast(Activity a, String message) {
        Toast.makeText(a, message, Toast.LENGTH_SHORT).show();
    }

    //Pass your root view
    public static void showSnackBar(View view, String message, int duration) {
        Snackbar.make(view, message, duration).show();
    }

    //Pass your root view and background color
    public static void showSnackBar(View view, String message, int duration, int color) {
        Snackbar snackbar;
        snackbar = Snackbar.make(view, message, duration);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(color);

        TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(color);

        snackbar.show();
    }


/*    Show Alert - pass flag to setCancelable() method to cancel alert or not on back press and on touch outside
      flag true - restrict alert dismiss and false for dialog dismiss
*/
    public static void showAlertOK(Context context, String title, String message, String btnText, boolean flag) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(title)
                .setCancelable(flag)
                .setMessage(message)
                .setPositiveButton(btnText, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).show();
    }

    /*    Show Alert - pass flag to setCancelable() method to cancel alert or not on back press and on touch outside
          flag true - restrict alert dismiss and false for dialog dismiss
    */
    public static void showAlertOKCancel(final Context context, String title, String message, String posBtnText, String negBtnText, boolean flag) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(title)
                .setCancelable(flag)
                .setMessage(message)
                .setPositiveButton(posBtnText, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setNegativeButton(negBtnText, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ToasterMessage.showToast(context, "Negative Clicked");
                    }
                }).show();
    }


    public static boolean checkPermission(Context context, String permission) {
        // TODO Auto-generated method stub
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED) {
                Log.i("LOG_PER", "checkPermission: "+"YES");
                return true;
            }
        } else {
            Log.i("LOG_PER", "checkPermission: "+"YES");
            return true;
        }
        Log.i("LOG_PER", "checkPermission: "+"NO");
        return false;
    }


}
