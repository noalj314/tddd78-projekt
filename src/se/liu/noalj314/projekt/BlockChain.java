package se.liu.noalj314.projekt;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

public class BlockChain {
    private int difficulty;
    private ArrayList<Block> blockChain;

    public BlockChain() {
        this.difficulty = 4;
	int minerReward = 100;
        this.blockChain = new ArrayList<Block>();
    }

    public void addBlock(Block block) {
        if (!this.blockChain.isEmpty()) {
            System.out.println(getLastBlock().getHash());
            block.previousHash = getLastBlock().getHash();
        } else{
            block.previousHash = "null";
        }
        this.blockChain.add(block);
    }

    public Block getLastBlock(){
        return this.blockChain.get(this.blockChain.size() - 1); // getting the last block
    }


    public boolean isChainValid(){
	for (int i = 1; i < this.blockChain.size(); i++){
            // do not check first block since that has no previous block so no hash we can compare
            Block currentBlock = this.blockChain.get(i);
	    Block previousBlock = this.blockChain.get(i - 1);

	    if (!currentBlock.previousHash.equals(previousBlock.newBlockHash())) {
                // check if current blocks stored previous hash is equal to the calculation of the previous block hash
                System.out.println("Error 1");
                return false;

            }   if (!currentBlock.getHash().equals(currentBlock.newBlockHash())){
                // check if current blocks stored hash is equal to the calculation of the current block hash
                System.out.println("Error 2");
                return false;
            }

        }
        return true;
    }

    public ArrayList<Block> getAllBlocks(){
        return blockChain;
    }
    public float getBalanceForKey(PublicKey publicKey){
        float balance = 0;
        for (Block block: this.getAllBlocks()){
            for (Transaction transaction: block.getTransactions()) {
                if (transaction.sender.equals(StringUtil.getStringFromKey(publicKey))) {
                    balance -= transaction.amount;
                }
                if (transaction.reciever.equals(StringUtil.getStringFromKey(publicKey))) {
                    balance += transaction.amount;
                }
            }
        }
        return balance;
    }

    public void sendTransaction(PublicKey sender, PublicKey reciever, float amount, PrivateKey privateKey){
        Transaction newTransaction = new Transaction(sender, reciever, amount);
        newTransaction.generateSignature(privateKey);
        // check if the transaction is valid and if the sender has enough money
        if (newTransaction.isTransactionValid() && amount <= getBalanceForKey(sender)) {
            getLastBlock().getTransactions().add(newTransaction);  // add the transaction to the last block
        } else {
            System.out.println("Wrong signature or not enough funds");
        }
    }
}
