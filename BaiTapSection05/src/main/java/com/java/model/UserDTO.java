package com.java.model;

import org.springframework.web.multipart.MultipartFile;

public class UserDTO {
	private int id;
	private String username;
	private String password;
	private String fullname;
	private String address;
	private String phone;
	private String infomation;
	private String mail;
	private String image;
	private MultipartFile avatar;
	
	public UserDTO(int id, String username, String password, String fullname,String address, String phone,String infomation, String mail, String img) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.address = address;
		this.phone = phone;
		this.infomation = infomation;
		this.mail = mail;
		this.image = img;
	}

	public UserDTO(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public UserDTO() {

	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getInfomation() {
		return infomation;
	}

	public void setInfomation(String infomation) {
		this.infomation = infomation;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public MultipartFile getAvatar() {
		return avatar;
	}

	public void setAvatar(MultipartFile avatar) {
		this.avatar = avatar;
	}
	
	
}
