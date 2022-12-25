package com.rottenbeetle.transform.controllers;

import com.rottenbeetle.transform.model.Response;
import com.rottenbeetle.transform.model.User;
import com.rottenbeetle.transform.session.InMemorySessionRegistry;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final InMemorySessionRegistry sessionRegistry;
    public AuthController(AuthenticationManager authenticationManager, InMemorySessionRegistry sessionRegistry) {
        this.authenticationManager = authenticationManager;
        this.sessionRegistry = sessionRegistry;
    }

    @PostMapping(value = "/login", consumes={"application/json"})
    public ResponseEntity<Response> login(@RequestBody User user){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        final String sessionId = sessionRegistry.registerSession(user.getUsername());
        Response response = new Response();
        response.setSessionId(sessionId);

        return ResponseEntity.ok(response);
    }
}

