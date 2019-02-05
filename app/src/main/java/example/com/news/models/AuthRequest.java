package example.com.news.models;

import android.os.Parcel;
import android.os.Parcelable;

public class AuthRequest implements Parcelable {

    private String email;
    private String password;

    public AuthRequest() {
    }

    public AuthRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    protected AuthRequest(Parcel in) {
        email = in.readString();
        password = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(password);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AuthRequest> CREATOR = new Creator<AuthRequest>() {
        @Override
        public AuthRequest createFromParcel(Parcel in) {
            return new AuthRequest(in);
        }

        @Override
        public AuthRequest[] newArray(int size) {
            return new AuthRequest[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
