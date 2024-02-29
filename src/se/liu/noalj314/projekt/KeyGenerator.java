package se.liu.noalj314.projekt;
import java.security.*;
import java.util.Base64;
public class KeyGenerator
{
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public KeyGenerator() {
	try {
	    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
	    keyGen.initialize(2048);

	    KeyPair pair = keyGen.generateKeyPair();
	    this.privateKey = pair.getPrivate();
	    this.publicKey = pair.getPublic();

	} catch (NoSuchAlgorithmException e) {
	    e.printStackTrace();
	}
    }
    public PublicKey getPublicKey(){
	return this.publicKey;
    }

    public PrivateKey getPrivateKey(){
	return this.privateKey;
    }
}
