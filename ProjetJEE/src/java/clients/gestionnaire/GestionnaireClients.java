/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients.gestionnaire;

import chambres.modeles.Chambre;
import clients.modeles.Client;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author jux
 */
@Stateless
public class GestionnaireClients {
    
    @PersistenceContext  
    private EntityManager em;
    
    
    public Client creeClient(String nom, String prenom, String heureArrivee, LocalDate jourArrivee, String chambre, LocalDate jourDepart, boolean aPaye, boolean estArrive, float prix) {  
        Client c = new Client(nom, prenom, heureArrivee, jourArrivee, jourDepart, aPaye, estArrive, prix); 
        Collection<Chambre> chambres;
        
        Query q = em.createQuery("SELECT c FROM Chambre c WHERE c.chambre ='"+chambre+"'"); 
        //"SELECT u FROM Utilisateur u WHERE u.login ='"+login+"'");
        //q.getResultList();
        
        //chambres.add((Chambre) );
        //c.setChambres((List<Chambre>) (Chambre) q.getResultList().get(0));
        
        em.persist(c);
        return c;  
    }
    
    public Collection<Client> getClientsCurrentlyInHouse() {  
        // Si le jour courant se situe entre le jour d'arrivée et le jour de départ
        Query q = em.createQuery("SELECT c FROM Client c WHERE CURRENT_DATE BETWEEN c.jourArrivee AND c.jourDepart");  
        System.out.println(q.getResultList());
        return q.getResultList();  
    }
    
    public void fuckyou() 
    {
        System.out.println("inserrrreeeeeeer client");
                
                Chambre c = new Chambre("simple");
                em.persist(c);
                c = new Chambre("zen");
                em.persist(c);
                c = new Chambre("swazi");
                em.persist(c);
                c = new Chambre("dor3");
                em.persist(c);
                c = new Chambre("dor4");
                em.persist(c);
                
                Utilisateur u = new Utilisateur("jux","jux");
                em.persist(u);
                u = new Utilisateur("cecile","cecile");
                em.persist(u);
    }
}
