package vn.nhattamsoft.project_mau.Class;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.Window;

import vn.nhattamsoft.project_mau.databinding.LoadingBinding;

public class Loading {
    private static final Loading INSTANCE = new Loading();
    private Dialog dialog;

    private Context context;
    public static Loading setContext(Context context){
        INSTANCE.context = context;
        return INSTANCE;
    }
    public void startLoading(){
        LoadingBinding dialogBinding = LoadingBinding.inflate((LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE ));
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(dialogBinding.getRoot());
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
    public void endLoading(){
        dialog.dismiss();
    }
}
