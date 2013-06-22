package org.apache.dragon.commons.crypto;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * Helper:
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jun 21, 2013
 * @since 1.0
 */
public class Helper {

	// local variables
	/**
	 * seed
	 */
	public static final String SEED = "@{F.H Dragon}";
	/**
	 * default public key for rsa
	 */
	public static final String PUB_KEY = "rO0ABXNyABRqYXZhLnNlY3VyaXR5LktleVJlcL35T7OImqVDAgAETAAJYWxnb3JpdGhtdAASTGphdmEvbGFuZy9TdHJpbmc7WwAHZW5jb2RlZHQAAltCTAAGZm9ybWF0cQB+AAFMAAR0eXBldAAbTGphdmEvc2VjdXJpdHkvS2V5UmVwJFR5cGU7eHB0AANSU0F1cgACW0Ks8xf4BghU4AIAAHhwAAAAojCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAoW5I6RcAoe2m8uaPbUO56WggMItOg0pLiFCk1uWijAKEzGpL1tTVHdaui4UgIsRiQEPZKji/t6ESLpNE7Fl58mybGzOd+PXBQWzFRn7X8u7Xvu5J7STlAML/fvQXBh6wYcN5nZhEUETCOnDHlH2s+Szzyy7UhnVuVvBg0ISb29kCAwEAAXQABVguNTA5fnIAGWphdmEuc2VjdXJpdHkuS2V5UmVwJFR5cGUAAAAAAAAAABIAAHhyAA5qYXZhLmxhbmcuRW51bQAAAAAAAAAAEgAAeHB0AAZQVUJMSUM=";
	/**
	 * default private key for rsa
	 */
	public static final String PRI_KEY = "rO0ABXNyABRqYXZhLnNlY3VyaXR5LktleVJlcL35T7OImqVDAgAETAAJYWxnb3JpdGhtdAASTGphdmEvbGFuZy9TdHJpbmc7WwAHZW5jb2RlZHQAAltCTAAGZm9ybWF0cQB+AAFMAAR0eXBldAAbTGphdmEvc2VjdXJpdHkvS2V5UmVwJFR5cGU7eHB0AANSU0F1cgACW0Ks8xf4BghU4AIAAHhwAAACejCCAnYCAQAwDQYJKoZIhvcNAQEBBQAEggJgMIICXAIBAAKBgQChbkjpFwCh7aby5o9tQ7npaCAwi06DSkuIUKTW5aKMAoTMakvW1NUd1q6LhSAixGJAQ9kqOL+3oRIuk0TsWXnybJsbM5349cFBbMVGftfy7te+7kntJOUAwv9+9BcGHrBhw3mdmERQRMI6cMeUfaz5LPPLLtSGdW5W8GDQhJvb2QIDAQABAoGAOcgh7NzA6zUHhvYj7HZLe1I8A2Q5rCDRvG8xMYJsljTol8qMbs8roUyQmXwDLq6ghGREvSom5XGP8n/gMcEtNpkr1Xnxr22Cq2laPeiubbAM+ipqwBSoiDdX+8TyJpLidLHDxhY/4Jfcu8XzxW2fJI6W/MUVffgeHumj8V9SziECQQDS925bs8AQuiUqS78x8hs1zsid9cz9zXpTsZCX+p4qT6BRQ5CDvljlEPKj9+fReqxKZVx2nP9VmqZUSmaJYMPVAkEAw+PnGZ7+eX0i+15c51vEDVev4xmgNrZ54tQbT81E9LGxI7gHKj2lkmb3UbdYUiKa9dsSSODdvDBrGIJ29EQt9QJBAJck0DsA4ATb6A6ScCuvYhE90fthg/j+Arr9hzNrSW/U1m4CMwJAGF4cs0oILVymP9OZJRKRzlkdUDcpiqa33fUCQEvKySbboqBE750MpKuLkO6Mp+wZhSjGL6C46pxU0sJOYjhswrDwSzi7CCQg6VZWN1i623dBMenXXgiMqhPWsWUCQBlo18HZ662n4R/zBU6MUmkFgxioEbjmpaT3WY8XB+NvesdVPiuMTa658eFAf1KsoFOO9AWPa/VhJFL7ASozXwZ0AAZQS0NTIzh+cgAZamF2YS5zZWN1cml0eS5LZXlSZXAkVHlwZQAAAAAAAAAAEgAAeHIADmphdmEubGFuZy5FbnVtAAAAAAAAAAASAAB4cHQAB1BSSVZBVEU=";

	// Logic
	/**
	 * generate Key with algorithm and seed
	 * 
	 * @param algorithm
	 * @param seed
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static SecretKey generateKey(String algorithm, byte[] seed) {
		if (seed == null) {
			seed = SEED.getBytes();
		}
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(seed);
			keyGenerator.init(secureRandom);
			return keyGenerator.generateKey();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * generate KeyPair with algorithm and seed
	 * 
	 * @param algorithm
	 * @param seed
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static KeyPair generateKeyPair(String algorithm) {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		try {
			KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance(algorithm);
			// keyGenerator.initialize(1024, new SecureRandom(seed));
			return keyGenerator.generateKeyPair();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * cipher instance
	 * 
	 * @param algorithm
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static Cipher cipher(String algorithm) {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		try {
			return Cipher.getInstance(algorithm);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
