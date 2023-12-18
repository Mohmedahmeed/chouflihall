package com.example.projet.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.ArrayList;
@Data
@Entity

public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getPrixmin() {
        return prixmin;
    }

    public void setPrixmin(double prixmin) {
        this.prixmin = prixmin;
    }

    public double getPrixmax() {
        return prixmax;
    }

    public void setPrixmax(double prixmax) {
        this.prixmax = prixmax;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    //for define inside the column
    @Column(name = "Titre")
    protected String  titre;
    @Column(name = "Date")
    protected Date date;
    @Column(name = "Lieu")
    protected String lieu;
    @Column(name = "Details")
    protected String detail;
    @Column(name = "Numero de telephone")
    protected String phone;
    @Column(name = "Prix minimum")
    protected double prixmin;
    @Column(name = "Prix maximum")
    protected double prixmax;
    @Column(name = "Categorie")
    protected String categorie;

    public Annonce(Long id, String titre,Date date, String lieu, String detail,String phone,double prixmin,double prixmax,String categorie) {
        this.id=id;
        this.titre = titre;
        this.date = date;
        this.lieu = lieu;
        this.detail = detail;
        this.phone = phone;
        this.prixmin=prixmin;
        this.prixmax=prixmax;
        this.categorie=categorie;
    }
    public Annonce(){}


}
