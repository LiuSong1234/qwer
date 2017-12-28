package com.example.macbookpro.mvp.untils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Macbookpro on 2017/12/27.
 */

public interface ApiServier {
    @GET("index?type=top&key=097060266650f67b2cebd2a06aded587")
    public Call<ResponseBody> getData();
}
