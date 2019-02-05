package example.com.news;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSettings {

    public static final String AUTH_TOKEN = "auth_token";

    private static AppSettings instance;

    public static AppSettings getInstance(Context context) {
        if (instance == null) {
            instance = new AppSettings(context);
        }
        return instance;
    }

    private SharedPreferences prefs;

    private AppSettings(Context context) {
        this.prefs = context.getApplicationContext()
                .getSharedPreferences(getClass().getName(), Context.MODE_PRIVATE);
    }

    public String getAuthToken() {
        return prefs.getString(AUTH_TOKEN, null);
    }

    public void setAuthToken(String authToken) {
        prefs.edit()
                .putString(AUTH_TOKEN, authToken)
                .apply();
    }
}
