package com.altima.validation.utilis;

import com.altima.validation.App;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;

public class HashPassword implements PasswordEncoder {
    public static String getHash(String pass) throws NoSuchAlgorithmException {
        // get hash to bits
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                pass.getBytes(StandardCharsets.UTF_8));

        // convert hash to string
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < encodedhash.length; i++) {
            String hex = Integer.toHexString(0xff & encodedhash[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public String encode(CharSequence rawPassword) {
        String hexString = "";
        try {
            hexString = getHash(rawPassword.toString());
        } catch (NoSuchAlgorithmException algExp) {
            App.APPLOGGER.log(Level.SEVERE, algExp.getMessage());
        }

        return hexString;
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        boolean ret = false;
        if (encodedPassword != null && encodedPassword.length() != 0) {
            if (encode(rawPassword).equals(encodedPassword)) {
                ret = true;
                App.APPLOGGER.log(Level.INFO, "Password matches");
            } else {
                App.APPLOGGER.log(Level.SEVERE, "Password don't match");
            }
        } else {
            App.APPLOGGER.log(Level.SEVERE, "Empty encoded password");

        }
        return ret;
    }


}
