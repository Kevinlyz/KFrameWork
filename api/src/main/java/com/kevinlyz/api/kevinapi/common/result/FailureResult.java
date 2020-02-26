package com.kevinlyz.api.kevinapi.common.result;


/**
 * @author pasta
 * @date 2017/12/31
 */
public class FailureResult<T> extends AbstractResult<T> {

    private static final long serialVersionUID = -3093625159110857560L;

    public FailureResult() {
        super();
    }

    public FailureResult(Error error) {
        super(error);
    }

    public FailureResult(T data, Error error) {
        super(data, error);
    }

    @Override
    public boolean isSuccess() {
        return false;
    }
}
