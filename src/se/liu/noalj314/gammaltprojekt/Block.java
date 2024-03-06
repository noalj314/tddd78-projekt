package se.liu.noalj314.gammaltprojekt;

import java.util.ArrayList;
import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    private final String data;
    private final long timeStamp;
    private int nonce;
    private int difficulty = 4;
    private int MINERREWARD = 100;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>(); // våra transaktioner
    public Block(String data) {
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash = newBlockHash();
        this.nonce = 0;
    }
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    public String getHash() {
        return hash;
    }
    public String newBlockHash(){
        String correctHash = StringUtil.sha256(
                previousHash + timeStamp + nonce + data);
        return correctHash;
    }
    public void mineBlock(String miner){
        String target = new String(new char[difficulty]).replace('\0', '0'); // Skapa en sträng med 'difficulty' antal nollor
        while(!hash.substring(0, difficulty).equals(target)){
            nonce ++;
            hash = newBlockHash();
            System.out.println("Nonce: " + nonce + "\n" + "Hash Attempted: " + hash);
        }
        System.out.println("Block Mined! Nonce to solve: " + nonce);
        payMiner(miner);
    }

    public void payMiner(String miner) {
        Transaction minerTransaction = new Transaction("Miner Reward", miner, MINERREWARD);
        transactions.add(minerTransaction);
    }
}
