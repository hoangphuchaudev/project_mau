package vn.nhattamsoft.project_mau.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import vn.nhattamsoft.project_mau.R;

public class LienHe extends AppCompatActivity {
    ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lien_he);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.toolbar);
        TextView title = relativeLayout.findViewById(R.id.title);
        title.setText("Thông tin liên hệ");
        btn_back = relativeLayout.findViewById(R.id.back);
        btn_back.setOnClickListener(v -> {
            LienHe.super.onBackPressed();
            overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
        });
    }
}