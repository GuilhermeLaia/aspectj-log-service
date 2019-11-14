package com.aspectj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j(topic = "service.monitor")
public class ExecutionAspect {
    
    
    @EventListener
    public void started(ContextRefreshedEvent event) {
        log.trace("Aspect...: " + event);
    }

    @Around("execution(* *(..)) && !within(com.aspectj.aspect.ExecutionAspect)"
            + " && (within(com.aspectj..*))")
    public Object aspect(ProceedingJoinPoint pjp) throws Throwable {
        log.trace(getOperation(pjp));
        return pjp.proceed();
    }

    private static final String getOperation(ProceedingJoinPoint pjp) {
        return String.format("%s#%s", pjp.getSignature().getDeclaringType().getCanonicalName(), pjp.getSignature().getName());
    }

}
