package org.soneech.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AspectClass {
    @Around("allServiceMethods()")
    public Object logTime(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("Метод {} класса {} выполнен за {} мс",
                joinPoint.getSignature().getName(),
                joinPoint.getSourceLocation().getWithinType().getName(),
                end - start);
        return result;
    }

    @Pointcut("within(org.soneech.service.*)")
    public void allServiceMethods() { }
}
