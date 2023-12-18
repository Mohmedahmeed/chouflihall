package com.example.projet.controller;

import com.example.projet.entity.Annonce;
import com.example.projet.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annonce")
public class AnnonceController {
        private AnnonceService annonceService;


    @Autowired
    public AnnonceController(AnnonceService annonceService) {

        this.annonceService = annonceService;
    }
        // build create User REST API
        @PostMapping
        public ResponseEntity<Annonce> createAnnonce(@RequestBody Annonce annonce){
            Annonce savedAnnonce = annonceService.createAnnonce(annonce);
            return new ResponseEntity<>(savedAnnonce,HttpStatus.OK);
        }

        // build get user by id REST API
        @GetMapping("{categorie}/{lieu}")
        public ResponseEntity<List<Annonce>> Recherche(@PathVariable("categorie") String annonceCategorie,@PathVariable("lieu") String annonceLieu){
            List<Annonce> annonce =annonceService.Recherche(annonceCategorie,annonceLieu);
            if(annonce!=null)
                return new ResponseEntity<>(annonce, HttpStatus.OK);
            else
                return new ResponseEntity<>(null, HttpStatus.OK);

        }

        // Build Get All Users REST API
        @GetMapping
        public ResponseEntity<List<Annonce>> getAllAnnonce(){
            List<Annonce> annonces = annonceService.getAllAnnonces();
            return new ResponseEntity<>(annonces, HttpStatus.OK);
        }

        // Build Update User REST API
        @PutMapping("{id}")
        public ResponseEntity<Annonce> updateAnnonce(@PathVariable("id") Long annonceId, @RequestBody Annonce annonce){
            Annonce updatedAnnonce = annonceService.updateAnnonce(annonceId,annonce);
            return new ResponseEntity<>(updatedAnnonce, HttpStatus.OK);
        }

        // Build Delete User REST API
        @DeleteMapping("{id}")
        public String deleteAnnonce(@PathVariable("id") Long annonceId){
            annonceService.deleteAnnonce(annonceId);
            return "Deleted Successfully";
        }
    }

