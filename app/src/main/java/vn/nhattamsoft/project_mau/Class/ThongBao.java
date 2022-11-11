package vn.nhattamsoft.project_mau.Class;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;

import java.util.Objects;

import vn.nhattamsoft.project_mau.R;
import vn.nhattamsoft.project_mau.databinding.ThongbaoBinding;

public final class ThongBao {
    private static final ThongBao INSTANCE = new ThongBao();
    public final static int SUCCESS = 1;
    public final static int DANGER = 2;
    public final static int WARNING = 3;
    public final static int INFO = 4;
    private  int loai = SUCCESS;
    private String title = "";
    private String message = "";
    private int icon;
    private int color;
    private int duration = 3000;

    public ThongBao setLoai(int loai) {
        INSTANCE.loai = loai;
        return INSTANCE;
    }
    public ThongBao setTitle(String tieuDe) {
        INSTANCE.title = tieuDe;
        return INSTANCE;
    }
    public static ThongBao setMessage(String noiDung) {
        INSTANCE.message = noiDung;
        return INSTANCE;
    }

    public ThongBao setIcon(int icon) {
        INSTANCE.icon = icon;
        return INSTANCE;
    }

    public static ThongBao setColor(int color) {
        INSTANCE.color = color;
        return INSTANCE;
    }

    public ThongBao setDuration(int duration) {
        INSTANCE.duration = duration;
        return INSTANCE;
    }
    public ThongBao Error(){
        INSTANCE.loai = DANGER;
        INSTANCE.title = Objects.equals(INSTANCE.title, "") ? "Thông báo lỗi" : INSTANCE.title;
        INSTANCE.icon = INSTANCE.icon == 0 ? R.drawable.iconx : INSTANCE.icon;
        return INSTANCE;
    }
    public ThongBao Success(){
        INSTANCE.loai = SUCCESS;
        INSTANCE.title = Objects.equals(INSTANCE.title, "") ? "Thông báo" : INSTANCE.title;
        INSTANCE.icon = INSTANCE.icon == 0 ? R.drawable.check : INSTANCE.icon;
        return INSTANCE;
    }
    public ThongBao Info(){
        INSTANCE.loai = INFO;
        INSTANCE.title = Objects.equals(INSTANCE.title, "") ? "Thông tin" : INSTANCE.title;
        INSTANCE.icon = INSTANCE.icon == 0 ? R.drawable.info : INSTANCE.icon;
        return INSTANCE;
    }
    public ThongBao Warning(){
        INSTANCE.loai = WARNING;
        INSTANCE.title = Objects.equals(INSTANCE.title, "") ? "Cảnh báo" : INSTANCE.title;
        INSTANCE.icon = INSTANCE.icon == 0 ? R.drawable.warning : INSTANCE.icon;
        return INSTANCE;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void Show(Context context){
        ThongbaoBinding dialogBinding = ThongbaoBinding.inflate((LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE ));
        Dialog thongbao = new Dialog(context, R.style.NewDialog);
        thongbao.requestWindowFeature(Window.FEATURE_NO_TITLE);
        thongbao.setContentView(dialogBinding.getRoot());
        WindowManager.LayoutParams wmlp = thongbao.getWindow().getAttributes();
        wmlp.gravity = Gravity.BOTTOM;

        dialogBinding.icon.setImageDrawable(context.getDrawable(INSTANCE.icon));

        dialogBinding.tieude.setText(INSTANCE.title);
        dialogBinding.noidung.setText(INSTANCE.message);
        switch (INSTANCE.loai){
            case SUCCESS:
                thongbao.getWindow().setBackgroundDrawable(context.getDrawable(R.drawable.thongbao_success));
                break;
            case DANGER:
                thongbao.getWindow().setBackgroundDrawable(context.getDrawable(R.drawable.thongbao_danger));
                break;
            case WARNING:
                thongbao.getWindow().setBackgroundDrawable(context.getDrawable(R.drawable.thongbao_warning));
                break;
            case INFO:
                thongbao.getWindow().setBackgroundDrawable(context.getDrawable(R.drawable.thongbao_info));
                break;
        }
        thongbao.show();
        if (INSTANCE.duration > 0) {
            new Handler().postDelayed(() -> {
                if (thongbao.isShowing()) {
                    thongbao.dismiss();
                }
            }, INSTANCE.duration);
        }

    }
    public static void Show(Context context, String message){
        INSTANCE.message = message;
        INSTANCE.Info().Show(context);
    }
}
