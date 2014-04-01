package org.apache.dragon.weixin.service;

import org.apache.dragon.weixin.model.WeixinMsg;

/**
 * 微信消息接口
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2014/04/01 13:00
 */
public interface WeixinMsgService {

    //Logic
    /**
     * 记录微信信息日志
     *
     * @param msg
     * @return
     */
    public int log(String msg);

    /**
     * 查询微信信息
     *
     * @param model
     * @return
     */
    public WeixinMsg get(WeixinMsg model);

}
