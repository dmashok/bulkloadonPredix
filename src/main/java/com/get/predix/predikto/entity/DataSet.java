package com.get.predix.predikto.entity;

import java.util.Date;

public class DataSet {
	
	   private Date train_date ;
	   private int site_id ;
	   private String direction ;
	   private String car_id ;
	   private int axle_no ;
	   private String car_side ;
	   private float avg_vert ;
	   private float max_vert ;
	   private float dyn_vert ;
	   private float dyn_ratio ;
	   private float avg_lat ;
	   private float max_lat ;
	   private String  wheel_id ;
	   private float car_wgt_calc ;
	   private float pct_load ;
	   private int train_speed ;
	   
	public Date getTrain_date() {
		return train_date;
	}
	public void setTrain_date(Date train_date) {
		this.train_date = train_date;
	}
	public int getSite_id() {
		return site_id;
	}
	public void setSite_id(int site_id) {
		this.site_id = site_id;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}
	public int getAxle_no() {
		return axle_no;
	}
	public void setAxle_no(int axle_no) {
		this.axle_no = axle_no;
	}
	public String getCar_side() {
		return car_side;
	}
	public void setCar_side(String car_side) {
		this.car_side = car_side;
	}
	public float getAvg_vert() {
		return avg_vert;
	}
	public void setAvg_vert(float avg_vert) {
		this.avg_vert = avg_vert;
	}
	public float getMax_vert() {
		return max_vert;
	}
	public void setMax_vert(float max_vert) {
		this.max_vert = max_vert;
	}
	public float getDyn_vert() {
		return dyn_vert;
	}
	public void setDyn_vert(float dyn_vert) {
		this.dyn_vert = dyn_vert;
	}
	public float getDyn_ratio() {
		return dyn_ratio;
	}
	public void setDyn_ratio(float dyn_ratio) {
		this.dyn_ratio = dyn_ratio;
	}
	public float getAvg_lat() {
		return avg_lat;
	}
	public void setAvg_lat(float avg_lat) {
		this.avg_lat = avg_lat;
	}
	public float getMax_lat() {
		return max_lat;
	}
	public void setMax_lat(float max_lat) {
		this.max_lat = max_lat;
	}
	public String getWheel_id() {
		return wheel_id;
	}
	public void setWheel_id(String wheel_id) {
		this.wheel_id = wheel_id;
	}
	public float getCar_wgt_calc() {
		return car_wgt_calc;
	}
	public void setCar_wgt_calc(float car_wgt_calc) {
		this.car_wgt_calc = car_wgt_calc;
	}
	public float getPct_load() {
		return pct_load;
	}
	public void setPct_load(float pct_load) {
		this.pct_load = pct_load;
	}
	public int getTrain_speed() {
		return train_speed;
	}
	public void setTrain_speed(int train_speed) {
		this.train_speed = train_speed;
	}
	
	@Override
	public String toString() {
		return train_date + ", " + site_id + ", " + direction + ", " + car_id + ", " + axle_no + ", " + car_side + ", "
				+ avg_vert + ", " + max_vert + ", " + dyn_vert + ", " + dyn_ratio + ", " + avg_lat + ", " + max_lat
				+ ", " + wheel_id + ", " + car_wgt_calc + ", " + pct_load + ", " + train_speed + "]";
	}

}
