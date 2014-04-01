package org.apache.dragon.weixin.service;

import org.apache.dragon.weixin.model.QA;

/**
 * iq service interface
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2014/04/01 13:00
 */
public interface IQService {

    //Logic

    /**
     * get question by id
     *
     * @param id
     * @return
     */
    public QA q(int id);

    /**
     * get answer by id
     *
     * @param id
     * @return
     */
    public QA a(int id);

}
