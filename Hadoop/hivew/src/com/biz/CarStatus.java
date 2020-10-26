package com.biz;

public class CarStatus {
	String id;
	double speed;
	double temp;
	double oiltemp;
	double rpm;
	public CarStatus() {
	}
	public CarStatus(String id, double speed, double temp, double oiltemp, double rpm) {
		this.id = id;
		this.speed = speed;
		this.temp = temp;
		this.oiltemp = oiltemp;
		this.rpm = rpm;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public double getOiltemp() {
		return oiltemp;
	}
	public void setOiltemp(double oiltemp) {
		this.oiltemp = oiltemp;
	}
	public double getRpm() {
		return rpm;
	}
	public void setRpm(double rpm) {
		this.rpm = rpm;
	}
	@Override
	public String toString() {
		return "CarStatus [id=" + id + ", speed=" + speed + ", temp=" + temp + ", oiltemp=" + oiltemp + ", rpm=" + rpm
				+ "]";
	}
	
	
}
