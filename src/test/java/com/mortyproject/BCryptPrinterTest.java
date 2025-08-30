package com.mortyproject;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPrinterTest {
    @Test
    void printHash() {
        String raw = "changeme";
        String hash = new BCryptPasswordEncoder().encode(raw);
        System.out.println("BCrypt: " + hash);
    }
}