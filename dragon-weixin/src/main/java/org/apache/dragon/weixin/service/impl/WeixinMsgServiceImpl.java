package org.apache.dragon.weixin.service.impl;

import org.apache.dragon.weixin.dao.WeixinMsgDao;
import org.apache.dragon.weixin.model.WeixinMsg;
import org.apache.dragon.weixin.service.WeixinMsgService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * service interface of weixin message
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2014/04/01 13:03
 */
@Component
public class WeixinMsgServiceImpl implements WeixinMsgService {

    //local variables
    /**
     * logger
     */
    private static Logger logger = Logger.getLogger(WeixinMsgServiceImpl.class);
    /**
     * dao
     */
    @Autowired
    private WeixinMsgDao dao;

    //Logic
    /**
     * 记录微信信息日志
     *
     * @param msg
     * @return
     */
    @Override
    public int log(String msg) {
        logger.debug("Begin: log(" + msg + ")...");
        int result = this.dao.log(msg);
        logger.debug("End: " + result);
        return result;
    }

    /**
     * 查询微信信息
     *
     * @param model
     * @return
     */
    @Override
    public WeixinMsg get(WeixinMsg model) {
        logger.debug("Begin: get(" + model + ")...");
        WeixinMsg result = this.dao.get(model);
        logger.debug("End: " + result);
        return result;
    }

}
