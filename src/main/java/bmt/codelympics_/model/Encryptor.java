package bmt.codelympics_.model;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Encryptor {

    public String encryptString(String input) throws NoSuchAlgorithmException {

        //MessageDigest works with MD2, MD5, SHA-1, SHA-224, SHA-256
        //SHA-384 and SHA-512
        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] messageDigest = md.digest(input.getBytes());

        BigInteger bigInt = new BigInteger(1,messageDigest);

        return bigInt.toString(16);
    }


}