package com.hive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biz.CarStatus;
import com.frame.Car;

@Controller
public class CarController {

	@Autowired
	Car<CarStatus> car;
	 
	@RequestMapping("/carstatus.mc")
	public void carstatus(CarStatus cstatus) {
		car.status(cstatus);
	}
}









