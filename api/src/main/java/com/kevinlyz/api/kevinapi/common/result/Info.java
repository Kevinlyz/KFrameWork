package com.kevinlyz.api.kevinapi.common.result;


import org.slf4j.MDC;

import java.io.Serializable;

/**
 * @author pasta
 * @date 2019-03-09
 */

public class Info implements Serializable {

    private static final long serialVersionUID = 4044261038184211926L;

    private String serverIp;

    private String traceId;

    public Info() {
//        this.serverIp = IpUtil.LOCAL_IP_ADDRESS;
//        this.traceId = MDC.get(Trace.TRACE_ID);
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    @Override
    public String toString() {
        return "Info{" +
                "serverIp='" + serverIp + '\'' +
                ", traceId='" + traceId + '\'' +
                '}';
    }

}
