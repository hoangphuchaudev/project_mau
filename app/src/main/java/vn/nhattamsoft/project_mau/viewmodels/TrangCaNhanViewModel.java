package vn.nhattamsoft.project_mau.viewmodels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import vn.nhattamsoft.project_mau.BR;
import vn.nhattamsoft.project_mau.R;
import vn.nhattamsoft.project_mau.SharedPreferences.SharedPrefs;
import vn.nhattamsoft.project_mau.model.Item.ItemMenuCaNhan;
import vn.nhattamsoft.project_mau.model.User;

public class TrangCaNhanViewModel extends BaseObservable {

    @Bindable
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
        notifyPropertyChanged(BR.user);
    }
    private ItemMenuCaNhan[] listItems;

    public TrangCaNhanViewModel() {
        User login = SharedPrefs.getInstance().get("User", User.class);
        setUser(login);
    }

    public ItemMenuCaNhan[] loadMenu(){
        ItemMenuCaNhan[] thongTinCaNhan = new ItemMenuCaNhan[]{
                new ItemMenuCaNhan("Thiết lập tài khoản"),
                new ItemMenuCaNhan("Thông tin cá nhân", "Chỉnh sửa thông tin", R.drawable.personal_information, ItemMenuCaNhan.TOP),
                new ItemMenuCaNhan("Liên kết tài khoản", "Kết nối với tài khoản khác như: facebook,google", R.drawable.connect, ItemMenuCaNhan.NONE),
                new ItemMenuCaNhan("Đổi mật khẩu", "Thay đổi mật khẩu", R.drawable.shieldd, ItemMenuCaNhan.BOTTOM),
                new ItemMenuCaNhan("Thiết lập tùy chọn"),
                new ItemMenuCaNhan("Đăng nhập vân tay", "Kích hoạt FaceID để đăng nhập", R.drawable.fingerprintd, ItemMenuCaNhan.TOP),
                new ItemMenuCaNhan("Tùy chỉnh giao diện", "Thay đổi màu giao diện", R.drawable.color_selection1, ItemMenuCaNhan.BOTTOM),
                new ItemMenuCaNhan("Tùy chọn khác"),
                new ItemMenuCaNhan("Thông tin nhà phát triển", "Công ty phần mềm nhất tâm", R.drawable.coded, ItemMenuCaNhan.TOP),
                new ItemMenuCaNhan("Điều khoản sử dụng", "Những lưu ý khi sử dụng ứng dụng", R.drawable.compliant, ItemMenuCaNhan.NONE),
                new ItemMenuCaNhan("Thông tin ứng dụng", "Giới thiệu chi tiết ứng dụng", R.drawable.infod, ItemMenuCaNhan.NONE),
                new ItemMenuCaNhan("Liên hệ", "Thông tin liên hệ", R.drawable.contactd, ItemMenuCaNhan.NONE),
                new ItemMenuCaNhan("Đăng xuất", "Thoát khỏi ứng dụng", R.drawable.logout2, ItemMenuCaNhan.BOTTOM)
        };
        return thongTinCaNhan;
    }
}