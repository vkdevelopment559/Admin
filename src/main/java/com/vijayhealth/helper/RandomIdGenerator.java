package com.vijayhealth.helper;

import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class RandomIdGenerator {

    public static String RandomDigitGenerator (){
        Random random = new Random();
        // Ensures it's always 9 digits
        return String.valueOf(100000000 + random.nextInt(900000000));
    }
}
