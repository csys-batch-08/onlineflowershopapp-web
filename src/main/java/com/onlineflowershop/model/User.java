package com.onlineflowershop.model;

import java.util.Objects;

public class User {
	
	
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
			// TODO Auto-generated constructor stub
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
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((address == null) ? 0 : address.hashCode());
			result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
			result = prime * result + (int) (mobileNumber ^ (mobileNumber >>> 32));
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((role == null) ? 0 : role.hashCode());
			result = prime * result + userId;
			long temp;
			temp = Double.doubleToLongBits(wallet);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if (address == null) {
				if (other.address != null)
					return false;
			} else if (!address.equals(other.address))
				return false;
			if (emailId == null) {
				if (other.emailId != null)
					return false;
			} else if (!emailId.equals(other.emailId))
				return false;
			if (mobileNumber != other.mobileNumber)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (role == null) {
				if (other.role != null)
					return false;
			} else if (!role.equals(other.role))
				return false;
			if (userId != other.userId)
				return false;
			if (Double.doubleToLongBits(wallet) != Double.doubleToLongBits(other.wallet))
				return false;
			return true;
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
