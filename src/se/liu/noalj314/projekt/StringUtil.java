package se.liu.noalj314.projekt;

import java.security.MessageDigest;


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
}
