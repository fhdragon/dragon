package org.apache.dragon.weixin.controller;


import com.thoughtworks.xstream.XStream;
import org.apache.dragon.weixin.model.Weixin;
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
//	private StatsService service;
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
		//check
		//return
		String result = model.getEchostr();
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
        InputStream is = null;
        String result = "";
        try{
            is = req.getInputStream();
            XStream xs = new XStream();
            xs.alias("xml", Weixin.TextMsg.class);
            Weixin.TextMsg msg = (Weixin.TextMsg)xs.fromXML(is);
            logger.debug("msg: " + msg);
            Weixin.TextMsg _r = new Weixin.TextMsg();
            String content = "Name: Wenlong Meng\n mailto: wenlong.meng@gmail.com";
            _r.setContent(content);
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

}
