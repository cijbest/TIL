package com.msg;

import java.io.Serializable;

public class Msg implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ip;
	private String id;
	private String msg;
	public Msg() {
		
	}
	public Msg(String ip, String id, String msg) {
		super();
		this.ip = ip;
		this.id = id;
		this.msg = msg;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Msg [ip=" + ip + ", id=" + id + ", msg=" + msg + "]";
	}
	
	
}
