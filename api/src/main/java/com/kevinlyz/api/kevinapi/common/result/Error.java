package com.kevinlyz.api.kevinapi.common.result;

import java.io.Serializable;

/**
 * @author pasta
 * @date 2017/12/31
 */
public class Error implements Serializable {

    private static final long serialVersionUID = -3614257523303603512L;

    private int returnCode;

    private String returnMessage;

    private String returnUserMessage;

    public Error() {
    }

    public Error(int returnCode, String returnMessage) {
        this.returnCode = returnCode;
        this.returnMessage= returnMessage;
        this.returnUserMessage = returnMessage;
    }

    public Error(int returnCode, String returnMessage, String returnUserMessage) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
        this.returnUserMessage = returnUserMessage;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getReturnUserMessage() {
        return returnUserMessage;
    }

    public void setReturnUserMessage(String returnUserMessage) {
        this.returnUserMessage = returnUserMessage;
    }

    @Override
    public String toString() {
        return "Error{" +
                "returnCode=" + returnCode +
                ", returnMessage='" + returnMessage + '\'' +
                ", returnUserMessage='" + returnUserMessage + '\'' +
                '}';
    }
}
