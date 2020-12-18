package com.example.gestionconference.dto;

public class UserDetails {

    public int ID ;
    public String nom ;
    public String prenom;
    public String email;
    public String adress;
    public String professioon;
    public String password;

    public UserDetails() { }

    public UserDetails(int ID, String nom, String prenom, String email, String adress, String professioon, String password) {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adress = adress;
        this.professioon = professioon;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getProfessioon() {
        return professioon;
    }

    public void setProfessioon(String professioon) {
        this.professioon = professioon;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
