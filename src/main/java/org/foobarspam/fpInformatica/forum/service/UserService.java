package org.foobarspam.fpInformatica.forum.service;

import org.foobarspam.fpInformatica.forum.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

//    @Override
//    public void create(User user) {
//        user.setUsername(username);
//        if (Objects.equals(introduction, ""))
//            user.setIntroduction(null);
//        else
//            user.setIntroduction(introduction);
//        user.setPassword(passwordEncoder.encode(password));
//        user.setCreatedDate(LocalDateTime.now());
//        userRepository.save(user);
//    }
}
