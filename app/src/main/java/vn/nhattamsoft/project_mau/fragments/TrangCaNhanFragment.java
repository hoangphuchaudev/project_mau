package vn.nhattamsoft.project_mau.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.nhattamsoft.project_mau.R;
import vn.nhattamsoft.project_mau.adapters.MenuCaNhanAdapter;
import vn.nhattamsoft.project_mau.databinding.FragmentTrangCaNhanBinding;
import vn.nhattamsoft.project_mau.databinding.FragmentTrangChuBinding;
import vn.nhattamsoft.project_mau.viewmodels.TrangCaNhanViewModel;

public class TrangCaNhanFragment extends Fragment {
    MenuCaNhanAdapter menuCaNhanAdapter;
    FragmentTrangCaNhanBinding fragmentTrangCaNhanBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentTrangCaNhanBinding = FragmentTrangCaNhanBinding.inflate(getLayoutInflater());
        TrangCaNhanViewModel viewModel = new TrangCaNhanViewModel();
        fragmentTrangCaNhanBinding.setViewModel(viewModel);
        fragmentTrangCaNhanBinding.executePendingBindings();

        menuCaNhanAdapter = new MenuCaNhanAdapter(getActivity(), viewModel.loadMenu());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        fragmentTrangCaNhanBinding.menu.setLayoutManager(linearLayoutManager);
        fragmentTrangCaNhanBinding.menu.setAdapter(menuCaNhanAdapter);

        return fragmentTrangCaNhanBinding.getRoot();
    }
    public TrangCaNhanFragment() {
    }
}