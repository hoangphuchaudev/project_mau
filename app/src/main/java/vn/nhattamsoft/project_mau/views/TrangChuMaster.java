package vn.nhattamsoft.project_mau.views;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import vn.nhattamsoft.project_mau.R;
import vn.nhattamsoft.project_mau.adapters.ViewPagerAdapter;

public class TrangChuMaster extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    public static ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_master);
        viewPager = findViewById(R.id.view_pager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setUserInputEnabled(false);// vô hiệu hóa vuốt ngang để chuyển trang
        viewPager.setAdapter(adapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.menu_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.menu_info).setChecked(true);
                        break;
                }
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.menu_info:
                        viewPager.setCurrentItem(1);
                        break;
                }
                return true;
            }
        });
    }
}