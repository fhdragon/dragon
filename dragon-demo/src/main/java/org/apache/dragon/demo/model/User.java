package org.apache.dragon.demo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * User: user basic info
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 2, 2013
 * @since 1.0
 */
public class User implements Serializable {

	//Local variables
	private static final long serialVersionUID = 6355171288905830289L;
	/**
	 * user id
	 */
	private long id;
	/**
	 * user name
	 */
	private String name;
	/**
	 * birthday
	 */
	private Date birthday;
	/**
	 * age
	 */
	private int age;
	/**
	 * sex
	 */
	private int sex;
	/**
	 * create time
	 */
	private Date createTime;
	/**
	 * update time
	 */
	private Date updateTime;
	
	//Logic
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}
	
	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/** 
	  * @see java.lang.Object#toString()
	  */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthday=" + birthday + ", age=" + age + ", sex=" + sex
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}
