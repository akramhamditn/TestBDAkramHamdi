package com.akram.testbdakramhamdi.data.backend;



import com.akram.testbdakramhamdi.data.model.GitHubRepositorie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubClient {

    @GET("repositories/{params}")
    Call<GitHubRepositorie> getFeed(@Path("params") String params);
}
