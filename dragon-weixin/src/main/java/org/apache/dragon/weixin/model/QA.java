package org.apache.dragon.weixin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * question/answer model info
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Apr 1, 2014
 * @since 1.0
 */
public class QA implements Serializable {

	//Local variables
	private static final long serialVersionUID = 6355171288905830289L;
    /**
     * message
     */
	private int id;
    /**
     * content
     */
	private String content;
	/**
	 * 类型
	 */
	private int type;
	/**
	 * update time
	 */
	private Date updateTime;

	//setter and getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "QA{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", updateTime=" + updateTime +
                '}';
    }
}
