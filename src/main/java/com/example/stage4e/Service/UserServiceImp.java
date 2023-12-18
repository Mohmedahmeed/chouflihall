package com.example.stage4e.Service;

import com.example.stage4e.Entities.User;
import com.example.stage4e.Entities.ConfirmationToken;
import com.example.stage4e.Interfaces.UserServiceInterface;
import com.example.stage4e.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;


@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImp implements UserDetailsService, UserServiceInterface {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConfirmationServiceImp confirmationTokenService;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }


    public int enableAppUser(String email) {
        return userRepository.enableAppUser(email);
    }


    public String signUpUser(User appUser) {

        Boolean userExists = userRepository.findByEmail(appUser.getEmail()).isPresent();

        if (userExists) {


            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        userRepository.save(appUser);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    public Boolean ifEmailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public User editUser(User user) {
        Integer id = user.getUserId();
        User usr = userRepository.getById(id);
        usr.setUserId(user.getUserId());
        usr.setEnabled(user.getEnabled());
        usr.setLocked(user.getLocked());
        userRepository.saveAndFlush(usr);
        return usr;
    }



}






