package vn.nhattamsoft.project_mau.model;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;

public class Json {
    @SerializedName("success")
    public boolean success = false;
    @SerializedName("message")
    public String message;
    @SerializedName("data")
    public String data;
    public Json(){}

    public Json(boolean success, String message, String data){
        this.success = success;
        this.message = message;
        this.data = data;
    }
    public JsonArray getData(){
        try{
            JsonArray json = (JsonArray) JsonParser.parseString(this.data);
            return json;
        }catch (Exception exception){
            exception.printStackTrace();
            return null;
        }

    }

    public  String getMessage(){
        return TextUtils.isEmpty(this.message) ? "" : this.message;
    }
    public  boolean isSuccess(){ return (this.success);}
    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    @NonNull
    @Override
    public String toString() {
        return toJson();
    }
}
