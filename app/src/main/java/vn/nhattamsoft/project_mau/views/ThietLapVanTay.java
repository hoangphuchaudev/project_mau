package vn.nhattamsoft.project_mau.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import vn.nhattamsoft.project_mau.R;
import vn.nhattamsoft.project_mau.adapters.ThietBiAdapter;
import vn.nhattamsoft.project_mau.databinding.ActivityThietLapVanTayBinding;
import vn.nhattamsoft.project_mau.viewmodels.ThietLapVanTayViewModel;

public class ThietLapVanTay extends AppCompatActivity {
    private ActivityThietLapVanTayBinding activityThietLapVanTayBinding;
    ThietLapVanTayViewModel thietLapVanTayViewModel;
    private ThietBiAdapter thietBiAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityThietLapVanTayBinding = DataBindingUtil.setContentView(this, R.layout.activity_thiet_lap_van_tay);
        thietLapVanTayViewModel = new ThietLapVanTayViewModel();
        activityThietLapVanTayBinding.setThietLapVanTayViewModel(thietLapVanTayViewModel);
        activityThietLapVanTayBinding.executePendingBindings();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        activityThietLapVanTayBinding.rcvThietbi.setLayoutManager(layoutManager);
        thietLapVanTayViewModel.LoadItem();
        loadList();
        activityThietLapVanTayBinding.toolbar.title.setText("Đăng nhập vân tay");
        activityThietLapVanTayBinding.toolbar.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThietLapVanTay.super.onBackPressed();
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
            }
        });
        activityThietLapVanTayBinding.btnswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    activityThietLapVanTayBinding.viewDisableLayout.setVisibility(View.GONE);
//                    activityThietLapVanTayBinding.rcvThietbi.setAlpha(1f);
//                }else {
//                    activityThietLapVanTayBinding.viewDisableLayout.setVisibility(View.VISIBLE);
//                    activityThietLapVanTayBinding.rcvThietbi.setAlpha(0.3f);
//                }
//                SharedPrefs.getInstance().put("FingerPrint", isChecked+"");
//                string sql = "update ThietBi set NgungSD=" + (e.Value == true ? 0 : 1).ToString() + " output inserted.*  where ThietBiID='" + thietBi.ThietBiID + "'";
//                DataTable data = SqlHelper.ExecuteDataset(Application.Current.Properties["ConnectUserQLLD"].ToString(), CommandType.Text, sql, null).Tables[0];
            }
        });
    }
    public void loadList() {
//        try {
//            if(SharedPrefs.getInstance().get("FingerPrint", boolean.class, false)){
//                activityThietLapVanTayBinding.viewDisableLayout.setVisibility(View.GONE);
//                activityThietLapVanTayBinding.rcvThietbi.setAlpha(1f);
//                activityThietLapVanTayBinding.btnswitch.setChecked(true);
//            }else {
//                activityThietLapVanTayBinding.viewDisableLayout.setVisibility(View.VISIBLE);
//                activityThietLapVanTayBinding.rcvThietbi.setAlpha(0.3f);
//                activityThietLapVanTayBinding.btnswitch.setChecked(false);
//            }
//        }catch (Exception exception){
//            activityThietLapVanTayBinding.viewDisableLayout.setVisibility(View.VISIBLE);
//            activityThietLapVanTayBinding.rcvThietbi.setAlpha(0.3f);
//            activityThietLapVanTayBinding.btnswitch.setChecked(false);
//        }

        thietLapVanTayViewModel.getmListThietBiLiveData().observe(this, itemDemos -> {
            thietBiAdapter = new ThietBiAdapter(itemDemos,this);
            activityThietLapVanTayBinding.rcvThietbi.setAdapter(thietBiAdapter);
        });
    }
}