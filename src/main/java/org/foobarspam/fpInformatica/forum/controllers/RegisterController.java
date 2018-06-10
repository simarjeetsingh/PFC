package org.foobarspam.fpInformatica.forum.controllers;

import org.foobarspam.fpInformatica.forum.dto.UserDTO;
import org.foobarspam.fpInformatica.forum.entities.User;
import org.foobarspam.fpInformatica.forum.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Objects;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class RegisterController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterController(@Lazy UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PostMapping("register")
    public String registerUser(@Valid @RequestBody UserDTO dto) {
        User user = new User();
        if (userRepository.getUserByUsername(dto.getUsername()) == null) {
            user.setUsername(dto.getUsername());
            if (Objects.equals(dto.getIntroduction(), ""))
                user.setIntroduction(null);
            else
            user.setIntroduction(dto.getIntroduction());
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            user.setCreatedDate(LocalDateTime.now());
            userRepository.save(user);
            return "user successfully added";
        } else
            return "something went wrong";
    }
}