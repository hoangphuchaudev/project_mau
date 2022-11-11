package vn.nhattamsoft.project_mau.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.res.Resources;
import android.os.Bundle;

import vn.nhattamsoft.project_mau.R;
import vn.nhattamsoft.project_mau.adapters.ThemeAdapter;
import vn.nhattamsoft.project_mau.databinding.ActivityTuyChinhGiaoDienBinding;
import vn.nhattamsoft.project_mau.viewmodels.TuyChinhGiaoDienVM;

public class TuyChinhGiaoDien extends AppCompatActivity {
    private ActivityTuyChinhGiaoDienBinding activityTuyChinhGiaoDienBinding;
    public TuyChinhGiaoDienVM tuyChinhGiaoDienVM;
    private ThemeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTuyChinhGiaoDienBinding = DataBindingUtil.setContentView(this, R.layout.activity_tuy_chinh_giao_dien);
        tuyChinhGiaoDienVM = new TuyChinhGiaoDienVM();
        activityTuyChinhGiaoDienBinding.setTuyChinhGiaoDienVM(tuyChinhGiaoDienVM);
        activityTuyChinhGiaoDienBinding.executePendingBindings();
        activityTuyChinhGiaoDienBinding.toolbar.title.setText("Tùy chỉnh giao diện");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        activityTuyChinhGiaoDienBinding.rcv.setLayoutManager(layoutManager);
        tuyChinhGiaoDienVM.LoadItem();
        loadList();

        activityTuyChinhGiaoDienBinding.toolbar.back.setOnClickListener(v -> {
            TuyChinhGiaoDien.super.onBackPressed();
            overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
        });
    }
    public void loadList() {
        tuyChinhGiaoDienVM.getMutableLiveData().observe(this, itemDemos -> {
            adapter = new ThemeAdapter(itemDemos,this);
            activityTuyChinhGiaoDienBinding.rcv.setAdapter(adapter);
        });
    }
}