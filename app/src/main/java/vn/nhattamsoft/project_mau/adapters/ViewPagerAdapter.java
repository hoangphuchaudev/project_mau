package vn.nhattamsoft.project_mau.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.nhattamsoft.project_mau.fragments.TrangCaNhanFragment;
import vn.nhattamsoft.project_mau.fragments.TrangChuFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new TrangChuFragment();
            case 1:
                return new TrangCaNhanFragment();
            default:
                return new TrangChuFragment();
        }
    }

    @Override
    public int getItemCount() {
return 2    ;
    }
}
