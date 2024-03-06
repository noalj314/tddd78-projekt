package se.liu.noalj314.gammaltprojekt;
import com.google.gson.GsonBuilder;

public class TestProgram {
    public static void main(String[] args) {
        BlockChain chain = new BlockChain();
        Wallet juliaWallet = new Wallet();
        Wallet noahWallet = new Wallet();

        String juliaPublic = juliaWallet.getPublicKey();
        String juliaPrivate = juliaWallet.getPrivateKey();
        String noahPublic = noahWallet.getPublicKey();
        System.out.println("Julias plånbok: " + juliaPublic);





        // Skapa och mina genesis blocket
        //chain.sendTransaction(juliaPublic, noahPublic,100, juliaPrivate);
        Block testBlock1 = new Block("test1");
        testBlock1.mineBlock(juliaPublic);
        chain.addBlock(testBlock1); // Lägg till det första blocket efter det är minat
        chain.sendTransaction(juliaPublic, noahPublic,100, juliaPrivate);


        // Skapa och mine det andra blocket
            Block testBlock2 = new Block("test2");
//        chain.sendTransaction(juliaPublic, noahPublic,100, juliaPrivate);
//        testBlock2.previousHash = testBlock1.getHash(); // Sätt previousHash korrekt
//        testBlock2.mineBlock();
            chain.addBlock(testBlock2);
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
