/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients.gestionnaire;

import chambres.modeles.Chambre;
import clients.modeles.Client;
import java.util.ArrayList;
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
    
    
    public Client creeUtilisateur(String nom, String prenom, Date heureArrivee, Date jourArrivee, String chambre, Date jourDepart, boolean aPaye, boolean estArrive) {  
        Client c = new Client(nom, prenom, heureArrivee, jourArrivee, jourDepart, aPaye, estArrive); 
        ArrayList<Chambre> chambres = new ArrayList<Chambre>();
        chambres.add(new Chambre(chambre));
        c.setChambres(chambres);
        
        em.persist(c);
        return c;  
    }
    
    public Collection<Client> getClientsCurrentlyInHouse() {    
        Query q = em.createQuery("");  
        return q.getResultList();  
    }
}
