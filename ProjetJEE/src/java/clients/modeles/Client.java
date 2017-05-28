/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients.modeles;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author jux
 */
@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nom,
                   prenom,
                   chambre;
    
    private int numeroLit;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date jourArrivee,
                 jourDepart;
    
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date heureArrivee;
    
    private boolean aPaye,
                    aRenduLesClef;

    public Client() {
    }

    public Client(String nom, String prenom, Date heureArrivee, Date jourArrivee, String chambre, int numeroLit, Date jourDepart, boolean aPaye, boolean aRenduLesClef) {
        this.nom = nom;
        this.prenom = prenom;
        this.heureArrivee = heureArrivee;
        this.jourArrivee = jourArrivee;
        this.chambre = chambre;
        this.numeroLit = numeroLit;
        this.jourDepart = jourDepart;
        this.aPaye = aPaye;
        this.aRenduLesClef = aRenduLesClef;
    }

    public int getNumeroLit() {
        return numeroLit;
    }

    public void setNumeroLit(int numeroLit) {
        this.numeroLit = numeroLit;
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

    public Date getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(Date heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public String getChambre() {
        return chambre;
    }

    public void setChambre(String chambre) {
        this.chambre = chambre;
    }

    public Date getJourArrivee() {
        return jourArrivee;
    }

    public void setJourArrivee(Date jourArrivee) {
        this.jourArrivee = jourArrivee;
    }

    public Date getJourDepart() {
        return jourDepart;
    }

    public void setJourDepart(Date jourDepart) {
        this.jourDepart = jourDepart;
    }

    public boolean isaPaye() {
        return aPaye;
    }

    public void setaPaye(boolean aPaye) {
        this.aPaye = aPaye;
    }

    public boolean isaRenduLesClef() {
        return aRenduLesClef;
    }

    public void setaRenduLesClef(boolean aRenduLesClef) {
        this.aRenduLesClef = aRenduLesClef;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clients.modeles.Client[ id=" + id + " ]";
    }
    
}
