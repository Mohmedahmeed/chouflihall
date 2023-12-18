package com.example.projet.controller;

import com.example.projet.entity.Annonce;
import com.example.projet.entity.Evaluation;
import com.example.projet.service.EvaluationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class EvaluationController {

    @Resource
    private EvaluationService EvaluationService;

    @GetMapping("/evaluation")
    @ResponseBody
    public Evaluation evaluerAnnonce(@RequestParam String titre) {
        Annonce annonce = new Annonce();
        annonce.setTitre(titre);

        return EvaluationService.evaluerAnnonce(annonce);
    }
}