package vn.nhattamsoft.project_mau.SharedPreferences;

import android.app.Application;
import com.google.gson.Gson;
public class App extends Application {

    private static App mSelf;
    private Gson mGSon;

    public static App self() {
        return mSelf;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSelf = this;
        mGSon = new Gson();
//        int theme = getThemeFromPreferences();
//        setTheme(theme);
    }

    public Gson getGSon() {
        return mGSon;
    }
}