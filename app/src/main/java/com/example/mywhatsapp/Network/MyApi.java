package com.example.mywhatsapp.Network;

import com.example.mywhatsapp.Model.ModelItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {
    @GET("todos")
    Call<List<ModelItem>> getModels();

}
