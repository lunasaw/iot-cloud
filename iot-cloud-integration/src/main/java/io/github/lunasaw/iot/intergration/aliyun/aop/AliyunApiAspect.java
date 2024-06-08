package io.github.lunasaw.iot.intergration.aliyun.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson2.JSON;
import com.aliyun.tea.TeaException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author weidian
 */
@Slf4j
@Aspect
@Component
public class AliyunApiAspect {

    @Around("execution(public * io.github.lunasaw.iot.intergration.aliyun.api..*.*(..)) && target(io.github.lunasaw.iot.intergration.aliyun.api.AliyunApi)")
    public Object aroundAliyunApiMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        try {
            return joinPoint.proceed();
        } catch (TeaException e) {
            log.error("teaException aroundAliyunApiMethods::joinPoint = {} ", JSON.toJSONString(args), e);
            throw e;
        } catch (Exception e) {
            log.error("aroundAliyunApiMethods::joinPoint = {} ", JSON.toJSONString(args), e);
            throw e;
        }
    }
}
