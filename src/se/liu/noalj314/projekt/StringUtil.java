package se.liu.noalj314.projekt;

import java.security.*;
import java.util.Base64;
import java.security.spec.X509EncodedKeySpec;


public class StringUtil {
    public static String sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); //  sätter algoritmen till sha-256
            byte[] hash = digest.digest(input.getBytes("UTF-8")); //  hashar inputen
            StringBuilder sb = new StringBuilder();  // skapa en stringbuilder
            for (byte b : hash ){
                // för varje byte i hashen, konvertera till hex och lägg till i en stringbuilder
                sb.append(String.format("%02x", b)); // %02x betyder att vi vill ha två siffror i hexadecimal
            }
            return sb.toString(); // returnera vår nya hash
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
        public static String getStringFromKey(java.security.Key key) {
                return Base64.getEncoder().encodeToString(key.getEncoded());
        }

        public static PublicKey getPublicKeyfromString(String key) {
            try {
                    byte[] decodedKey = Base64.getDecoder().decode(key);
                    X509EncodedKeySpec spec = new X509EncodedKeySpec(decodedKey);
                    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                    return keyFactory.generatePublic(spec);
            } catch (Exception e) {
                    e.printStackTrace();
                    return null;
	    }
	}

        public static byte[] applyRSASig(PrivateKey privateKey, String input) {
                Signature rsa;
                byte[] output = new byte[0];
                try {
                        rsa = Signature.getInstance("SHA256withRSA"); // Använd RSA med SHA-256 för signering
                        rsa.initSign(privateKey);
                        byte[] strByte = input.getBytes();
                        rsa.update(strByte);
                        byte[] realSig = rsa.sign();
                        output = realSig;
                } catch (Exception e) {
                        throw new RuntimeException(e);
                }
                return output;
        }
    public static boolean verifyRSASig(PublicKey publicKey, String data, byte[] signature) {
        try {
            Signature rsaVerify = Signature.getInstance("SHA256withRSA"); // Verifiera med RSA och SHA-256
            rsaVerify.initVerify(publicKey);
            rsaVerify.update(data.getBytes());
            return rsaVerify.verify(signature);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
