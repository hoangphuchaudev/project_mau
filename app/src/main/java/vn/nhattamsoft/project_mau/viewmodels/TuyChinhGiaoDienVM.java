package vn.nhattamsoft.project_mau.viewmodels;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import vn.nhattamsoft.project_mau.R;
import vn.nhattamsoft.project_mau.SharedPreferences.SharedPrefs;
import vn.nhattamsoft.project_mau.model.Theme;
import vn.nhattamsoft.project_mau.model.ThietBi;

public class TuyChinhGiaoDienVM extends BaseObservable {
    private MutableLiveData<List<Theme>> mutableLiveData;
    private List<Theme> themeList;

    public TuyChinhGiaoDienVM() {
//        try {
//            disable = SharedPrefs.getInstance().get("FingerPrint",boolean.class, false);
//        }catch (Exception exception){
//        }
        mutableLiveData = new MutableLiveData<>();
    }

    public void LoadItem() {
        themeList = new ArrayList<>();
        themeList.add(new Theme(
                1,
                "Màu cá tính",
                "Với tệp màu này ứng dụng của bạn trở nên cá tính hơn nhưng vẫn đem lại cảm giác thư giãn và làm diệu mắt khi sử dụng.",
                "#034c5f",
                "#97bec6",
                "#C8D8DB",
                "#f9c4ba",
                "#ee6457",
                "#00BFFF",
                "#FFFFFFFF"));
        themeList.add(new Theme(
                2,
                "Màu tươi sáng",
                "Với tệp màu này sẽ làm cho ứng dụng của bạn trở nên tươi sáng và năng động hơn. Thích hợp sử dụng vào ban ngày.",
                "#6c7ee1",
                "#97bec6",
                "#C8D8DB",
                "#f9c4ba",
                "#c688eb",
                "#FFFFFFFF",
                "#00BFFF"));
        themeList.add(new Theme(
                3,
                "Màu ấm áp",
                "Với tệp màu này làm cho ứng dụng của bạn trở nên hòa hợp và đem lại cảm giác ấm áp.",
                "#f28076",
                "#ffb6af",
                "#F4CCC8",
                "#fbc193",
                "#4eb09b",
                "#FFFFFFFF",
                "#00BFFF"));
        themeList.add(new Theme(
                4,
                "Màu lạnh",
                "Sẽ làm cho ứng dụng trở nên nhẹ nhàng và đem lại cảm giác thư giãn cho mắt khi sử dụng.",
                "#5d7b6f",
                "#a4c3a2",
                "#CEE7CD",
                "#eae7d6",
                "#d7f9fa",
                "#FFFFFFFF",
                "#00BFFF"));
        themeList.add(new Theme(
                5,
                "Màu ngẫu hứng",
                "Với tệp màu này sẽ làm cho ứng dụng trở nên mới lạ và đem lại cảm giác khác biệt khi sử dụng.",
                "#bd637e",
                "#e2b4b7",
                "#F2DEDF",
                "#a0c9c3",
                "#657d81",
                "#FFFFFFFF",
                "#00BFFF"));
        int theme = 1;
        try{
            theme = SharedPrefs.getInstance().get("Theme",int.class,1);
            List<Theme> temp = new ArrayList<>();
            for(int i = 0; i < themeList.size(); i++){
                Theme theme1 = themeList.get(i);
                if(theme == themeList.get(i).ID){
                    theme1.setTextColor("#FFFFFFFF");
                    theme1.setTrangThaiColor("#00BFFF");
                    temp.add(theme1);
                }
                else {
                    theme1.setTextColor("#00BFFF");
                    theme1.setTrangThaiColor("#FFFFFFFF");
                    temp.add(theme1);
                }
            }
            mutableLiveData.setValue(temp);
        }catch (Exception ex){
            mutableLiveData.setValue(themeList);
        }
    }
    public MutableLiveData<List<Theme>> getMutableLiveData() {
        return mutableLiveData;
    }

}
