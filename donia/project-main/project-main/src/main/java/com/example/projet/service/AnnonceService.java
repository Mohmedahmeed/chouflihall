package com.example.projet.service;

import com.example.projet.entity.Annonce;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AnnonceService {

    Annonce createAnnonce(Annonce annonce);

    List<Annonce> getAllAnnonces();

    List<Annonce> Recherche(String annonceCategorie,String annonceLieu);

    Annonce updateAnnonce(Long id,Annonce annonce);

    void deleteAnnonce(Long annonceId);
}
