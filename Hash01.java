import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HexFormat;
import java.util.Scanner;

public class Hash01 {

    public static void main(String[] args)
        throws NoSuchAlgorithmException {

        Scanner sc = new Scanner(System.in);

        String textIn = "";

        System.out.print("Entra text: ");

        while (textIn.isEmpty()) {
            textIn = sc.nextLine();
        }

        // string a un array de bytes
        byte[] bytesIn = textIn.getBytes(StandardCharsets.UTF_8);

        // classe hash
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");

        // calcular hash
        byte[] hashResult = sha256.digest(bytesIn);

        //  hash a hexadecimal 
        String textOut = HexFormat.of().withUpperCase()
                .formatHex(hashResult);

        System.out.println("Hash: " + textOut);

        sc.close();
    }

    // Hash d'un array de bytes (serveix per fitxers)
    public static String sha256(byte[] dades) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(dades);
            return HexFormat.of().withUpperCase().formatHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 no disponible");
        }
    }

    // Hash d'un text
    public static String sha256(String text) {
        return sha256(text.getBytes(StandardCharsets.UTF_8));
    }

    // Salt aleatoria de 16 bytes
    public static byte[] generarSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    // Hash de contrasenya + salt
    public static String hashAmbSalt(String contrasenya, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            md.update(contrasenya.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().withUpperCase().formatHex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 no disponible");
        }
    }

    // mostrar la salt en hexadecimal
    public static String saltAHex(byte[] salt) {
        return HexFormat.of().withUpperCase().formatHex(salt);
    }
}
