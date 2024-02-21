package se.liu.noalj314.projekt;

import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    private final String data;
    private final long timeStamp;
    private int nonce;
    private static int difficulty = 4;

    public Block(String data) {
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash = newBlockHash();
        this.nonce = 0;
    }

    public String newBlockHash(){
        String correctHash = StringUtil.sha256(
                previousHash + timeStamp + nonce + data);
        return correctHash;
    }

    public String getHash() {
        return hash;
    }

    public void mineBlock(){
        String target = new String(new char[difficulty]).replace('\0', '0'); // Skapa en sträng med 'difficulty' antal nollor
        while(!hash.substring(0, difficulty).equals(target)){
            nonce ++;
            hash = newBlockHash();
            System.out.println("Nonce: " + nonce + "\n" + "Hash Attempted: " + hash);
        }
        System.out.println("Block Mined! Nonce to solve: " + nonce);
    }
}
