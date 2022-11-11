package vn.nhattamsoft.project_mau.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import vn.nhattamsoft.project_mau.R;
import vn.nhattamsoft.project_mau.databinding.ActivityGioiThieuBinding;

public class GioiThieu extends AppCompatActivity {
    ImageView img1,img2,img3,img4,img5,img6;
    ImageButton btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioi_thieu);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.toolbar);
        TextView title = relativeLayout.findViewById(R.id.title);
        title.setText("Quản lý lao động");
        btn_back = relativeLayout.findViewById(R.id.back);
        img1 = (ImageView)findViewById(R.id.imageView);
        img2 = (ImageView)findViewById(R.id.imageView2);
        img3 = (ImageView)findViewById(R.id.imageView3);
        img4 = (ImageView)findViewById(R.id.imageView4);
        img5 = (ImageView)findViewById(R.id.imageView5);
        img6 = (ImageView)findViewById(R.id.imageView6);
        Picasso.get().load("http://nhattamsoft.vn/ckfinder/userfiles/images/2(1).png").into(img1);
        Picasso.get().load("http://nhattamsoft.vn/ckfinder/userfiles/images/ho%e1%ba%a1t%20%c4%91%e1%bb%99ng.PNG").into(img2);
        Picasso.get().load("http://nhattamsoft.vn/ckfinder/userfiles/images/1_6.png").into(img3);
        Picasso.get().load("http://nhattamsoft.vn/ckfinder/userfiles/images/H5_2.png").into(img4);
        Picasso.get().load("http://nhattamsoft.vn/ckfinder/userfiles/images/1(2).jpg").into(img5);
        Picasso.get().load("http://nhattamsoft.vn/ckfinder/userfiles/images/H3.png").into(img6);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GioiThieu.super.onBackPressed();
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
            }
        });

    }
}