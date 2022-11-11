package vn.nhattamsoft.project_mau.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.os.Bundle;

import vn.nhattamsoft.project_mau.R;

public class DangNhapLai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap_lai);
    }
}