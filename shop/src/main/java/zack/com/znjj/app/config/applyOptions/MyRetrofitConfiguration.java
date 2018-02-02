package zack.com.znjj.app.config.applyOptions;

import android.content.Context;

import com.jess.arms.di.module.ClientModule;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import zack.com.znjj.BuildConfig;
import zack.com.znjj.app.config.applyOptions.interceptor.HeaderInterceptor;


public class MyRetrofitConfiguration implements ClientModule.RetrofitConfiguration {
    @Override
    public void configRetrofit(Context context, Retrofit.Builder builder) {
        // 配置多BaseUrl支持
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            clientBuilder.addInterceptor(interceptor);//使用自定义的Log拦截器
        }
        clientBuilder.addInterceptor(new HeaderInterceptor());//使用自定义User-Agent.
        builder.client(clientBuilder.build());
    }
}
