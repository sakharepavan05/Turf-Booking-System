package com.Turf_bin;

public class Booking_bo {
  private String name;
  private String Time;
  private String Date;
public Booking_bo() {
	super();
	// TODO Auto-generated constructor stub
}
public Booking_bo(String name, String time, String date) {
	super();
	this.name = name;
	Time = time;
	Date = date;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTime() {
	return Time;
}
public void setTime(String time) {
	Time = time;
}
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}
}
