package com.example.stage4e.Service;

import com.example.stage4e.Entities.ConfirmationToken;
import com.example.stage4e.Entities.User;
import com.example.stage4e.Repository.ConfirmationRepository;
import com.example.stage4e.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ConfirmationServiceImp {
    @Autowired

    private ConfirmationRepository confirmationTokenRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
    public void expiredAt(ConfirmationToken token){
        User user=token.getAppUser();
        if (token.getExpiresAt().isAfter(token.getCreatedAt().plusMinutes(15))) {
            userRepository.delete(user);
        }
    }

}
