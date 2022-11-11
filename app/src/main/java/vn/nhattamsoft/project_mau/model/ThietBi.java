package vn.nhattamsoft.project_mau.model;

public class ThietBi {
    public String ThietBiID ;
    public String ThietBiCode ;
    public String TenThietBi ;
    public String HangSX ;
    public String Platform;
    public String Version;

    public ThietBi(String thietBiID, String thietBiCode, String tenThietBi, String hangSX, String platform, String version, String loaiTB, String ngungSD) {
        ThietBiID = thietBiID;
        ThietBiCode = thietBiCode;
        TenThietBi = tenThietBi;
        HangSX = hangSX;
        Platform = platform;
        Version = version;
        this.loaiTB = loaiTB;
        NgungSD = ngungSD;
    }

    public String loaiTB;
    public String NgungSD;

    public String getThietBiID() {
        return ThietBiID;
    }

    public void setThietBiID(String thietBiID) {
        ThietBiID = thietBiID;
    }

    public String getThietBiCode() {
        return ThietBiCode;
    }

    public void setThietBiCode(String thietBiCode) {
        ThietBiCode = thietBiCode;
    }

    public String getTenThietBi() {
        return TenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        TenThietBi = tenThietBi;
    }

    public String getHangSX() {
        return HangSX;
    }

    public void setHangSX(String hangSX) {
        HangSX = hangSX;
    }

    public String getPlatform() {
        return Platform;
    }

    public void setPlatform(String platform) {
        Platform = platform;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getLoaiTB() {
        return loaiTB;
    }

    public void setLoaiTB(String loaiTB) {
        this.loaiTB = loaiTB;
    }

    public String getNgungSD() {
        return NgungSD;
    }

    public void setNgungSD(String ngungSD) {
        NgungSD = ngungSD;
    }
}
