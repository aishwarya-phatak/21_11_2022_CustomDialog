package com.example.customdialogdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class DashboardActivity extends Activity {
    Button btnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new BtnSubmitClickListener());
    }

    class BtnSubmitClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            LogoutDialog logoutDialog = new LogoutDialog(DashboardActivity.this);
            logoutDialog.setOnLogoutListener(new MyLogoutListener());
            logoutDialog.show();
        }
    }

    class MyLogoutListener implements LogoutDialog.OnLogoutListener{
        @Override
        public void onLogoutSuccessful() {
            Log.e("tag","onSuccess");
        }

        @Override
        public void onLogoutFailure() {
            Log.e("tag","onFail");
        }
    }
}
