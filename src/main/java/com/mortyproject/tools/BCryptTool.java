package com.mortyproject.tools;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Profile("hash")
@Component
public class BCryptTool {
    public static void main(String[] args) {
        String raw = args.length > 0 ? args[0] : "changeme";
        System.out.println(new BCryptPasswordEncoder().encode(raw));
    }
}
