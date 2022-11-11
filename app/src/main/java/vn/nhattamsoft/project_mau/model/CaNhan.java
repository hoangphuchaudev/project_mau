package vn.nhattamsoft.project_mau.model;

public class CaNhan {
    private String HinhDaiDien;
    private String DiaChi;
    private String TenTaiKhoan;
    private String GioiTinh;
    private String DiDong;
    private String Email;
    private String NgaySinh;
    private  String MaDonVi;
    private  String TenDonVi;
    public String getHinhDaiDien() {
        return HinhDaiDien;
    }

    public void setHinhDaiDien(String hinhDaiDien) {
        HinhDaiDien = hinhDaiDien;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        TenTaiKhoan = tenTaiKhoan;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getDiDong() {
        return DiDong;
    }

    public void setDiDong(String diDong) {
        DiDong = diDong;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getMaDonVi() {
        return MaDonVi;
    }
    public void setMaDonVi(String maDonVi) {
        MaDonVi = maDonVi;
    }
    public String getTenDonVi() {
        return TenDonVi;
    }
    public void setTenDonVi(String tenDonVi) {
        TenDonVi = tenDonVi;
    }
    public CaNhan(String hinhDaiDien, String diaChi, String tenTaiKhoan, String gioiTinh, String diDong, String email, String ngaySinh, String maDonVi, String tenDonVi) {
        HinhDaiDien = hinhDaiDien;
        DiaChi = diaChi;
        TenTaiKhoan = tenTaiKhoan;
        GioiTinh = gioiTinh;
        DiDong = diDong;
        Email = email;
        NgaySinh = ngaySinh;
        MaDonVi = maDonVi;
        TenDonVi = tenDonVi;
    }

}