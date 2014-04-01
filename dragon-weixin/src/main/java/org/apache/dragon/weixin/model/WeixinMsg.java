package org.apache.dragon.weixin.model;

import java.io.Serializable;

/**
 * weixin basic info
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Mar 24, 2014
 * @since 1.0
 */
public class WeixinMsg implements Serializable {

	//Local variables
	private static final long serialVersionUID = 6355171288905830289L;
    /**
     * type of message
     */
	private String msgType;
    /**
     * event
     */
	private String event;
	/**
	 * 状态： 0 - 正常， -1 - 删除
	 */
	private int status;
	/**
	 * message
	 */
	private String msg;

	//setter and getter
    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "WeixinMsg{" +
                "msgType='" + msgType + '\'' +
                ", event='" + event + '\'' +
                ", status=" + status +
                ", msg='" + msg + '\'' +
                '}';
    }
}
