package vn.nhattamsoft.project_mau.model.Item;

public class ItemMenuCaNhan {
    public static final int NONE = 0;
    public static final int TOP = 1;
    public static final int BOTTOM = 2;

    private String Ten = "", MiniTen = "", Loai = "";
    private int Img, BoTron;

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMiniTen() {
        return MiniTen;
    }

    public void setMiniTen(String miniTen) {
        MiniTen = miniTen;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String loai) {
        Loai = loai;
    }

    public int getBoTron() {
        return BoTron;
    }

    public void setBoTron(int boTron) {
        BoTron = boTron;
    }

    public ItemMenuCaNhan(String ten, String miniTen, int img, int boTron) {
        Ten = ten;
        MiniTen = miniTen;
        Img = img;
        BoTron = boTron;
    }
    public ItemMenuCaNhan(String loai) {
        Loai = loai;
    }
}
