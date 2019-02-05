package example.com.news;

import example.com.news.api.ApiInterface;
import example.com.news.models.AuthRequest;
import example.com.news.models.AuthResponse;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MockApi implements ApiInterface {

    @Override
    public Call<AuthResponse> login(final AuthRequest request) {
        return new Call<AuthResponse>() {

            @Override
            public Response<AuthResponse> execute() throws IOException {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("test@example.com".equals(request.getEmail())
                        && "password".equals(request.getPassword())) {
                    return Response.success(new AuthResponse("sample_token"));
                }
                return Response.error(401, ResponseBody.create(MediaType.parse("application/json"), "{}"));
            }

            @Override
            public void enqueue(Callback<AuthResponse> callback) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("test@example.com".equals(request.getEmail())
                        && "password".equals(request.getPassword())) {
                    callback.onResponse(this, Response.success(new AuthResponse("sample_auth_token")));
                } else {
                    callback.onFailure(this, new RuntimeException("Incorrect credentials"));
                }
            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<AuthResponse> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };
    }
}
