package com.bookwebsystem.vo;

public class UserVo {

	private String id;
	
	/**
	 * 真实姓名
	 */
	private String realName;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 年龄
	 */
	private int age;
	
	/**
	 * 电话号码
	 */
	private String telephone;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 用户名
	 */
    private String userName;
    
    /**
     * 密码
     */
    private String passWord;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
