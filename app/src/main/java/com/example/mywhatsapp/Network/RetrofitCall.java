package com.example.mywhatsapp.Network;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.mywhatsapp.Model.ModelItem;
import com.example.mywhatsapp.fragments.Chats;

import java.security.cert.CertificateException;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.internal.EverythingIsNonNull;

public class RetrofitCall {


        public static void getDataFromApi(){
            String URL="https://jsonplaceholder.typicode.com/";
            Log.d("inside getdatafromApis","getdatafromapi() invoked");

            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getUnsafeOkHttpClient().build())
                    .build();
            MyApi myApi = retrofit.create(MyApi.class);
            Call<List<ModelItem>> call = myApi.getModels();

            call.enqueue(new Callback<List<ModelItem>>() {

                @Override
                @EverythingIsNonNull
                public void onResponse(Call<List<ModelItem>> call, Response<List<ModelItem>> response) {
                    Log.d("void onresponse","call enquque() invoked");
                    if (response.code() != 200) {
                        String t = "Check connection";
                        Log.d("inside response code","response.code| invoked");
                        Chats.list.add(new ModelItem(0,0,t,false));
                        return;
                    }

                    List<ModelItem> data = response.body();
                    for (int i = 0; i < 20; i++) {
                        Log.d("inside loop","loop invoked");

                        Chats.list.add(new ModelItem(12,12,"wrer",false));
                        Chats.list.add(new ModelItem(data.get(i).getUserId(), data.get(i).getId(),
                                data.get(i).getTitle(), data.get(i).isCompleted()));
                                }
                }

                @Override
                @EverythingIsNonNull
                public void onFailure(Call<List<ModelItem>> call, Throwable t) {
                        Chats.list.add(new ModelItem(0,0,"failed",false));
                    Log.d("inside on failure","onfailure invoked");
                }
            });
        }














    public static OkHttpClient.Builder getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @SuppressLint("TrustAllX509TrustManager")
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @SuppressLint("TrustAllX509TrustManager")
                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier((hostname, session) -> true);
            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

