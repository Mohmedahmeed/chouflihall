package com.example.projet.service;

import com.example.projet.entity.Annonce;
import com.example.projet.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnonceServiceImp implements AnnonceService {

    @Autowired
    private AnnonceRepository annonceRepository;



    @Override
    public Annonce createAnnonce(Annonce annonce) {

        return annonceRepository.save(annonce);
    }

    @Override
    public List<Annonce> getAllAnnonces() {

        return annonceRepository.findAll();
    }

    @Override
    public List<Annonce> Recherche(String categorie,String lieu){

        List<Annonce> anc=getAllAnnonces();
        List<Annonce> anr=getAllAnnonces();
        for(Annonce p:anc){
            if(!(p.getLieu().equals(lieu))|| !(p.getCategorie().equals(categorie)))
                anr.remove(p);
        }
        return anr;
    }

    @Override
    public Annonce updateAnnonce(Long id,Annonce annonce) {
        Optional<Annonce> oc = annonceRepository.findById(id);
        if(oc.isPresent()) {
            Annonce c=oc.get();
            c.setId(id);
            c.setTitre(annonce.getTitre());
            c.setDate(annonce.getDate());
            c.setLieu(annonce.getLieu());
            c.setDetail(annonce.getDetail());
            c.setPhone(annonce.getPhone());
            c.setPrixmax(annonce.getPrixmax());
            c.setPrixmin(annonce.getPrixmin());
            c.setCategorie(annonce.getCategorie());
            return annonceRepository.save(c);
        }
        return null;
    }

    @Override
    public void deleteAnnonce(Long annonceId) {

        annonceRepository.deleteById(annonceId);
    }
}
