package com.kevinlyz.provider.common.filter;

import com.alibaba.fastjson.JSON;
import com.kevinlyz.api.kevinapi.common.trace.Trace;
import com.kevinlyz.api.kevinapi.common.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.*;
import org.slf4j.MDC;

/**
 * @author: tangzh
 * @date: 2019/9/16$ 10:11 AM$
 * @version: 1.0
 **/
@Slf4j
@Activate
public class TraceFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result result = null;
        try {
            String interfaceName = invoker.getInterface().getName();
            String methodName = invocation.getMethodName();
            String reqUrl = invoker.getUrl().getIp() + ":" + invoker.getUrl().getPort() + "/" + interfaceName + methodName;
            String traceId = MDC.get(Trace.TRACE_ID);
            if (StringUtils.isBlank(traceId)) {
                traceId = RpcContext.getContext().getAttachment(Trace.TRACE_ID);
            }
            if (StringUtils.isBlank(traceId)) {
                traceId = IdUtil.getId();
            }
            MDC.put(Trace.TRACE_ID, traceId);
            long reqTime = System.currentTimeMillis();
            //获取请求参数
            Object[] ojs = invocation.getArguments();
            log.info("dubbo请求: traceId:[{}] reqUrl:[{}] 请求报文{}", traceId, reqUrl, JSON.toJSONString(ojs));
            //设置traceId
            RpcContext.getContext().setAttachment(Trace.TRACE_ID, traceId);
            result = invoker.invoke(invocation);
            log.info("dubbo返回: traceId:[{}] rspUrl:[{}] 返回报文{} 耗时{}", traceId, reqUrl, JSON.toJSONString(result.getValue()), System.currentTimeMillis() - reqTime);
        } catch (Exception e) {
            log.error("dubbo调用异常{}", e);
        } finally {
            MDC.clear();
        }
        return result;
    }
}
