package org.apache.dragon.demo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * user follower info
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jun 24, 2013
 * @since 1.0
 */
public class UserFollower implements Serializable {

	//Local variables
	private static final long serialVersionUID = 6355171288905830289L;
	/**
	 * user id
	 */
	private long id;
	/**
	 * follower id
	 */
	private int fid;
	
	//setter and getter
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
	 * @return the fid
	 */
	public int getFid() {
		return fid;
	}
	
	/**
	 * @param fid the fid to set
	 */
	public void setFid(int fid) {
		this.fid = fid;
	}

	/** 
	  * TODO
	  * @see java.lang.Object#toString()
	  */
	@Override
	public String toString() {
		return "UserFollower [id=" + id + ", fid=" + fid + "]";
	}

}
