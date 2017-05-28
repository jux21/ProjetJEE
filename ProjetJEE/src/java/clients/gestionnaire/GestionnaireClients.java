/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients.gestionnaire;

import clients.modeles.Client;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jux
 */
@Stateless
public class GestionnaireClients {
    
    @PersistenceContext  
    private EntityManager em;
    
    
    public Client creeUtilisateur(String nom, String prenom, Date heureArrivee, Date jourArrivee, String chambre, int numeroLit, Date jourDepart, boolean aPaye, boolean aRenduLesClef) {  
        Client c = new Client(nom, prenom, heureArrivee, jourArrivee, chambre, numeroLit, jourDepart, aPaye, aRenduLesClef); 
        em.persist(c);  
        return c;  
    }
    
    public Collection<Client> getClientsCurrentlyInHouse() {    
        Query q = em.createQuery("");  
        return q.getResultList();  
    }
}
