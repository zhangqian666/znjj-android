package zack.com.znjj.app.config.applyOptions.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import zack.com.znjj.app.GlobalConfiguration;

/**
 * Created by Administrator on 2018/2/2.
 */

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .addHeader("token", GlobalConfiguration.HEADER_TOKEN)
                .build();
        return chain.proceed(request);
    }
}
