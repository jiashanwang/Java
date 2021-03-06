package cn.itcast.mybatis.po;

import java.util.Date;

/**
 * 用户po
 * @author Administrator
 *
 */
public class User {
	
	// 属性名和数据库的字段对应
	private int id;
	private String username;
	private String sex;
	private Date birthday;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", birthday=" + birthday + ", address="
				+ address + ", getId()=" + getId() + ", getUsername()=" + getUsername() + ", getSex()=" + getSex()
				+ ", getBirthday()=" + getBirthday() + ", getAddress()=" + getAddress() + "]";
	}
	
}
