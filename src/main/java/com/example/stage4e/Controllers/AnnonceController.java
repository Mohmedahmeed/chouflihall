package com.example.stage4e.Controllers;


import com.example.stage4e.Entities.Annonce;
import com.example.stage4e.Service.AnnonceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/annonce")
public class AnnonceController {
    @Autowired
    AnnonceServiceImpl annonceService;

    @PostMapping("/addAnnonce/{IdUser}")
    public ResponseEntity<?> addPublication(@RequestBody Annonce annonce , @PathVariable Integer IdUser) {
        return new ResponseEntity<>(annonceService.addAnnonce(IdUser, annonce), HttpStatus.valueOf(200));
    }
}
