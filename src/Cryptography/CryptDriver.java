package Cryptography;

/**
 * Created by dk on 11/22/2017.
 */

public class CryptDriver {
    public static void main(String[] args){
        CryptGram cg = new CryptGram();
        cg.createLetterFrequency("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");
        System.out.println("Encoded Message: " + cg.encode("There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain"));
        System.out.println("Decoded Message: " + cg.decode("Rxjmj yq dl ldj oxl nltjq pbyd yrqjnk, oxl qjjvq bkrjm yr bdh obdrq rl xbtj yr, qycpne fjgbsqj yr yq pbyd"));
    }
}
