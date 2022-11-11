package vn.nhattamsoft.project_mau.fragments;

import static com.github.mikephil.charting.utils.ColorTemplate.rgb;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.MPPointF;
import com.google.android.material.navigation.NavigationView;

import java.text.NumberFormat;
import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import vn.nhattamsoft.project_mau.R;
import vn.nhattamsoft.project_mau.SharedPreferences.SharedPrefs;
import vn.nhattamsoft.project_mau.databinding.FragmentTrangChuBinding;
import vn.nhattamsoft.project_mau.interfaces.APIService;
import vn.nhattamsoft.project_mau.model.API.API_Data;
import vn.nhattamsoft.project_mau.model.API.API_Exec;
import vn.nhattamsoft.project_mau.model.Json;
import vn.nhattamsoft.project_mau.viewmodels.TrangChuViewModel;

public class TrangChuFragment extends Fragment {

    protected Typeface tfRegular;
    protected Typeface tfLight;
    FragmentTrangChuBinding fragmentTrangChuBinding;
    TrangChuViewModel trangChuViewModel;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    public TrangChuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentTrangChuBinding = FragmentTrangChuBinding.inflate(getLayoutInflater());
        trangChuViewModel = new TrangChuViewModel();
        trangChuViewModel = new ViewModelProvider(TrangChuFragment.this).get(TrangChuViewModel.class);
        fragmentTrangChuBinding.setTrangChuViewModel(trangChuViewModel);

        drawerLayout = getActivity().findViewById(R.id.drawer_layout);
        navigationView= getActivity().findViewById(R.id.nav_view);

        navigationView.bringToFront();
        fragmentTrangChuBinding.btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
//        setTTDonVi();

        // Inflate the layout for this fragment
        tfRegular = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Regular.ttf");
        tfLight = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Light.ttf");

