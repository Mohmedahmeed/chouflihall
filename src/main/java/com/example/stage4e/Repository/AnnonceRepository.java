package com.example.stage4e.Repository;


import com.example.stage4e.Entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce,Integer> {
}
