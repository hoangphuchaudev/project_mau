package vn.nhattamsoft.project_mau.model.Item;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.FrameLayout;

import androidx.databinding.BindingAdapter;

import com.google.android.material.button.MaterialButton;

public class ItemTheme {
    public int ID ;
    public String TieuDe;
    public String NoiDung;
    public String ColorPrimary;
    public String ColorAccent;
    public String ColorLight;
    public String ColorText;
    public String ColorDark;
    public String TrangThaiColor;
    public String TextColor;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String tieuDe) {
        TieuDe = tieuDe;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getColorPrimary() {
        return ColorPrimary;
    }

    public void setColorPrimary(String colorPrimary) {
        ColorPrimary = colorPrimary;
    }

    public String getColorAccent() {
        return ColorAccent;
    }

    public void setColorAccent(String colorAccent) {
        ColorAccent = colorAccent;
    }

    public String getColorLight() {
        return ColorLight;
    }

    public void setColorLight(String colorLight) {
        ColorLight = colorLight;
    }

    public String getColorText() {
        return ColorText;
    }

    public void setColorText(String colorText) {
        ColorText = colorText;
    }

    public String getColorDark() {
        return ColorDark;
    }

    public void setColorDark(String colorDark) {
        ColorDark = colorDark;
    }

    public String getTrangThaiColor() {
        return TrangThaiColor;
    }

    public void setTrangThaiColor(String trangThaiColor) {
        TrangThaiColor = trangThaiColor;
    }

    public String getTextColor() {
        return TextColor;
    }

    public void setTextColor(String textColor) {
        TextColor = textColor;
    }

    public ItemTheme(int ID, String tieuDe, String noiDung, String colorPrimary, String colorAccent, String colorLight, String colorText, String colorDark, String trangThaiColor, String textColor) {
        this.ID = ID;
        TieuDe = tieuDe;
        NoiDung = noiDung;
        ColorPrimary = colorPrimary;
        ColorAccent = colorAccent;
        ColorLight = colorLight;
        ColorText = colorText;
        ColorDark = colorDark;
        TrangThaiColor = trangThaiColor;
        TextColor = textColor;
    }

    @BindingAdapter({"bind:color_primary"})
    public static void setColor(FrameLayout frameLayout, String item) {
        frameLayout.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(item)));
    }
    @BindingAdapter({"bind:color_button"})
    public static void setColorButton(MaterialButton button, ItemTheme item) {
        button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(item.TrangThaiColor)));
        button.setTextColor(ColorStateList.valueOf(Color.parseColor(item.TextColor)));
        button.setStrokeColor(ColorStateList.valueOf(Color.parseColor(item.TextColor)));
    }
}
