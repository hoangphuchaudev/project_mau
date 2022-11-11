package vn.nhattamsoft.project_mau.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import vn.nhattamsoft.project_mau.R;

public class DieuKhoanSuDung extends AppCompatActivity {
    TextView text7;
    ImageButton btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieu_khoan_su_dung);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.toolbar);
        TextView title = relativeLayout.findViewById(R.id.title);
        title.setText("Quản lý lao động");
        btn_back = relativeLayout.findViewById(R.id.back);
        text7 = (TextView)findViewById(R.id.text7);
        String NoiDung = "NTSOFT QLLĐ cho phép người sử dụng xem, chiết xuất thông tin trong ứng dụng(xem, tải, cập nhật, chuyển tiếp,…) hoặc chia sẻ cho người khác nhưng chỉ cho mục đích sử dụng cá nhân và phi thương mại với điều kiện phải trích dẫn thông báo bản quyền sau đây: "
        +"<font color=\"red\">© Bản quyền thuộc về Công ty TNHH Phát triển phần mềm Nhất Tâm - NTSoft</font>"
        +". Bạn đảm bảo tuân theo pháp luật và các quy định liên quan đến việc sử dụng ứng dụng của Nhất Tâm; Không can thiệp, gây ảnh hưởng đến việc sử dụng ứng dụng của những người sử dụng khác; Không can thiệp vào hoạt động và quản lý ứng dụng của Nhất Tâm.";
        text7.setText(HtmlCompat.fromHtml(NoiDung, HtmlCompat.FROM_HTML_MODE_LEGACY));
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DieuKhoanSuDung.super.onBackPressed();
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
            }
        });

    }

}