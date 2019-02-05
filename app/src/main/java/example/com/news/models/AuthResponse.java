package example.com.news.models;

import android.os.Parcel;
import android.os.Parcelable;

public class AuthResponse implements Parcelable {

    private String token;

    public AuthResponse() {
    }

    public AuthResponse(String token) {
        this.token = token;
    }

    protected AuthResponse(Parcel in) {
        token = in.readString();
    }

    public static final Creator<AuthResponse> CREATOR = new Creator<AuthResponse>() {
        @Override
        public AuthResponse createFromParcel(Parcel in) {
            return new AuthResponse(in);
        }

        @Override
        public AuthResponse[] newArray(int size) {
            return new AuthResponse[size];
        }
    };

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(token);
    }
}
