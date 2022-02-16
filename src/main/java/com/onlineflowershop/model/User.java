package com.onlineflowershop.model;

import java.io.Serializable;

public class User implements Serializable {
	
	
		private int userId;
		private String name;
		private String emailId;
		private String password;
		private String address;
		private long mobileNumber;	
		private String role;
		private double wallet;
		
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public double getWallet() {
			return wallet;
		}
		public void setWallet(double wallet) {
			this.wallet = wallet;
		}
		public User() {
			super();
			
		}
		public User(String name, String emailId, String password, String address, long mobileNumber) {
			super();
			this.name = name;
			this.emailId = emailId;
			this.password = password;
			this.address = address;
			this.mobileNumber = mobileNumber;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public long getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		
	    @Override
		public String toString() {
			return "User [userId=" + userId + ", name=" + name + ", emailId=" + emailId + ", password=" + password
					+ ", address=" + address + ", mobileNumber=" + mobileNumber + ", role=" + role + ", wallet="
					+ wallet + "]";
		}
		public User(int userId, String name, String emailId, String password, String address, long mobileNumber,
				String role, double wallet) {
			super();
			this.userId = userId;
			this.name = name;
			this.emailId = emailId;
			this.password = password;
			this.address = address;
			this.mobileNumber = mobileNumber;
			this.role = role;
			this.wallet = wallet;
		}
		
		
		
		
		

}
