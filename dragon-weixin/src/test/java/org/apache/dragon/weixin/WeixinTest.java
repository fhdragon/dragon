package org.apache.dragon.weixin;

import com.thoughtworks.xstream.XStream;
import org.apache.commons.io.IOUtils;
import org.apache.dragon.weixin.model.Weixin;

import java.io.InputStream;
import java.io.Serializable;

/**
 * TODO
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2014/03/30 18:34
 */
public class WeixinTest {

    //local variables

    //Constructor

    //Logic
    public static void main(String[] args){
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() / 1000L);
        String x = "<xml>" +
                " <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                " <FromUserName><![CDATA[fromUser]]></FromUserName> \n" +
                " <CreateTime>1348831860</CreateTime>\n" +
                " <MsgType><![CDATA[text]]></MsgType>\n" +
                " <Content><![CDATA[this is a test]]></Content>\n" +
                " <MsgId>1234567890123456</MsgId>\n" +
                " </xml>";
        InputStream is = IOUtils.toInputStream(x);
        XStream xs = new XStream();
        xs.alias("xml", Weixin.TextMsg.class);
        Weixin.TextMsg msg = (Weixin.TextMsg)xs.fromXML(is);
        System.out.println(msg);

        String r = xs.toXML(msg);
        System.out.println(r);
    }

}
