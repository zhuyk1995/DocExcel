package com.zwsec.service.entity;

/**
 * UserEntity���ڷ�װ�û����ݵ�����Excel�ļ�
 * @author ZUOSHICHAO
 *
 */
public class UserEntity {

	/**
	 * �û�����
	 */
	private String userName;
	/**
	 * �û�����
	 */
	private String passWord;

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

	public UserEntity(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
}
