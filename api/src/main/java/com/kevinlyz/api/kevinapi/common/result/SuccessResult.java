package com.kevinlyz.api.kevinapi.common.result;


/**
 * @author pasta
 * @date 2017/12/31
 */
public class SuccessResult<T> extends AbstractResult<T> {

    private static final long serialVersionUID = -6002069549567379565L;

    public SuccessResult() {
        super();
    }

    public SuccessResult(Error error) {
        super(error);
    }

    public SuccessResult(T data, Error error) {
        super(data, error);
    }

    @Override
    public boolean isSuccess() {
        return true;
    }


}
