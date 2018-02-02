package zack.com.znjj.mvp.model.entity.base;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/31.
 */

public class BaseResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.status == 0;
    }
}
