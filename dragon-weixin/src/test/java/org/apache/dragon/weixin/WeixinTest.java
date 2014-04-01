package org.apache.dragon.weixin;

import com.thoughtworks.xstream.XStream;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;
import org.apache.dragon.weixin.model.Weixin;
import org.apache.dragon.weixin.util.Consts;

import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Arrays;

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

        //check
        String signature="ade92b86fa40843035d68d652c288d406144a10a", timestamp="1396302544", nonce="1571167924";
        boolean rs = check(signature, timestamp, nonce);
        System.out.println(rs);

    }
    public static boolean check(String signature, String timestamp, String nonce){
        String[] str = {Consts.WEIXIN_TOKEN, timestamp, nonce};
        Arrays.sort(str); // 字典序排序
        String bigStr = str[0] + str[1] + str[2];
        // SHA1加密
        String digest = "";
        try{
            digest = Hex.encodeHexString(MessageDigest.getInstance("SHA1").digest(bigStr.getBytes())).toLowerCase();
        }catch(Exception e){
            e.printStackTrace();
        }

        return digest.equals(signature);
    }

}
