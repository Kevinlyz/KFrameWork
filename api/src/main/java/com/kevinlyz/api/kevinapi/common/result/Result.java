package com.kevinlyz.api.kevinapi.common.result;

import java.io.Serializable;

/**
 * @author pasta
 * @date 2017/12/31
 */

public interface Result<T> extends Serializable {

    void setData(T data);

    T getData();

    void setError(Error error);

    Error getError();

    void setInfo(Info info);

    Info getInfo();

    boolean isSuccess();

}
