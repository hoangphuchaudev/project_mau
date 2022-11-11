package vn.nhattamsoft.project_mau.viewmodels;

import static android.content.ContentValues.TAG;

import static vn.nhattamsoft.project_mau.interfaces.APIService.gson;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import vn.nhattamsoft.project_mau.BR;
import vn.nhattamsoft.project_mau.R;
import vn.nhattamsoft.project_mau.SharedPreferences.SharedPrefs;
import vn.nhattamsoft.project_mau.interfaces.APIService;
import vn.nhattamsoft.project_mau.model.API.API_Login;
import vn.nhattamsoft.project_mau.model.Database;
import vn.nhattamsoft.project_mau.model.Item.ItemCombobox;
import vn.nhattamsoft.project_mau.model.Json;
import vn.nhattamsoft.project_mau.model.User;

public class LoginViewModel extends BaseObservable {
    private final Activity ACTIVITY;
    public static final int THATBAI = 1;
    public static final int SAIMATKHAU = 2;
    public static final int THANHCONG = 3;
    private Json json;
    private MutableLiveData<List<Database>> mListJsonLiveData = new MutableLiveData<>();
    public MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();
    public MutableLiveData<Integer> trangThaiLiveData = new MutableLiveData<>();
    private ItemCombobox database;
    public ItemCombobox getDatabase() {
        return database;
    }
    public void setDatabase(ItemCombobox database) {
        this.database = database;
    }


    @Bindable
    private String loiTaiKhoan = "";
    public String getLoiTaiKhoan() {
        return loiTaiKhoan;
    }
    public void setLoiTaiKhoan(String loiTaiKhoan) {
        this.loiTaiKhoan = loiTaiKhoan;
        notifyPropertyChanged(BR.loiTaiKhoan);
    }
    @Bindable
    private String loiMatKhau = "";
    public String getLoiMatKhau() {
        return loiMatKhau;
    }
    public void setLoiMatKhau(String loiMatKhau) {
        this.loiMatKhau = loiMatKhau;
        notifyPropertyChanged(BR.loiMatKhau);
    }
    @Bindable
    private String loiTinh = "";
    public String getLoiTinh() {
        return loiTinh;
    }
    public void setLoiTinh(String loiTinh) {
        this.loiTinh = loiTinh;
        notifyPropertyChanged(BR.loiTinh);
    }


    @Bindable
    private String taiKhoan = "";
    public String getTaiKhoan(){
        return taiKhoan;
    }
    public void setTaiKhoan(String tk){
        this.taiKhoan = tk;
        notifyPropertyChanged(BR.taiKhoan);
    }

    @Bindable
    public String matKhau = "";

    public String getMatKhau() {
        return matKhau;
    }
    public void setMatKhau(String mk){
        this.matKhau = mk;
        notifyPropertyChanged(BR.matKhau);
    }

    @Bindable
    public String tinh;

    public String getTinh() {
        return tinh;
    }
    public void setTinh(String dv){
        this.tinh = dv;
        notifyPropertyChanged(BR.tinh);
    }

    @Bindable
    public String nam;

    public String getNam() {
        return nam;
    }
    public void setNam(String n){
        this.nam = n;
        notifyPropertyChanged(BR.nam);
    }

    private List<Database> Data;

    public LoginViewModel(Activity activity) {
        ACTIVITY = activity;
    }
    public boolean KiemTra(){
        boolean kt = true;
        if (TextUtils.isEmpty(taiKhoan)){
            setLoiTaiKhoan(ACTIVITY.getResources().getString(R.string.taikhoankhongduocdetrong));
            kt = false;
        }else {
            setLoiTaiKhoan("");
        }
        if (TextUtils.isEmpty(matKhau)){
            setLoiMatKhau(ACTIVITY.getResources().getString(R.string.matkhaukhongduocdetrong));
            kt = false;
        }else {
            setLoiMatKhau("");
        }
        if (database == null){
            setLoiTinh(ACTIVITY.getResources().getString(R.string.tinhkhongduocdetrong));
            kt = false;
        }else {
            setLoiTinh("");
        }
        return kt;
    }
    public void LoginAPI() {
        if(KiemTra()){
            Log.d(TAG, "LoginAPI: "+database.getID());
            loadingLiveData.setValue(true);
            APIService.apiservice.loginAPI(new API_Login(taiKhoan,matKhau, database.getID()))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Json>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {
                        }
                        @Override
                        public void onNext(@NonNull Json json1) {
                            json = json1;
                            Log.d(TAG, "onNext: "  + json.toString());
                            JsonObject data = gson.fromJson(json.data, JsonObject.class);
                            if(json.isSuccess()){
                                // lưu lại tài khoản
                                User user = gson.fromJson(data, User.class);
                                SharedPrefs.getInstance().put("User", user);
                                SharedPrefs.getInstance().put("Token", user.getToken());
                            }
                        }
                        @Override
                        public void onError(@NonNull Throwable e) {
                            loadingLiveData.setValue(false);
                            trangThaiLiveData.setValue(THATBAI);
                        }
                        @Override
                        public void onComplete() {
                            loadingLiveData.setValue(false);
                            if(!json.isSuccess()){
                                trangThaiLiveData.setValue(SAIMATKHAU);
                                return;
                            }
                            trangThaiLiveData.setValue(THANHCONG);
                        }
                    });
        }
    }
    public MutableLiveData<List<Database>> getmListJsonLiveData(){
        return mListJsonLiveData;
    }

    public void loadDatabase(){
        Data = new ArrayList<>();
        APIService.apiservice.getDatabase().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Json>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}
                    @Override
                    public void onNext(@NonNull Json js) {
                        JsonArray jsonArray = js.getData();
                        for (int i = 0; i < jsonArray.size(); i++) {
                            Data.add(gson.fromJson(jsonArray.get(i), Database.class));
                        }
                        mListJsonLiveData.setValue(Data);
                    }
                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
