package com.example.customdialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class LogoutDialog extends Dialog {
    Button btnLogout;
    EditText edtUsername, edtPassword;

    public LogoutDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.logout_dialog);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogout = findViewById(R.id.btnLogout);

    }
}
