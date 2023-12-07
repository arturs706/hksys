package org.example.passwordgen;


import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

//CONCRETE COMMAND CLASS
public class HashConcreteComm implements HashingCommand {

    private HashPass hashpass;


    private static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return new BigInteger(1, salt).toString(16);
    }
    private static String hashPassword(@org.jetbrains.annotations.NotNull String password, String salt) {
        String hashedPassword = null;
        try {
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hashedPassword = new BigInteger(1, factory.generateSecret(spec).getEncoded()).toString(16);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return hashedPassword;
    }
    // comes from received HashPass
    public HashConcreteComm(HashPass hashpass) {
        this.hashpass = hashpass;
    }
// THIS IMPLEMENT A RECEIVED CALLED FROM CLIENT
    @Override
    public String hashExe(String passwordToHash) {
        String salt = generateSalt();
        String hashedPassword = hashPassword(passwordToHash, salt);
        return salt + hashedPassword;

    }
}