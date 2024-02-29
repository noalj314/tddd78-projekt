package se.liu.noalj314.projekt;
import com.google.gson.GsonBuilder;
import java.security.*;
public class TestProgram {
    public static void main(String[] args) {
        BlockChain chain = new BlockChain();
        Wallet juliaWallet = new Wallet();
        Wallet noahWallet = new Wallet();

        PublicKey juliaPublic = juliaWallet.getPublicKey();
        PrivateKey juliaPrivate = juliaWallet.getPrivateKey();
        PublicKey noahPublic = noahWallet.getPublicKey();

        juliaWallet.setBalance(1000);
        noahWallet.setBalance(1000);




        // Skapa och mina genesis blocket
        chain.sendTransaction(juliaPublic, noahPublic,100, juliaPrivate);
        Block testBlock1 = new Block("test1");
        testBlock1.mineBlock();
        chain.sendTransaction(juliaPublic, noahPublic,100, juliaPrivate);
        chain.addBlock(testBlock1); // Lägg till det första blocket efter det är minat

        // Skapa och mine det andra blocket
//        Block testBlock2 = new Block("test2");
//        chain.sendTransaction(juliaPublic, noahPublic,100, juliaPrivate);
//        testBlock2.previousHash = testBlock1.getHash(); // Sätt previousHash korrekt
//        testBlock2.mineBlock();
//        chain.addBlock(testBlock2);
//
//        Block testBlock3 = new Block("test3");
//        chain.sendTransaction(noahPublic, juliaPublic,100, juliaPrivate);
//        testBlock3.previousHash = testBlock2.getHash(); // Sätt previousHash korrekt
//        testBlock3.mineBlock();
//        chain.addBlock(testBlock3);
//
//        Block testBlock4 = new Block("test3");
//        testBlock4.previousHash = testBlock3.getHash(); // Sätt previousHash korrekt
//        testBlock4.mineBlock();
//        chain.addBlock(testBlock4);


        boolean isValid = chain.isChainValid();
        System.out.println("Is blockchain valid? " + isValid);

        // Konvertera kedjan till JSON och skriv ut
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(chain);
        System.out.println(blockchainJson);
    }
}
