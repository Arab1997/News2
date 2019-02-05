package example.com.news.api;

import example.com.news.models.AuthRequest;
import example.com.news.models.AuthResponse;
import retrofit2.Call;

/*import retrofit2.Call;*/

public interface ApiInterface {

/*    @POST("auth")


    @GET("auth")
    Call<Coin> getNews(


            @Query("country")String country ,
            @Query("apiKey")String apiKey
    );*/

//    @Headers({
//            "Authorization", "Bearer "+ "OkM_9V_ilZ4Phaqwcjv2rs25HsOt7Qco"
//    })

    /*@GET("api/Profiles/GetProfile?id={id}")
    Call<UserProfile> getUser(@Path("id") String id);*/

//    @GET("coin")
//    Call<Coin> getCoin(
//            @Query("q") String keyword,
//            @Query("language") String language,
//            @Query("sortBy") String sortBy,
//            @Query("apiKey") String apiKey
//    );
//
//    Call<Coin> getCoin(String language, String token);

    Call<AuthResponse> login(AuthRequest request);
}
