
package az.developia.spring_project_14Aprel.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogDemo {

    private final Logger log = LoggerFactory.getLogger(LogDemo.class);

    public void test() {
        log.warn("Log for alert messages");
        log.error("Logging for critical messages");
    }

    @Before("execution(* az.developia.spring_project_14Aprel.controller.UserController.*(..))")
    public void addBefore(JoinPoint joinPoint) {
        log.info("Method started: {}", joinPoint.getSignature().getName());
    }

    @After("execution(* az.developia.spring_project_14Aprel.controller.UserController.*(..))")
    public void addAfter(JoinPoint joinPoint) {
        log.info("Method finished: {}", joinPoint.getSignature().getName());
    }
}
