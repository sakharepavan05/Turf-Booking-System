package com.Turf_bin;
import java.util.*;
public class Turf_list_bo {
  private String name;
  private String Location;
  private String Description;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return Location;
}
public void setLocation(String location) {
	Location = location;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public Turf_list_bo(String name, String location, String description) {
	super();
	this.name = name;
	Location = location;
	Description = description;
}
public Turf_list_bo() {
	super();
}
  
}
