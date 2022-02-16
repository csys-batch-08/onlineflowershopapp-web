package com.onlineflowershop.model;

import java.util.Objects;

public class Admin {

	private String adminUser;
	private String adminEmailId;
	private String adminPassword;
	
	
	public Admin() {
		super();
		
	}
	@Override
	public String toString() {
		return "Admin [adminUser=" + adminUser + ", adminEmailId=" + adminEmailId + ", adminPassword=" + adminPassword
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(adminEmailId, adminPassword, adminUser);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(adminEmailId, other.adminEmailId) && Objects.equals(adminPassword, other.adminPassword)
				&& Objects.equals(adminUser, other.adminUser);
	}
	public Admin(String adminUser, String adminEmailId, String adminPassword) {
		super();
		this.adminUser = adminUser;
		this.adminEmailId = adminEmailId;
		this.adminPassword = adminPassword;
	}
	public String getAdminUser() {
		return adminUser;
	}
	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}
	public String getAdminEmailId() {
		return adminEmailId;
	}
	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	
}
