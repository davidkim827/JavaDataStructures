package ForFun.Cryptography;

/**
 * Created by dk on 11/22/2017.
 */

//tester//driver class
public class CryptDriver {
    public static void main(String[] args){
        CryptGram cg = new CryptGram();
        cg.createLetterFrequency("Sarah love you");
        System.out.println("Encoded Message: " + cg.encode("Marshmallow"));
        System.out.println("Decoded Message: " + cg.decode("Sbaemsbrrwy"));
    }
}
