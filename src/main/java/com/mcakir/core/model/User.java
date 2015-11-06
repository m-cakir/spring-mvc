package com.mcakir.core.model;

import com.mcakir.core.base.model.BaseModel;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User extends BaseModel {

	@Column(unique=true, nullable=false)
	private String username;

	private String name;

	private String password;

	@Column(columnDefinition = "tinyint default 1")
	private boolean active;

	private int numLoginFailures;

	private Date lastLoginTime;

	private Date passwordExpireTime;

	private String lastLoginDetails;

	@ManyToOne(optional = false)
	@JoinColumn
	private Role role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getNumLoginFailures() {
		return numLoginFailures;
	}

	public void setNumLoginFailures(int numLoginFailures) {
		this.numLoginFailures = numLoginFailures;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getPasswordExpireTime() {
		return passwordExpireTime;
	}

	public void setPasswordExpireTime(Date passwordExpireTime) {
		this.passwordExpireTime = passwordExpireTime;
	}

	public String getLastLoginDetails() {
		return lastLoginDetails;
	}

	public void setLastLoginDetails(String lastLoginDetails) {
		this.lastLoginDetails = lastLoginDetails;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Transient
	public boolean isPasswordExpired() {
		if(passwordExpireTime == null){
			return true;
		}
		return passwordExpireTime.compareTo(new Date()) < 0;
	}
}
