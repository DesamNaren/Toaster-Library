package com.example.customlib;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CustomDialog extends Dialog {


    public CustomDialog(Context context, String title, String message,
                        String posBtnText, String negBtnText,
                        String type, myOnClickListener myclick) {
        super(context);
        this.myListener = myclick;
        this.title = title;
        this.message = message;
        this.posBtnText = posBtnText;
        this.negBtnText = negBtnText;
        this.type = type;
    }

    private myOnClickListener myListener;
    private String title;
    private String message;
    private String posBtnText;
    private String negBtnText;
    private String type;

    public interface myOnClickListener {
        void onYesButtonClick(String type);
        void onNoButtonClick(String type);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialogxml);
        TextView textViewTitle = findViewById(R.id.malertTitle);
        textViewTitle.setText(title);
        TextView textViewMsg = findViewById(R.id.aleartMessage);
        textViewMsg.setText(message);
        Button alertYes = findViewById(R.id.aleartYes);
        alertYes.setText(posBtnText);
        Button alertNo = findViewById(R.id.aleartNo);
        alertNo.setText(negBtnText);
        alertYes.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                myListener.onYesButtonClick(type);
            }
        });
        alertNo.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                myListener.onNoButtonClick(type);
            }
        });
    }
}
