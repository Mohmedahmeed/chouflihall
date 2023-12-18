package com.example.projet.service;

import com.example.projet.entity.Annonce;
import com.example.projet.entity.Evaluation;
import org.springframework.stereotype.Service;

@Service
public class EvaluationService {

    public Evaluation evaluerAnnonce(Annonce annonce) {
        Evaluation evaluation = new Evaluation();

        evaluation.setQualiteDuBien(calculerQualiteDuBien(annonce));
        evaluation.setProximiteServices(calculerProximiteServices(annonce));
        evaluation.setNoteGlobale(calculerNoteGlobale(evaluation));

        return evaluation;
    }

    private double calculerQualiteDuBien(Annonce annonce) {
        // Implémenter la logique pour calculer la qualité du bien
        return 0;
    }

    private double calculerProximiteServices(Annonce annonce) {
        // Implémenter la logique pour calculer la proximité des services
        return 0;
    }

    private double calculerNoteGlobale(Evaluation evaluation) {
        // Implémenter la logique pour calculer la note globale
        return 0;
    }
}