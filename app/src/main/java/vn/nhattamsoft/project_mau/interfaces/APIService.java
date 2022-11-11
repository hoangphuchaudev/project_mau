package vn.nhattamsoft.project_mau.interfaces;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import vn.nhattamsoft.project_mau.SharedPreferences.SharedPrefs;
import vn.nhattamsoft.project_mau.model.API.API_Data;
import vn.nhattamsoft.project_mau.model.API.API_Exec;
import vn.nhattamsoft.project_mau.model.API.API_Login;
import vn.nhattamsoft.project_mau.model.Json;

public interface APIService {
    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    Interceptor interceptor = chain -> {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        builder.addHeader("Authorization", SharedPrefs.getInstance().get("Token", String.class));
        return chain.proceed(builder.build());
    };
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    OkHttpClient.Builder okBuilder = new OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30,TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(loggingInterceptor)
            .retryOnConnectionFailure(true)
            ;

    APIService apiservice = new Retrofit.Builder()
            .baseUrl("http://api.nhattamsoft.vn/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okBuilder.build())
            .build()
            .create(APIService.class);

    @POST("login")
    Observable<Json> loginAPI(@Body API_Login json);
    @GET("csdl")
    Observable<Json> getDatabase();
    @POST("api")
//    @Headers("Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6ImFkbWluIiwibmFtZWlkIjoiYWRtaW4iLCJyb2xlIjoiYWRtaW4iLCJuYmYiOjE2NjY4ODAyODcsImV4cCI6MTY3NDgyOTA4NywiaWF0IjoxNjY2ODgwMjg3fQ.RwrM22ILCw-W4iMQ0-XFfQ5YX3dDLTdbhruaxG2Ufxc")
    Observable<JsonObject> api(@Query("proc") String Proc, @Body API_Data[] json);

    @POST("exec")
//    @Headers("Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6ImFkbWluIiwibmFtZWlkIjoiYWRtaW4iLCJyb2xlIjoiYWRtaW4iLCJuYmYiOjE2NjY4ODAyODcsImV4cCI6MTY3NDgyOTA4NywiaWF0IjoxNjY2ODgwMjg3fQ.RwrM22ILCw-W4iMQ0-XFfQ5YX3dDLTdbhruaxG2Ufxc")
    Observable<Json> exec(@Body API_Exec data);

//    @GET
//    Call<List<ItemDemo>> getListDemo(@Url String url);
//
//    @GET("books")
//    Call<List<ItemDemo>> getListBook();
//
//    @GET("nhanvien")
//    Observable<JsonObject> getListNhanVien();
//
//    @POST("nhanvien")
//    Observable<ItemDemo> themNhanVien(@Body ItemDemo itemDemo);
//
//    @GET("books/{id}")
//    Call<ItemDemo> getListBookCT(@Path("id") int id);
//
//    @GET("users/{login}")
//    Call<ItemDemo> getListInfo(@Path("login") String login);
//
//    @GET("POST")
//    Call<List<ItemDemo>> getListCocktail();
//
//    @POST("POST/orders")
//    Call<ItemDemo> createPost(@Body ItemDemo itemDemo);
//
//    @PUT("nhanvien/{id}")
//    Observable<ItemDemo> suaNhanVien(@Path("id") String id, @Body ItemDemo itemDemo);
//
//    @DELETE("nhanvien/{id}")
//    Observable<ItemDemo> xoaNhanVien(@Path("id") String id);

}

