package vn.nhattamsoft.project_mau.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import vn.nhattamsoft.project_mau.fragments.TrangChuFragment;
import vn.nhattamsoft.project_mau.interfaces.APIService;
import vn.nhattamsoft.project_mau.model.API.API_Data;
import vn.nhattamsoft.project_mau.Class.Loading;
import vn.nhattamsoft.project_mau.model.SoLieuTKNhanh;

public class TrangChuViewModel extends ViewModel {
    private MutableLiveData<List<SoLieuTKNhanh>> mListJsonLiveData;
    private List<SoLieuTKNhanh> Data;

    public TrangChuViewModel() {
        mListJsonLiveData = new MutableLiveData<>();
    }
    public MutableLiveData<List<SoLieuTKNhanh>> getmListJsonLiveData(){
        return mListJsonLiveData;
    }

    public void LoadData(API_Data[] paramList, TrangChuFragment trangChuFragment, String UserGroupCode)
    {
        Loading loading = Loading.setContext(trangChuFragment.getContext());
        loading.startLoading();
        Data = new ArrayList<>();
        String Proc = "";
        if(UserGroupCode=="Tinh")
            Proc= "Proc_BCTTCungLD_Huyen_Mobile";
        else
            Proc= "Proc_BCTTCungLD_Xa_Mobile";

        APIService.apiservice.api(Proc,paramList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }
                    @Override
                    public void onNext(@NonNull JsonObject json) {
                        if(json != null){
                            JsonObject jsonObject = json;
                            JsonArray dataArray = jsonObject.getAsJsonArray("data");
                            if (dataArray.size() > 0) {
                                JsonObject object = dataArray.get(1).getAsJsonObject();
                                Data.add(new SoLieuTKNhanh(
                                        object.get("Ma05").getAsFloat(),
                                        object.get("Ma06").getAsFloat(),
                                        (object.get("Ma05").getAsFloat()+object.get("Ma06").getAsFloat()),
                                        object.get("Ma01").getAsFloat(),
                                        object.get("Ma02").getAsFloat(),
                                        object.get("Ma15").getAsFloat(),
                                        object.get("Ma20").getAsFloat()));
                            }
                            mListJsonLiveData.setValue(Data);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        loading.endLoading();
                    }
                });
    }
}
