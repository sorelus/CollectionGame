package com.altima.validation.utilis;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class SimpleEncode {

    public String encode(String message){
        return Base64.getUrlEncoder().encodeToString(message.getBytes());
    }

    public String decode(String encode){
        byte[] decodedBytes = Base64.getUrlDecoder().decode(encode);
        return  new String(decodedBytes);
    }

}
