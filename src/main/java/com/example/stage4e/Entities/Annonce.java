package com.example.stage4e.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Annonce implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAnnonce; // Clé primaire
    private String sujet ;
    private  String contenu;
    private Double rating= (double) 0;

    @JsonIgnore
    @ManyToOne
    User publierPar;


    @OneToMany(mappedBy = "annonce", cascade = CascadeType.ALL)
    private List<Rating> ratings;







}
