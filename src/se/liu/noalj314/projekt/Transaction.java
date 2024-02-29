package se.liu.noalj314.projekt;

import java.security.*;
import java.util.Base64;
public class Transaction
{
    public String sender; // avsändarens adress
    public String reciever; // mottagarens adress
    public float amount; // mängden valuta
    private String signature = null; // innehåller en digital signatur för att verifiera att avsändaren har godkänt transaktionen
    private byte [] signatureBytes = null;

    public Transaction(PublicKey sender, PublicKey reciever, float amount) {
	this.sender = StringUtil.getStringFromKey(sender);
	this.reciever = StringUtil.getStringFromKey(reciever);
	this.amount = amount;
    }

    private String calculateHash() {
	return StringUtil.sha256(
		sender
				 + reciever +
				 Float.toString(amount));
    }
    public byte[] getSignature() {
	return Base64.getDecoder().decode(this.signature);
    }

    public void setSignature(byte[] signature) {
	this.signature = Base64.getEncoder().encodeToString(signature);
    }

    public void generateSignature(PrivateKey privateKey) {
	String data = sender + reciever + Float.toString(amount);
	byte[] signatureBytes = StringUtil.applyRSASig(privateKey, data);
	this.signature = Base64.getEncoder().encodeToString(signatureBytes);
    }
    public boolean verifySignature() {
	String data = sender + reciever + Float.toString(amount);
	byte[] signatureBytes = getSignature();
	return StringUtil.verifyRSASig(StringUtil.getPublicKeyfromString(sender), data, signatureBytes);
    }
    public boolean isTransactionValid() {
	if (verifySignature()) {
	    System.out.println("Transaktionen är giltig.");
	    return true;
	} else {
	    System.out.println("Transaktionen är ogiltig.");
	    return false;
	}
    }

}

