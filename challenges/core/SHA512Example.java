package challenges.core;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class SHA512Example {
    public static void main(String[] args) {
        String key = "my-key";

        try {
            // Create SHA-512 digest instance
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            // Compute hash bytes
            byte[] hashBytes = md.digest(key.getBytes(StandardCharsets.UTF_8));

            // Convert bytes → hex string (Java 17+ has HexFormat)
            String hashHex = HexFormat.of().formatHex(hashBytes);

            System.out.println("SHA-512 hash: " + hashHex);

            // If you need an integer (e.g., for consistent hashing ring):
            int hashInt = Math.abs(ByteBuffer.wrap(hashBytes).getInt()); 
            System.out.println("Integer value (for ring): " + hashInt);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-512 not supported", e);
        }
    }
}

