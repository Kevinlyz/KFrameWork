package com.kevinlyz.api.kevinapi.common.result;

/**
 * @author pasta
 * @date 2017/12/31
 */
public class AbstractResult<T> implements Result<T> {

    private static final long serialVersionUID = 9026668448828755998L;

    private T data;

    private Error error;

    private Info info;

    public AbstractResult() {
        this.info = new Info();
    }

    public AbstractResult(Error error) {
        this.error = error;
        this.info  = new Info();
    }

    public AbstractResult(T data, Error error) {
        this.data  = data;
        this.error = error;
        this.info  = new Info();
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public T getData() {
        return this.data;
    }

    @Override
    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public Error getError() {
        return this.error;
    }

    @Override
    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public Info getInfo() {
        return this.info;
    }

    @Override
    public boolean isSuccess() {
        if (this.error.getReturnCode() == 0){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "AbstractResult{" +
                "data=" + data +
                ", error=" + error +
                ", info=" + info +
                '}';
    }
}
