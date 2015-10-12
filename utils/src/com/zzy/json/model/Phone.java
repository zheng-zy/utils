package com.zzy.json.model;
/**
 * Phone.java 说明
 * @author zhengzy
 * @date   2015年9月25日
 */
public class Phone {
	private String cityCode;
	private String number;
	
	
	public Phone() {
	}
	public Phone(String cityCode, String number) {
		this.cityCode = cityCode;
		this.number = number;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
