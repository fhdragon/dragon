package org.apache.dragon.weixin.dao;

import org.apache.dragon.weixin.model.QA;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * iq dao
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2014/04/01 12:37
 */
@Component
public interface IQDao {

    //Logic

    /**
     * get question by id
     *
     * @param id
     * @return
     */
    @Select("select id, content, type, update_time from iq_question where id = #{id}")
    public QA q(@Param("id")int id);

    /**
     * get answer by id
     *
     * @param id
     * @return
     */
    @Select("select from weixin_msg where msg_type = #{msgType} and (event = #{event} or #{event} is null) and status = #{status}")
    public QA a(@Param("id")int id);

}
