package com.kevinlyz.api.kevinapi.common.enums;


import lombok.ToString;

/**
 * @author kevinlyz
 * @date 2019-03-04
 */
@ToString
public enum EProtoType {

    HTTP("HTTP", "HTTTP 调用"),
    DUBBO("DUBBO", "DUBBO 调用"),
    TASK("TASK", "定时任务调用"),
    OTHER("OTHER", "其他调用"),
    ;

    public final String code;
    public final String des;

    EProtoType(String code, String des) {
        this.code = code;
        this.des = des;
    }

}
