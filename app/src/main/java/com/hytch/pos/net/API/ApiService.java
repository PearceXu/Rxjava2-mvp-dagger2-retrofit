package com.hytch.pos.net.API;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    interface MainService{
        @GET("/open/api/weather/json.shtml")
        Observable<String> getInfo(@Query("city") String city);
    }
    interface LoginService{
        @GET("/open/api/weather/json.shtml")
        Observable<String> login(@Query("city") String city);
    }
}


