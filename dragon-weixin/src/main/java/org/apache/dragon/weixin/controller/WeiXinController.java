package org.apache.dragon.weixin.controller;


import com.thoughtworks.xstream.XStream;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;
import org.apache.dragon.commons.util.StringUtil;
import org.apache.dragon.weixin.model.QA;
import org.apache.dragon.weixin.model.Weixin;
import org.apache.dragon.weixin.model.WeixinMsg;
import org.apache.dragon.weixin.service.IQService;
import org.apache.dragon.weixin.service.WeixinMsgService;
import org.apache.dragon.weixin.util.Consts;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * WeiXin验证及信息处理
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 06, 2014
 * @since 1.0
 */
@Controller
@RequestMapping("weixin")
public class WeiXinController {

	// Local variables
	/**
	 * service
	 */
	@Autowired
	private WeixinMsgService service;
    /**
	 * iq service
	 */
	@Autowired
	private IQService iqService;
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(WeiXinController.class);

	// Logic
	/**
	 * check weixin
	 * 
	 * @param model - weixin model
	 * @return echostr for weixin
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody String checkTest(Weixin model) {
		logger.debug("Begin: checkTest(" + model + ")...");
        if(!check(model)){
            throw new RuntimeException("non weixin");
        }
		//check
		String result = model.getEchostr();
		//return
		logger.debug("End: result = " + result);
		return result;
	}

    /**
	 * handle weixin message
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public @ResponseBody String test(HttpServletRequest req, Weixin model) {
		logger.debug("Begin: test(" + model + ")...");
        //check weixin signature
        if(!check(model)){
            throw new RuntimeException("non weixin");
        }

        InputStream is = null;
        String result = "";
        try{
            //获取消息
            is = req.getInputStream();
            //记录日志
            String _msg = IOUtils.toString(is);
            this.service.log(_msg);
            //消息转java对象
            XStream xs = new XStream();
            xs.alias("xml", Weixin.TextMsg.class);
            Weixin.FullMsg msg = (Weixin.FullMsg)xs.fromXML(is);
            logger.debug("msg: " + msg);
            WeixinMsg _m = new WeixinMsg();
            _m.setMsgType(msg.getMsgType());
            //文本信息处理
            if(msg.getMsgType().equals("text")){
                //iq
                String c = msg.getContent().trim().toLowerCase();
                if(c.indexOf("iq") == 0){
                    String[] cs = c.split(":");
                    int id = cs.length == 2 ? StringUtil.num(cs[1], 1) : 1;
                    QA qa = this.iqService.q(id);
                    _m.setMsg(qa.getContent());
                }
            }else if(msg.getMsgType().equals("event")){
                _m.setEvent(msg.getEvent());
                _m = this.service.get(_m);
            }
            //帮助信息
            if(_m.getMsg() == null){
                _m.setEvent("?");
                _m = this.service.get(_m);
            }

            Weixin.TextMsg _r = new Weixin.TextMsg();
            _r.setContent(_m.getMsg());
            _r.setCreateTime(System.currentTimeMillis() / 1000L);
            _r.setMsgType("text");
            _r.setMsgId(msg.getMsgId());
            _r.setFromUserName(msg.getToUserName());
            _r.setToUserName(msg.getFromUserName());
            result = xs.toXML(_r);
        }catch(IOException e){
            logger.error("", e);
        }finally{
            if(is != null){
                try{
                    is.close();
                }catch(IOException e){
                }
            }
        }
		logger.debug("End: result = " + result);
		return result;
	}

	/**
	 * default welcome page
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/nav/{page}", method = RequestMethod.GET)
	public String index(@PathVariable("page") String page) {
		logger.debug("Begin: index(" + page + ")...");
		String result = page;
		logger.debug("End: result = " + result);
		return result;
	}

    /**
     * check weixin signature
     *
     * @param model weixin
     * @return
     */
    public static boolean check(Weixin model){
        String[] str = {Consts.WEIXIN_TOKEN, model.getTimestamp() + "", model.getNonce() + ""};
        Arrays.sort(str); // 字典序排序
        String bigStr = str[0] + str[1] + str[2];
        // SHA1加密
        String digest = "";
        try{
            digest = Hex.encodeHexString(MessageDigest.getInstance("SHA1").digest(bigStr.getBytes())).toLowerCase();
        }catch(Exception e){
            e.printStackTrace();;
        }

        return digest.equals(model.getSignature());
    }

}
