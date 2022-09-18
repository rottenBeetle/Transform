package com.rottenbeetle.transform;

import com.rottenbeetle.transform.model.Role;
import com.rottenbeetle.transform.model.User;
import com.rottenbeetle.transform.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Column;
import java.util.Collections;

@SpringBootApplication
public class TransformApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransformApplication.class, args);
    }

}

