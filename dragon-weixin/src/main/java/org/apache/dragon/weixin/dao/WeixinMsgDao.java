package org.apache.dragon.weixin.dao;

import org.apache.dragon.weixin.model.WeixinMsg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * weixin message dao
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2014/04/01 12:37
 */
@Component
public interface WeixinMsgDao {

    //Logic

    /**
     * 记录日志
     *
     * @param msg
     * @return
     */
    @Insert("insert into weixin_msg_log(msg) values(#{msg})")
    public int log(@Param("msg") String msg);

    /**
     * 查询微信消息
     *
     * @param model
     * @return
     */
    @Select("select from weixin_msg where msg_type = #{msgType} and (event = #{event} or #{event} is null) and status = #{status}")
    public WeixinMsg get(WeixinMsg model);

}
