package vn.nhattamsoft.project_mau.model;

import com.google.gson.Gson;

public class UserLogin {
    private String UserName;
    private String Password;


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public UserLogin(String userName, String password) {
        UserName = userName;
        Password = password;
    }
    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
