package se.liu.noalj314.gammaltprojekt;

import java.security.*;

public class Wallet
{
    private String privateKey;
    private String publicKey;
    float balance = 0;
    public Wallet() {
	try {
	    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
	    keyGen.initialize(2048);

	    KeyPair pair = keyGen.generateKeyPair();
	    this.privateKey = StringUtil.getStringFromKey(pair.getPrivate());
	    this.publicKey = StringUtil.getStringFromKey(pair.getPublic());
	} catch (NoSuchAlgorithmException e) {
	    e.printStackTrace();
	}
    }
    public String getPublicKey(){
	return this.publicKey;
    }
    public String getPrivateKey(){
	return this.privateKey;
    }
    public float getBalance(BlockChain chain){
	for (Block block: chain.getAllBlocks()){
	    for (Transaction transaction: block.getTransactions()) {
		if (transaction.sender.equals(this.publicKey)) {
		    balance -= transaction.amount;
	    }
		if (transaction.reciever.equals(this.publicKey)) {
		    balance += transaction.amount;
		}
	    }
	}
	return balance;
    }

    // this needs fixiing since it will manipulate the balance for all wallets
    public float getBalanceForKey(BlockChain chain, String key){
	for (Block block: chain.getAllBlocks()){
	    for (Transaction transaction: block.getTransactions()) {
		if (transaction.sender.equals(key)) {
		    balance -= transaction.amount;
		}
		if (transaction.reciever.equals(key)) {
		    balance += transaction.amount;
		}
	    }
	}
	return balance;
    }
    public void setBalance(float balance){
	this.balance = balance;
    }
}