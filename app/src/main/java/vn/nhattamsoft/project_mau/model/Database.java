package vn.nhattamsoft.project_mau.model;

import com.google.gson.Gson;

public class Database {
    private String ID, TenApp, TenSite,SiteURL;

    public Database(String ID, String tenApp, String tenSite, String siteURL) {
        this.ID = ID;
        TenApp = tenApp;
        TenSite = tenSite;
        SiteURL = siteURL;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenApp() {
        return TenApp;
    }

    public void setTenApp(String tenApp) {
        TenApp = tenApp;
    }

    public String getTenSite() {
        return TenSite;
    }

    public void setTenSite(String tenSite) {
        TenSite = tenSite;
    }

    public String getSiteURL() {
        return SiteURL;
    }

    public void setSiteURL(String siteURL) {
        SiteURL = siteURL;
    }
    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
