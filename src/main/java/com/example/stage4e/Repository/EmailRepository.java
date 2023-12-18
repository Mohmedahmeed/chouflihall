package com.example.stage4e.Repository;

import com.example.stage4e.Entities.Email;
import com.example.stage4e.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {
    List<Email> getAllByToEmail(String email);
}
