package se.liu.noalj314.projekt;

import java.util.ArrayList;

public class BlockChain {
    private int difficulty;
    private int minerReward;
    private ArrayList<Block> blockChain;

    public BlockChain() {
        this.difficulty = 4;
        this.minerReward = 100;
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
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < this.blockChain.size(); i++){
            // do not check first block since that has no previous block so no hash we can compare
            currentBlock = this.blockChain.get(i);
            previousBlock = this.blockChain.get(i - 1);

            if (!currentBlock.previousHash.equals(previousBlock.newBlockHash())) {
                // check if current blocks stored previous hash is equal to the calculation of the previous block hash
                System.out.println("Error 1");
                return false;

            }   if (!currentBlock.getHash().equals(currentBlock.newBlockHash())){
                // check if current blocks stored hash is equal to the calculation of the current block hash
                System.out.println("Error 2s");
                return false;
            }

        }
        return true;
    }
}
