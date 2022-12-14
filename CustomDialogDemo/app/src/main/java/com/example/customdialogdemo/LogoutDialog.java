package com.example.customdialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class LogoutDialog extends Dialog {
    Button btnLogout;
    EditText edtUsername, edtPassword;
    //SOLID Principles
    public interface OnLogoutListener{
        void onLogoutSuccessful();
        void onLogoutFailure();
    }

    private OnLogoutListener onLogoutListener;

    public void setOnLogoutListener(OnLogoutListener onLogoutListener){
        this.onLogoutListener = onLogoutListener;
    }

    public LogoutDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.logout_dialog);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new BtnLogoutClickListener());
    }

    private class BtnLogoutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(onLogoutListener == null){
                return;
            }

            if(edtUsername.getText().toString().equals("bitcode") && edtPassword.getText().toString().equals("bitcode")){
                onLogoutListener.onLogoutSuccessful();
                //makeToast("Logout Action Successful");
            } else {
                onLogoutListener.onLogoutFailure();
               // makeToast("Logout Action Failure");
            }
        }
    }

    private void makeToast(String text){
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }
}