package org.apache.dragon.weixin.service.impl;

import org.apache.dragon.weixin.dao.IQDao;
import org.apache.dragon.weixin.model.QA;
import org.apache.dragon.weixin.service.IQService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * iq service implement
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2014/04/01 13:03
 */
@Component
public class IQServiceImpl implements IQService {

    //local variables
    /**
     * logger
     */
    private static Logger logger = Logger.getLogger(IQServiceImpl.class);
    /**
     * dao
     */
    @Autowired
    private IQDao dao;

    //Logic

    /**
     * get question by id
     *
     * @param id
     * @return
     */
    @Override
    public QA q(int id) {
        logger.debug("Begin: q(" + id + ")...");
        QA result = this.dao.q(id);
        logger.debug("End: " + result);
        return result;
    }

    /**
     * get answer by id
     *
     * @param id
     * @return
     */
    @Override
    public QA a(int id) {
        logger.debug("Begin: a(" + id + ")...");
        QA result = this.dao.a(id);
        logger.debug("End: " + result);
        return result;
    }
}
