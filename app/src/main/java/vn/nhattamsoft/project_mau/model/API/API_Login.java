package vn.nhattamsoft.project_mau.model.API;

public class API_Login {
    public String Username;
    public String Password;
    public String Database;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public API_Login(String username, String password, String database) {
        Username = username;
        Password = password;
        Database = database;
    }
}
