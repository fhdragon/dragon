package org.apache.dragon.test;

import java.util.Random;

import org.apache.log4j.Logger;
import org.jivesoftware.smack.AccountManager;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;


/**
 * TigaseTest: TODO
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2013-7-22
 * @since 1.0
 */
public class TigaseTest {

	//Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(TigaseTest.class);

	/**
	 * main
	 * 
	 * @param args
	 * @throws XMPPException 
	 */
	public static void main(String[] args) throws Exception {
		ConnectionConfiguration config = new ConnectionConfiguration("localhost");
		XMPPConnection connection = new XMPPConnection(config);
		connection.connect();
		AccountManager accountManager = connection.getAccountManager();
		long t = System.currentTimeMillis();
		accountManager.createAccount("fhdragon" + t, "password" + t);
		System.out.println(accountManager.supportsAccountCreation());
		connection.login("fhdragon", "password");
		Chat chat = connection.getChatManager().createChat("wenlongmeng1@localhost", new MessageListener() {

			@Override
			public void processMessage(Chat chat, Message m) {
				try {
					chat.sendMessage("message is received...");
				} catch (XMPPException e) {
					logger.error("", e);
				}
				System.out.println("Received message: " + m.getPacketID() + "/" + m.getBody() + "/" + m.getFrom() + "/" + m.getLanguage() + "/" + m.getPacketID() + "/" + m.getSubject() + "/" + m.getTo() + ", chat: " + chat);
			}
		});
		Message m = new Message(chat.getParticipant(), Message.Type.chat);
		String msg = "new account: fhdragon" + t + " / password" + t;
        m.setBody(msg);
        System.out.println("Send message: " + m.getPacketID() + "/" + m.getBody() + "/" + m.getFrom() + "/" + m.getLanguage() + "/" + m.getPacketID() + "/" + m.getSubject() + "/" + m.getTo() + ", chat: " + chat);
		chat.sendMessage(m);
		System.out.println("Send message: " + m.getPacketID() + "/" + m.getBody() + "/" + m.getFrom() + "/" + m.getLanguage() + "/" + m.getPacketID() + "/" + m.getSubject() + "/" + m.getTo() + ", chat: " + chat);
		Thread.sleep(30000);
		System.out.println(connection.getConnectionID());
		System.out.println(connection.getHost());
		System.out.println(connection.getPort());
		System.out.println(connection.getServiceName());
		System.out.println(connection.getUser());
		System.out.println(connection.getAccountManager());
		System.out.println(connection.getChatManager());
		connection.disconnect();
		String result = null;
		logger.debug("End: result = " + result);
	}

}
