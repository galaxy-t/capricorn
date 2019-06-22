package com.galaxyt.capricorn.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodTimeAspect {


    private Logger logger = LoggerFactory.getLogger(MethodTimeAspect.class);

    /**
     * AOP事物环绕通知
     * 用来记录全部API接口的执行时间
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.galaxyt.capricorn.aop.web.*Controller.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable e) {
            logger.error("", e);
            throw new Throwable(e.getMessage());
        }
        long time = System.currentTimeMillis() - start;
        Class<?> clazz = point.getTarget().getClass();
        String methodName = MethodSignature.class.cast(point.getSignature()).getMethod().getName();
        logger.info("REST API Method:" + clazz.getSimpleName() + "." + methodName + ",Time:" + time + "ms");
        return result;
    }


}
