package vn.nhattamsoft.project_mau.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import vn.nhattamsoft.project_mau.databinding.ItemThietLapVanTayBinding;
import vn.nhattamsoft.project_mau.interfaces.APIService;
import vn.nhattamsoft.project_mau.model.API.API_Data;
import vn.nhattamsoft.project_mau.model.API.API_Exec;
import vn.nhattamsoft.project_mau.model.Json;
import vn.nhattamsoft.project_mau.model.ThietBi;

public class ThietBiAdapter extends  RecyclerView.Adapter<ThietBiAdapter.ThietBiViewHolder>{
    List<ThietBi> mItems;
    Context mContext;

    public ThietBiAdapter(List<ThietBi> mItems, Context mContext) {
        this.mItems = mItems;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public ThietBiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemThietLapVanTayBinding itemThietLapVanTayBinding = ItemThietLapVanTayBinding.inflate(layoutInflater, parent, false);
        return new ThietBiViewHolder(itemThietLapVanTayBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ThietBiViewHolder holder, int position) {
        ThietBi item = mItems.get(position);
        holder.itemThietLapVanTayBinding.setItemThietBi(item);
        holder.itemThietLapVanTayBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if(mItems != null){
            return mItems.size();
        }
        return 0;
    }
    class ThietBiViewHolder extends RecyclerView.ViewHolder{
        ItemThietLapVanTayBinding itemThietLapVanTayBinding;
        public ThietBiViewHolder(@NonNull ItemThietLapVanTayBinding itemThietLapVanTayBinding) {
            super(itemThietLapVanTayBinding.getRoot());
            this.itemThietLapVanTayBinding = itemThietLapVanTayBinding;
            itemThietLapVanTayBinding.switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    ThietLapVanTay(itemThietLapVanTayBinding.getItemThietBi(), isChecked);
                }
            });
        }
    }
    public void ThietLapVanTay(ThietBi thietBi, boolean isChecked){
        String sql = "update ThietBi set NgungSD= @NgungSD output inserted.*  where ThietBiID=@ThietBiID";
        APIService.apiservice.exec(new API_Exec(sql, new API_Data[] {
            new API_Data("bool","@NgungSD", isChecked+""),
            new API_Data("string","@ThietBiID", thietBi.getThietBiID()),
                }))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Json>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
                    }
                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull Json json) {
                        if(json != null){
                        }
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Toast.makeText(mContext,e.toString(),Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }
}
