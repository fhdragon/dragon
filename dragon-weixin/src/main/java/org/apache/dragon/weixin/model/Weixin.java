package org.apache.dragon.weixin.model;

import java.io.Serializable;

/**
 * weixin basic info
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Mar 24, 2014
 * @since 1.0
 */
public class Weixin implements Serializable {

	//Local variables
	private static final long serialVersionUID = 6355171288905830289L;
	/**
	 * 微信加密签名
	 */
	private String signature;
	/**
	 * 时间戳
	 */
	private long timestamp;
	/**
	 * 随机数
	 */
	private long nonce;
	/**
	 * 随机字符串
	 */
	private String echostr;
	/**
	 * url
	 */
	private String url;
	/**
	 * token
	 */
	private String token;
	
	//setter and getter
	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}
	
	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	/**
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}
	
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	 * @return the nonce
	 */
	public long getNonce() {
		return nonce;
	}
	
	/**
	 * @param nonce the nonce to set
	 */
	public void setNonce(long nonce) {
		this.nonce = nonce;
	}
	
	/**
	 * @return the echostr
	 */
	public String getEchostr() {
		return echostr;
	}
	
	/**
	 * @param echostr the echostr to set
	 */
	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/** 
	  * @see Object#toString()
	  */
	@Override
	public String toString() {
		return "Weixin [signature=" + signature + ", timestamp=" + timestamp + ", nonce=" + nonce + ", echostr="
				+ echostr + ", url=" + url + ", token=" + token + "]";
	}

    //inner class: message model
    /**
     * message for weixin
     *
     * @author Wenlong Meng(wenlong.meng@gmail.com)
     * @version 1.0 at 2014/03/30
     * @since 1.0
     */
    public static class Msg implements Serializable {

        //local variables
        private String ToUserName;
        private String FromUserName;
        private long CreateTime;
        private String MsgType;

        //getter and setter
        public String getToUserName() {
            return ToUserName;
        }

        public void setToUserName(String toUserName) {
            this.ToUserName = toUserName;
        }

        public String getFromUserName() {
            return FromUserName;
        }

        public void setFromUserName(String fromUserName) {
            this.FromUserName = fromUserName;
        }

        public long getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(long createTime) {
            this.CreateTime = createTime;
        }

        public String getMsgType() {
            return MsgType;
        }

        public void setMsgType(String msgType) {
            this.MsgType = msgType;
        }

        @Override
        public String toString() {
            return "Msg{" +
                    "ToUserName='" + ToUserName + '\'' +
                    ", FromUserName='" + FromUserName + '\'' +
                    ", CreateTime=" + CreateTime +
                    ", MsgType='" + MsgType + '\'' +
                    '}';
        }
    }

    /**
     * message for weixin
     *
     * @author Wenlong Meng(wenlong.meng@gmail.com)
     * @version 1.0 at 2014/03/30
     * @since 1.0
     */
    public static class TextMsg extends Msg {

        //local variables
        private String Content;
        private String MsgId;

        //getter and setter
        public String getContent() {
            return Content;
        }

        public void setContent(String content) {
            Content = content;
        }

        public String getMsgId() {
            return MsgId;
        }

        public void setMsgId(String msgId) {
            this.MsgId = msgId;
        }

        @Override
        public String toString() {
            return "TextMsg{" +
                    "Content='" + Content + '\'' +
                    ", MsgId='" + MsgId + '\'' +
                    "} " + super.toString();
        }
    }

    /**
     * message for weixin
     *
     * @author Wenlong Meng(wenlong.meng@gmail.com)
     * @version 1.0 at 2014/03/30
     * @since 1.0
     */
    public static class FullMsg extends TextMsg {

        //local variables
        private String Event;
        private String EventKey;
        private String Ticket;

        //getter and setter

        public String getEvent() {
            return Event;
        }

        public void setEvent(String event) {
            Event = event;
        }

        public String getEventKey() {
            return EventKey;
        }

        public void setEventKey(String eventKey) {
            EventKey = eventKey;
        }

        public String getTicket() {
            return Ticket;
        }

        public void setTicket(String ticket) {
            Ticket = ticket;
        }

        @Override
        public String toString() {
            return "FMsg{" +
                    "Event='" + Event + '\'' +
                    ", EventKey='" + EventKey + '\'' +
                    ", Ticket='" + Ticket + '\'' +
                    "} " + super.toString();
        }
    }

}
