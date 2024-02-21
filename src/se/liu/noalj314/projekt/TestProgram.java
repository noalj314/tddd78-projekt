package se.liu.noalj314.projekt;
import com.google.gson.GsonBuilder;
public class TestProgram {
    public static void main(String[] args) {
        BlockChain chain = new BlockChain();

        // Skapa och mina genesis blocket
        Block testBlock1 = new Block("test1");
        testBlock1.mineBlock();
        chain.addBlock(testBlock1); // Lägg till det första blocket efter det är minat

        // Skapa och mine det andra blocket
        Block testBlock2 = new Block("test2");
        testBlock2.previousHash = testBlock1.getHash(); // Sätt previousHash korrekt
       // testBlock2.mineBlock();
        chain.addBlock(testBlock2);


        boolean isValid = chain.isChainValid();
        System.out.println("Is blockchain valid? " + isValid);

        // Konvertera kedjan till JSON och skriv ut
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(chain);
        System.out.println(blockchainJson);
    }
}
