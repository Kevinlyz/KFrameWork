package com.kevinlyz.provider.common.interceptor;

import com.kevinlyz.api.kevinapi.common.enums.EProtoType;
import com.kevinlyz.api.kevinapi.common.trace.Trace;
import com.kevinlyz.common.cache.ThreadCache;
import com.kevinlyz.common.util.DateUtil;
import com.kevinlyz.common.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kevinlzy
 * @date 2019-03-02
 */
@Slf4j
public class TraceInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        ThreadCache.setVal(Trace.START_TIMESTAMP, DateUtil.currTimestamp());

        MDC.put(Trace.TRACE_PROTO     , StringUtils.defaultString(EProtoType.HTTP.code, Trace.UNKNOWN));
        MDC.put(Trace.TRACE_URI       , StringUtils.defaultIfBlank(request.getRequestURI(), Trace.UNKNOWN));
        MDC.put(Trace.TRACE_ID        , StringUtils.defaultIfBlank(request.getHeader(Trace.TRACE_ID),
                IdUtil.getId()));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        log.info("processing completed cost time [{}ms]", DateUtil.currTimestamp() - (long) ThreadCache.getVal(Trace.START_TIMESTAMP));

        MDC.clear();
    }
}
