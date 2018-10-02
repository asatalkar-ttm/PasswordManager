package convert;

//import java.security.SecureRandom;
//
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.SecretKey;
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.PBEKeySpec;
//import javax.crypto.spec.SecretKeySpec;
//
//import org.apache.commons.codec.binary.Base64;
//
//public class Encryption {
//    private static final String TOKEN = "passwd";
//    private String salt;
//    private int pwdIterations = 65536;
//    private int keySize = 256;
//    private byte[] ivBytes;
//    private String keyAlgorithm = "AES";
//    private String encryptAlgorithm = "AES/CBC/PKCS5Padding";
//    private String secretKeyFactoryAlgorithm = "PBKDF2WithHmacSHA1";
//
//    public Encryption(){
//        this.salt = getSalt();
//    }
//
//    private String getSalt(){
//        SecureRandom random = new SecureRandom();
//        byte bytes[] = new byte[20];
//        random.nextBytes(bytes);
//        String text = new String(bytes);
//        return text;
//    }
//
//    /**
//     *
//     * @param plainText
//     * @return encrypted text
//     * @throws Exception
//     */
//    public String encyrpt(String plainText) throws Exception{
//        //generate key
//        byte[] saltBytes = salt.getBytes("UTF-8");
//
//        SecretKeyFactory skf = SecretKeyFactory.getInstance(this.secretKeyFactoryAlgorithm);
//        PBEKeySpec spec = new PBEKeySpec(TOKEN.toCharArray(), saltBytes, this.pwdIterations, this.keySize);
//        SecretKey secretKey = skf.generateSecret(spec);
//        SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), keyAlgorithm);
//
//        //AES initialization
//        Cipher cipher = Cipher.getInstance(encryptAlgorithm);
//        cipher.init(Cipher.ENCRYPT_MODE, key);
//
//        //generate IV
//        this.ivBytes = cipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
//        byte[] encryptedText = cipher.doFinal(plainText.getBytes("UTF-8"));
//        return new Base64().encodeAsString(encryptedText);
//    }
//
//    /**
//     *
//     * @param encryptText
//     * @return decrypted text
//     * @throws Exception
//     */
//    public String decrypt(String encryptText) throws Exception {
//        byte[] saltBytes = salt.getBytes("UTF-8");
//        byte[] encryptTextBytes = new Base64().decode(encryptText);
//
//        SecretKeyFactory skf = SecretKeyFactory.getInstance(this.secretKeyFactoryAlgorithm);
//        PBEKeySpec spec = new PBEKeySpec(TOKEN.toCharArray(), saltBytes, this.pwdIterations, this.keySize);
//        SecretKey secretKey = skf.generateSecret(spec);
//        SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), keyAlgorithm);
//
//        //decrypt the message
//        Cipher cipher = Cipher.getInstance(encryptAlgorithm);
//        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(ivBytes));
//
//        byte[] decyrptTextBytes = null;
//        try {
//            decyrptTextBytes = cipher.doFinal(encryptTextBytes);
//        } catch (IllegalBlockSizeException e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        } catch (BadPaddingException e) {
//            e.printStackTrace();
//        }
//        String text = new String(decyrptTextBytes);
//        return text;
//    }
//}


import java.security.AlgorithmParameters;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class Encryption {

    public String encrypt(String word) throws Exception {
        byte[] ivBytes;
        String password="Hello";
        /*you can give whatever you want for password. This is for testing purpose*/
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        byte[] saltBytes = bytes;
        // Derive the key
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(),saltBytes,65556,256);
        SecretKey secretKey = factory.generateSecret(spec);
        SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");
        //encrypting the word
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secret);
        AlgorithmParameters params = cipher.getParameters();
        ivBytes =   params.getParameterSpec(IvParameterSpec.class).getIV();
        byte[] encryptedTextBytes =                          cipher.doFinal(word.getBytes("UTF-8"));
        //prepend salt and vi
        byte[] buffer = new byte[saltBytes.length + ivBytes.length + encryptedTextBytes.length];
        System.arraycopy(saltBytes, 0, buffer, 0, saltBytes.length);
        System.arraycopy(ivBytes, 0, buffer, saltBytes.length, ivBytes.length);
        System.arraycopy(encryptedTextBytes, 0, buffer, saltBytes.length + ivBytes.length, encryptedTextBytes.length);
        return new Base64().encodeToString(buffer);
    }
}