package vn.nhattamsoft.project_mau.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.util.ArrayList;
import java.util.List;

import vn.nhattamsoft.project_mau.R;
import vn.nhattamsoft.project_mau.SharedPreferences.SharedPrefs;
import vn.nhattamsoft.project_mau.adapters.ComboboxAdapter;
import vn.nhattamsoft.project_mau.model.Item.ItemCombobox;
import vn.nhattamsoft.project_mau.Class.Loading;
import vn.nhattamsoft.project_mau.Class.ThongBao;
import vn.nhattamsoft.project_mau.viewmodels.LoginViewModel;
import vn.nhattamsoft.project_mau.databinding.ActivityDangNhapBinding;
import vn.nhattamsoft.project_mau.views.TrangChuMaster;

public class DangNhap extends AppCompatActivity {
    ActivityDangNhapBinding dangNhapBinding;
    LoginViewModel loginViewModel;
    List<ItemCombobox> TINH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //MVVM
        dangNhapBinding = DataBindingUtil.setContentView(this, R.layout.activity_dang_nhap);
        loginViewModel = new LoginViewModel(this);
        dangNhapBinding.setLoginViewModel(loginViewModel);
        dangNhapBinding.executePendingBindings();

        loginViewModel.loadDatabase();
        LoadDatabase();

        if(SharedPrefs.getInstance().get("TaiKhoan",String.class,"").equals("")){
            dangNhapBinding.taikhoan.setText(SharedPrefs.getInstance().get("TaiKhoan",String.class,""));
            dangNhapBinding.matkhau.setText(SharedPrefs.getInstance().get("MatKhau",String.class,""));
        }

        String[] NAM = new String[]{"2019", "2020", "2021", "2022", "2023"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, NAM);
        dangNhapBinding.nam.setAdapter(adapter);
        dangNhapBinding.nam.setOnItemClickListener((adapterView, view, i, l) -> {
            InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            in.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
        });
        dangNhapBinding.tinh.setOnItemClickListener((adapterView, view, i, l) -> {
            InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            in.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
            loginViewModel.setDatabase(TINH.get(i));
        });

        // xử lý trạng thái đăng nhập
        loginViewModel.trangThaiLiveData.observe(this, this::XuLyDangNhap);

        // hiện thông báo
        loginViewModel.loadingLiveData.observe(this, loading -> {
            if(loading){
                Loading.setContext(this).startLoading();
            }else{
                Loading.setContext(this).endLoading();
            }
        });


        //set mặc định tài khoản
        loginViewModel.setTaiKhoan("hoangvinh");
        loginViewModel.setMatKhau("@abc@123");
    }

    private void XuLyDangNhap(int trangThai){
        switch (trangThai){
            case LoginViewModel.SAIMATKHAU:
                ThongBao.setMessage(getResources().getString(R.string.saitaikhoanhoacmatkhau)).Warning().Show(DangNhap.this);
                break;
            case LoginViewModel.THANHCONG:
                ThongBao.setMessage(getResources().getString(R.string.dangnhapthanhcong)).Success().Show(DangNhap.this);
                startActivity(new Intent(this, TrangChuMaster.class));
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
                finish();
                break;
            case LoginViewModel.THATBAI:
                ThongBao.setMessage(getResources().getString(R.string.dangnhapthatbai)).Success().Show(DangNhap.this);
                break;
        }
    }
    public void LoadDatabase(){
        TINH = new ArrayList<>();
        loginViewModel.getmListJsonLiveData().observe(this, databases -> {
            for (int i = 0 ; i < databases.size(); i++){
                TINH.add(new ItemCombobox(databases.get(i).getID(), "", databases.get(i).getTenSite()));
            }
        });
        ComboboxAdapter adapter = new ComboboxAdapter(this, TINH, 1);
        dangNhapBinding.tinh.setAdapter(adapter);
    }
}