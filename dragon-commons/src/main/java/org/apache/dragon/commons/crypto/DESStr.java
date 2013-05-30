package org.apache.dragon.commons.crypto;

/**
 * CryptoDES: encrytor/decrytor by ByteDES
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at May 30, 2013
 * @since 1.0
 */
public class DESStr implements Crypto<String> {

	// Local variables
	/**
	 * byte DES
	 */
	private Crypto<byte[]> byteDES = new DESByte();

	// Logic
	/**
	 * encrytor t
	 * 
	 * @param t
	 * @return
	 * @see org.apache.dragon.commons.crypto.Crypto#encrytor(java.lang.Object)
	 */
	@Override
	public String encrytor(String t) {
		return new String(this.byteDES.encrytor(t.getBytes()));
	}

	/**
	 * decrytor t
	 * 
	 * @param t
	 * @return
	 * @see org.apache.dragon.commons.crypto.Crypto#decrytor(java.lang.Object)
	 * @see #byteDES
	 */
	@Override
	public String decrytor(String t) {
		return new String(this.byteDES.decrytor(t.getBytes()));
	}

}