        setData();
        return fragmentTrangChuBinding.getRoot();
    }

    private void setTTDonVi(){
        APIService.apiservice.exec(new API_Exec("Select * from DonVi where DonViID = @DonViID", new API_Data[] {
                        new API_Data("guid","DonViID",SharedPrefs.getInstance().get("DonViID",String.class,"00000000-0000-0000-0000-000000000000"))
                }))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Json>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }
                    @Override
                    public void onNext(@NonNull Json json) {
                        if(json != null){
//                            JsonObject jsonObject = json;
//                            JsonArray dataArray = jsonObject.getAsJsonArray("data");
//                            if (dataArray.size() > 0) {
//                                JsonObject object = dataArray.get(0).getAsJsonObject();
//                                SharedPrefs.getInstance().put("XaID", object.get("XaID").getAsString());
//                                SharedPrefs.getInstance().put("HuyenID", object.get("HuyenID").getAsString());
//                                SharedPrefs.getInstance().put("TinhID", object.get("TinhID").getAsString());
//                                SharedPrefs.getInstance().put("TenDonVi", object.get("TenDVBaoCao").getAsString());
//                                SharedPrefs.getInstance().put("CapNganSach", object.get("CapDonVi").getAsString());
//                            }
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Toast.makeText(getContext(),e.toString(),Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void setData() {
        fragmentTrangChuBinding.chart2.setUsePercentValues(true);
        fragmentTrangChuBinding.chart2.getDescription().setEnabled(false);
        fragmentTrangChuBinding.chart2.setExtraOffsets(-10, 5, -10, -10);

        fragmentTrangChuBinding.chart2.setDragDecelerationFrictionCoef(0.95f);

        fragmentTrangChuBinding.chart2.setCenterTextTypeface(tfLight);

        fragmentTrangChuBinding.chart2.setDrawHoleEnabled(true);
        fragmentTrangChuBinding.chart2.setHoleColor(Color.WHITE);

        fragmentTrangChuBinding.chart2.setTransparentCircleColor(Color.WHITE);
        fragmentTrangChuBinding.chart2.setTransparentCircleAlpha(110);

        fragmentTrangChuBinding.chart2.setHoleRadius(48f);
        fragmentTrangChuBinding.chart2.setTransparentCircleRadius(60f);

        fragmentTrangChuBinding.chart2.setDrawCenterText(true);

        fragmentTrangChuBinding.chart2.setRotationAngle(0);
        fragmentTrangChuBinding.chart2.setRotationEnabled(true);
        fragmentTrangChuBinding.chart2.setHighlightPerTapEnabled(true);

        fragmentTrangChuBinding.chart2.animateY(1400, Easing.EaseInOutQuad);

        Legend l = fragmentTrangChuBinding.chart2.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        fragmentTrangChuBinding.chart2.setEntryLabelColor(Color.WHITE);
        fragmentTrangChuBinding.chart2.setEntryLabelTypeface(tfRegular);
        fragmentTrangChuBinding.chart2.setEntryLabelTextSize(7);
        fragmentTrangChuBinding.chart2.setNoDataText("Không có dữ liệu");
        fragmentTrangChuBinding.chart2.setCenterText("Giới tính");
        fragmentTrangChuBinding.chart2.setCenterTextSize(8);

//        API_Data[] api_data = new API_Data[]{
//            new API_Data("number","TuNam","2019"),
//            new API_Data("number","DenNam","2022"),
//            new API_Data("guid","TinhID",SharedPrefs.getInstance().get("TinhID",String.class,"00000000-0000-0000-0000-000000000000")),
//            new API_Data("guid","HuyenID",SharedPrefs.getInstance().get("HuyenID",String.class,"00000000-0000-0000-0000-000000000000")),
//            new API_Data("guid","XaID",SharedPrefs.getInstance().get("XaID",String.class,"00000000-0000-0000-0000-000000000000")),
//            new API_Data("guid","TinhID_LamViec","00000000-0000-0000-0000-000000000000"),
//            new API_Data("guid","QuocGiaID_LamViec","00000000-0000-0000-0000-000000000000"),
//            new API_Data("guid","DonViID",SharedPrefs.getInstance().get("DonViID",String.class,"00000000-0000-0000-0000-000000000000"))
//        };
//        Toast.makeText(getContext(),SharedPrefs.getInstance().get("UserGroupCode",String.class,""), Toast.LENGTH_SHORT).show();
//        trangChuViewModel.LoadData(api_data,TrangChuFragment.this, SharedPrefs.getInstance().get("UserGroupCode",String.class,""));

        ArrayList<PieEntry> entries = new ArrayList<>();

//        trangChuViewModel.getmListJsonLiveData().observe(getActivity(), soLieuTKNhanhs -> {
//            if(soLieuTKNhanhs != null){
//                entries.add(new PieEntry((float)( soLieuTKNhanhs.get(0).getTongNam()/soLieuTKNhanhs.get(0).getTongCoVL())*100,
//                        "Nam",
//                        getResources().getDrawable(R.drawable.location)));
//                entries.add(new PieEntry((float)( soLieuTKNhanhs.get(0).getTongNu()/soLieuTKNhanhs.get(0).getTongCoVL())*100,
//                        "Nữ",
//                        getResources().getDrawable(R.drawable.location)));
        entries.add(new PieEntry((float)0.5*100,
                "Nam",
                getResources().getDrawable(R.drawable.location)));
        entries.add(new PieEntry((float)0.5*100,
                "Nữ",
                getResources().getDrawable(R.drawable.location)));
        PieDataSet dataSet = new PieDataSet(entries, "");

        dataSet.setDrawIcons(false);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(rgb("#FF42A5F5"));
        colors.add(rgb("#FFFF5252"));

        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(10);
        data.setValueTextColor(Color.WHITE);
        data.setValueTypeface(tfLight);
        fragmentTrangChuBinding.chart2.setData(data);
        fragmentTrangChuBinding.chart2.highlightValues(null);

        fragmentTrangChuBinding.chart2.invalidate();
        NumberFormat currencyVN = NumberFormat.getInstance();
//                String tongNam = currencyVN.format(soLieuTKNhanhs.get(0).getTongNam());
//                String tongNu = currencyVN.format(soLieuTKNhanhs.get(0).getTongNu());
//                String TongCong = currencyVN.format(soLieuTKNhanhs.get(0).getTongCoVL());
//                fragmentTrangChuBinding.TongNam.setText(tongNam);
//                fragmentTrangChuBinding.TongNu.setText(tongNu);
//                fragmentTrangChuBinding.TongNamNu.setText(TongCong);
//                fragmentTrangChuBinding.tkTren15.setText(currencyVN.format(soLieuTKNhanhs.get(0).getTong15HT()));
//                fragmentTrangChuBinding.tkTGKT.setText(currencyVN.format(soLieuTKNhanhs.get(0).getTongTGKTHT()));
//                fragmentTrangChuBinding.tkKTGKT.setText(currencyVN.format(soLieuTKNhanhs.get(0).getTongKTGKTHT()));
//                fragmentTrangChuBinding.tkDQDT.setText(currencyVN.format(soLieuTKNhanhs.get(0).getTongDQDTHT()));

//            }
//        });


    }
}