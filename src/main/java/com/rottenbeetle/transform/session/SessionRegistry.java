package com.rottenbeetle.transform.session;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class SessionRegistry {
    private static final Map<String, String> SESSIONS = new HashMap<>();
    private final ValueOperations<String, String> redisSessionStorage;

    public SessionRegistry(RedisTemplate<String, String> redisTemplate) {
        redisSessionStorage = redisTemplate.opsForValue();

    }

    public String registerSession(String username) {
        if (username == null) {
            throw new RuntimeException("Username needs to be provided");
        }
        final String sessionId = generateSessionId();

        try {
            redisSessionStorage.set(sessionId, username);
        } catch (Exception e) {
            e.printStackTrace();
            SESSIONS.put(sessionId, username);
        }

        return sessionId;
    }

    public String getUsernameForSession(String sessionId) {
        try {
            return redisSessionStorage.get(sessionId);
        } catch (Exception e) {
            e.printStackTrace();
            return SESSIONS.get(sessionId);
        }
    }

    private String generateSessionId() {
        return new String(
                Base64.getEncoder().encode(
                        UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8)));
    }
}
