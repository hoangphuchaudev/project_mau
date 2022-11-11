package vn.nhattamsoft.project_mau.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.nhattamsoft.project_mau.R;
import vn.nhattamsoft.project_mau.SharedPreferences.SharedPrefs;
import vn.nhattamsoft.project_mau.databinding.ItemTuyChinhGiaoDienBinding;
import vn.nhattamsoft.project_mau.model.Theme;
import vn.nhattamsoft.project_mau.views.TuyChinhGiaoDien;

public class ThemeAdapter extends  RecyclerView.Adapter<ThemeAdapter.ThemeViewHolder>{
    List<Theme> mItems;
    Context mContext;

    public ThemeAdapter(List<Theme> mItems, Context mContext) {
        this.mItems = mItems;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public ThemeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemTuyChinhGiaoDienBinding itemTuyChinhGiaoDienBinding = ItemTuyChinhGiaoDienBinding.inflate(layoutInflater, parent, false);
        return new ThemeViewHolder(itemTuyChinhGiaoDienBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ThemeViewHolder holder, int position) {
        Theme item = mItems.get(position);
        holder.itemTuyChinhGiaoDienBinding.setItemTheme(item);
        holder.itemTuyChinhGiaoDienBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if(mItems != null){
            return mItems.size();
        }
        return 0;
    }
    class ThemeViewHolder extends RecyclerView.ViewHolder{
        ItemTuyChinhGiaoDienBinding itemTuyChinhGiaoDienBinding;
        public ThemeViewHolder(@NonNull ItemTuyChinhGiaoDienBinding itemTuyChinhGiaoDienBinding) {
            super(itemTuyChinhGiaoDienBinding.getRoot());
            this.itemTuyChinhGiaoDienBinding = itemTuyChinhGiaoDienBinding;
            itemTuyChinhGiaoDienBinding.btnApDung.setOnClickListener(view -> {
                SharedPrefs.getInstance().put("Theme", itemTuyChinhGiaoDienBinding.getItemTheme().ID+"");
                TuyChinhGiaoDien activity = (TuyChinhGiaoDien) mContext;
                activity.tuyChinhGiaoDienVM.LoadItem();
                if(itemTuyChinhGiaoDienBinding.getItemTheme().ID == 2){
                }
            });
        }
    }

}
