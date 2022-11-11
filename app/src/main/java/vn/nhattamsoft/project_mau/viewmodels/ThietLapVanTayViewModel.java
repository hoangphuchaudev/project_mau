package vn.nhattamsoft.project_mau.viewmodels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import vn.nhattamsoft.project_mau.BR;
import vn.nhattamsoft.project_mau.SharedPreferences.SharedPrefs;
import vn.nhattamsoft.project_mau.model.ThietBi;

public class ThietLapVanTayViewModel extends BaseObservable {
    private MutableLiveData<List<ThietBi>> mListThietBiLiveData;
    private List<ThietBi> mListItemThietBi;

    @Bindable
    private boolean disable = false;
    public boolean getDisable() {
        return disable;
    }
    public void setDisable(boolean disable) {
        this.disable = disable;
        notifyPropertyChanged(BR.disable);
    }

    public ThietLapVanTayViewModel() {
        try {
            disable = SharedPrefs.getInstance().get("FingerPrint",boolean.class, false);
        }catch (Exception exception){
        }
        mListThietBiLiveData = new MutableLiveData<>();
    }
    public void LoadItem() {
        mListItemThietBi = new ArrayList<>();
        for (int i = 0 ; i < 5; i++){
            mListItemThietBi.add(new ThietBi(i + "", "","Android "+(i+1),"samsung","Android","11","",""));
        }
        mListThietBiLiveData.setValue(mListItemThietBi);
    }

    public void ThietLap(boolean isChecked){
        if(isChecked){
            setDisable(false);
        }else {
            setDisable(true);
        }
        SharedPrefs.getInstance().put("FingerPrint", isChecked);
    }

    public MutableLiveData<List<ThietBi>> getmListThietBiLiveData() {
        return mListThietBiLiveData;
    }
}
