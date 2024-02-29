package se.liu.noalj314.projekt;

import java.security.*;

public class Wallet
{
    private PrivateKey privateKey;
    private PublicKey publicKey;
    float balance = 0;
    public Wallet() {
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
    public float getBalance(BlockChain chain){
	for (Block block: chain.getAllBlocks()){
	    for (Transaction transaction: block.getTransactions()) {
		if (transaction.sender.equals(StringUtil.getStringFromKey(this.publicKey))) {
		    balance -= transaction.amount;
	    }
		if (transaction.reciever.equals(StringUtil.getStringFromKey(this.publicKey))) {
		    balance += transaction.amount;
		}
	    }
	}
	return balance;
    }
    public float getBalanceForKey(BlockChain chain, PublicKey key){
	for (Block block: chain.getAllBlocks()){
	    for (Transaction transaction: block.getTransactions()) {
		if (transaction.sender.equals(StringUtil.getStringFromKey(key))) {
		    balance -= transaction.amount;
		}
		if (transaction.reciever.equals(StringUtil.getStringFromKey(key))) {
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