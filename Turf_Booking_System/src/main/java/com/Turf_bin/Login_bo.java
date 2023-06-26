package com.Turf_bin;
import java.util.*;
public class Login_bo {
	private String Id;
	private String password;
	private String Email;
	private String address;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Login_bo(String id, String password, String email, String address) {
		super();
		Id = id;
		this.password = password;
		Email = email;
		this.address = address;
	}
	public Login_bo() {
		super();
		
	}
	
	
}
