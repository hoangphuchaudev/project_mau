package vn.nhattamsoft.project_mau.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import vn.nhattamsoft.project_mau.Class.ThongBao;
import vn.nhattamsoft.project_mau.R;
import vn.nhattamsoft.project_mau.model.Item.ItemMenuCaNhan;
import vn.nhattamsoft.project_mau.views.DieuKhoanSuDung;
import vn.nhattamsoft.project_mau.views.GioiThieu;
import vn.nhattamsoft.project_mau.views.LienHe;
import vn.nhattamsoft.project_mau.views.ThietLapVanTay;
import vn.nhattamsoft.project_mau.views.ThongTinCaNhan;
import vn.nhattamsoft.project_mau.views.TrangChuMaster;
import vn.nhattamsoft.project_mau.views.TuyChinhGiaoDien;

public class MenuCaNhanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final int TYPE_HEADER = 0;
    public final int TYPE_ITEM = 1;
    private final ItemMenuCaNhan[] listMenu;
    private final Context mContext;

    public MenuCaNhanAdapter(Context mContext, ItemMenuCaNhan[] listMenu) {
        this.listMenu = listMenu;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        if (viewType == TYPE_HEADER) {
            View view0 = inflater.inflate(R.layout.item_header_menu_ca_nhan, parent, false);
            return new ViewHolderHeader(view0);
        }
        else{
            View view1 = inflater.inflate(R.layout.item_menu_ca_nhan, parent, false);
            return new ViewHolder(view1);
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == TYPE_HEADER) {
            ViewHolderHeader viewHolderHeader = (ViewHolderHeader) holder;
            viewHolderHeader.loai.setText(listMenu[position].getLoai());
        }else {
            ItemMenuCaNhan itemMenuCaNhan = listMenu[position];
            ViewHolder viewHolder = (ViewHolder) holder;
            Glide.with(mContext)
                    .load(itemMenuCaNhan.getImg())
                    .into(viewHolder.image);
            viewHolder.ten.setText(itemMenuCaNhan.getTen());
            viewHolder.miniten.setText(itemMenuCaNhan.getMiniTen());
            if (itemMenuCaNhan.getBoTron() == ItemMenuCaNhan.BOTTOM) {
                viewHolder.relativeLayout.setBackground(mContext.getResources().getDrawable(R.drawable.radius_bottom));
            } else if (itemMenuCaNhan.getBoTron() == ItemMenuCaNhan.TOP) {
                viewHolder.relativeLayout.setBackground(mContext.getResources().getDrawable(R.drawable.radius_top));
            }
            else {
                viewHolder.relativeLayout.setBackground(mContext.getResources().getDrawable(R.drawable.radiusnone));
            }

            viewHolder.itemView.setOnClickListener(v -> {
                TrangChuMaster activity = (TrangChuMaster) mContext;
                switch (itemMenuCaNhan.getTen()){
                    case "Th??ng tin c?? nh??n":
                        mContext.startActivity(new Intent(mContext, ThongTinCaNhan.class));
                        activity.overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
                        break;
                    case "Li??n k???t t??i kho???n":
                        ThongBao.Show(mContext, "Li??n k???t t??i kho???n");
                        break;
                    case "?????i m???t kh???u":
                        ThongBao.Show(mContext, "?????i m???t kh???u");
                        break;
                    case "????ng nh???p v??n tay":
                        mContext.startActivity(new Intent(mContext, ThietLapVanTay.class));
                        activity.overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
                        break;
                    case "T??y ch???nh giao di???n":
                        mContext.startActivity(new Intent(mContext, TuyChinhGiaoDien.class));
                        activity.overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
                        break;
                    case "Th??ng tin nh?? ph??t tri???n":
                        ThongBao.Show(mContext, "Th??ng tin nh?? ph??t tri???n");
                        break;
                    case "??i???u kho???n s??? d???ng":
                        mContext.startActivity(new Intent(mContext, DieuKhoanSuDung.class));
                        activity.overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
                        break;
                    case "Th??ng tin ???ng d???ng":
                        mContext.startActivity(new Intent(mContext, GioiThieu.class));
                        activity.overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
                        break;
                    case "Li??n h???":

                        mContext.startActivity(new Intent(mContext, LienHe.class));
                        activity.overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
                        break;
                    case "????ng xu???t":
                        ThongBao.Show(mContext, "????ng xu???t");
                        break;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listMenu.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final TextView ten;
        private final TextView miniten;
        private final RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            ten = itemView.findViewById(R.id.ten);
            miniten = itemView.findViewById(R.id.miniten);
            relativeLayout = itemView.findViewById(R.id.rl);
        }
    }
    public static class ViewHolderHeader extends RecyclerView.ViewHolder {
        private final TextView loai;

        public ViewHolderHeader(@NonNull View itemView) {
            super(itemView);
            loai = itemView.findViewById(R.id.loai);
        }
    }
    @Override
    public int getItemViewType(int position) {
        return listMenu[position].getLoai().isEmpty() ? TYPE_ITEM : TYPE_HEADER;
    }
}
