package example.com.news;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import example.com.news.api.ApiInterface;
import example.com.news.models.AuthRequest;
import example.com.news.models.AuthResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText email = findViewById(R.id.email);
        final EditText pass = findViewById(R.id.pass);
        final Button btnlgn = findViewById(R.id.btnlgn);
        final TextView textView = findViewById(R.id.textView);

        final ApiInterface api = new MockApi(); // TODO get api from retrofit

        btnlgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                api.login(new AuthRequest(email.getText().toString(), pass.getText().toString()))
                        .enqueue(new Callback<AuthResponse>() {
                            @Override
                            public void onResponse(@NonNull Call<AuthResponse> call,
                                                   @NonNull Response<AuthResponse> response) {
                                final App app = (App) getApplicationContext();

                                app.getSettings()
                                        .setAuthToken(response.body().getToken());

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        textView.setText(app.getSettings().getAuthToken());
                                    }
                                });
                            }

                            @Override
                            public void onFailure(@NonNull Call<AuthResponse> call,
                                                  @NonNull Throwable t) {
                                Toast.makeText(MainActivity.this,
                                        t.getMessage(),
                                        Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });

    }
}