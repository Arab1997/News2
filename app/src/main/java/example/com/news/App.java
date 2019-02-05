package example.com.news;

import android.app.Application;

public class App extends Application {

    private AppSettings settings;

    @Override
    public void onCreate() {
        super.onCreate();

        settings = AppSettings.getInstance(this);
    }

    public AppSettings getSettings() {
        return settings;
    }
}
