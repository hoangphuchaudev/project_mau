package vn.nhattamsoft.project_mau.model.API;

public class API_Exec {
    public String sql;
    public API_Data[] data;
    public API_Exec(String sql, API_Data[] data){
        this.sql = sql;
        this.data = data;
    }
}
