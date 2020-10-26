package com.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import com.biz.CarStatus;

@Service
@Aspect
public class Loggers {
	private Logger car_log = Logger.getLogger("car");
	private Logger work_log = Logger.getLogger("work");
	private Logger data_log = Logger.getLogger("data");

	// before
	@Before("execution(* com.biz.CarBiz.*(..))")
	public void logging3(JoinPoint jp) {
		Object[] args = jp.getArgs();
		CarStatus cstatus = (CarStatus) args[0];
		car_log.debug(jp.getSignature().getName() + "," + cstatus.getId() + "," + cstatus.getSpeed() + ","
				+ cstatus.getTemp() + "," + cstatus.getOiltemp() + "," + cstatus.getRpm());
	}


}
