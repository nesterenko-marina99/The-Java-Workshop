package com.packt.java.chapter10;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Exercise01 {
    public static void main(String[] args) {
        try {
            String alg = "AES";
            Key privateKey = KeyGenerator.getInstance(alg).generateKey();
            String transformation = alg + "/ECB/PKCS5Padding";
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            String plaintext = "My secret message";
            byte[] ciphertext = new byte[cipher.getOutputSize(plaintext.getBytes().length)];
            int encryptedLength = cipher.update(plaintext.getBytes(), 0, plaintext.getBytes().length,
                    ciphertext);
            cipher.doFinal(ciphertext, encryptedLength);
            System.out.println(new String(ciphertext));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                ShortBufferException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
    }
}
