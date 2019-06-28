package com.example.customlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;

public class DialogsUtil {
    private Context mContext;

    public DialogsUtil(Context context) {
        this.mContext = context;
    }

    /**
     * Return an alert dialog
     *
     * @param message  message for the alert dialog
     * @param listener listener to trigger selection methods
     */
    public void openAlertDialog(Context context, String title, String message, int icon,
                                String positiveBtnText, String negativeBtnText,
                                final OnDialogButtonClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setPositiveButton(positiveBtnText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                listener.onPositiveButtonClicked();
            }
        });

        builder.setNegativeButton(negativeBtnText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                listener.onNegativeButtonClicked();
            }
        });
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setIcon(icon);
        builder.setCancelable(false);
        builder.create().show();
    }

    /**
     * return a dialog object
     * @return
     */

    public Dialog openDialog(@LayoutRes int layoutId) {
        Dialog dialog = new Dialog(mContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(layoutId);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    public interface OnDialogButtonClickListener {
        void onPositiveButtonClicked();
        void onNegativeButtonClicked();
    }
}
