/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients.modeles;

import chambres.modeles.Chambre;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
                   heureArrivee;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Chambre> chambres;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date jourArrivee,
                 jourDepart;
    
    /*@Temporal(javax.persistence.TemporalType.TIME)
    private Date heureArrivee;*/
    
    private boolean aPaye,
                    estArrive;

    public Client() {
    }

    public Client(String nom, String prenom, String heureArrivee, LocalDate jourArrivee, LocalDate jourDepart, boolean aPaye, boolean estArrive) {
        this.nom = nom;
        this.prenom = prenom;
        this.heureArrivee = heureArrivee;
        this.jourArrivee = java.sql.Date.valueOf(jourArrivee);
        this.jourDepart = java.sql.Date.valueOf(jourDepart);
        this.aPaye = aPaye;
        this.estArrive = estArrive;
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

    public String getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(String heureArrivee) {
        this.heureArrivee = heureArrivee;
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

    public boolean isEstArrive() {
        return estArrive;
    }

    public void setEstArrive(boolean estArrive) {
        this.estArrive = estArrive;
    }
    
    public List<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(List<Chambre> chambres) {
        this.chambres = chambres;
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
