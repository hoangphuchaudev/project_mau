package vn.nhattamsoft.project_mau.model;
public class User {
    private String Token;
    private String UserID;
    private String TenDangNhap;
    private String UserGroupCode;
    private String Email;
    private String UserGroupID;
    private String DonViID;
    private String PhongBanID;
    private String NhanVienID;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        TenDangNhap = tenDangNhap;
    }

    public String getUserGroupCode() {
        return UserGroupCode;
    }

    public void setUserGroupCode(String userGroupCode) {
        UserGroupCode = userGroupCode;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUserGroupID() {
        return UserGroupID;
    }

    public void setUserGroupID(String userGroupID) {
        UserGroupID = userGroupID;
    }

    public String getDonViID() {
        return DonViID;
    }

    public void setDonViID(String donViID) {
        DonViID = donViID;
    }

    public String getPhongBanID() {
        return PhongBanID;
    }

    public void setPhongBanID(String phongBanID) {
        PhongBanID = phongBanID;
    }

    public String getNhanVienID() {
        return NhanVienID;
    }

    public void setNhanVienID(String nhanVienID) {
        NhanVienID = nhanVienID;
    }

    public User(String token, String userID, String tenDangNhap, String userGroupCode, String email, String userGroupID, String donViID, String phongBanID, String nhanVienID) {
        Token = token;
        UserID = userID;
        TenDangNhap = tenDangNhap;
        UserGroupCode = userGroupCode;
        Email = email;
        UserGroupID = userGroupID;
        DonViID = donViID;
        PhongBanID = phongBanID;
        NhanVienID = nhanVienID;
    }
}
