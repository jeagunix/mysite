package kr.co.itcen.mysite.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
//* *..repository.*.*(..) || * *..service.*.*(..)) || 
public class MeasureExecutionTimeAspect {
	@Around("execution(* *..repository.*.*(..))||execution(* *..controller.*.*(..))||execution(* *..service.*.*(..))")
	public Object aroundAspect(ProceedingJoinPoint pjp) throws Throwable {
		//before
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object result = pjp.proceed();
		
		//after
		sw.stop();
		Long totalTime = sw.getTotalTimeMillis();
		
		// 어떤 클래스의 어떤메소드
		String className = pjp.getTarget().getClass().getName();
		String methodName = pjp.getSignature().getName();
		String taskName = className + "." + methodName;
		
		System.out.println("[Execution Time][" + taskName +"] : " + totalTime +" mills");
		return result;
	}
}
