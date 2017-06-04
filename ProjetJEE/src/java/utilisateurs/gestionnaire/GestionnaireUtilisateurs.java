/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.gestionnaire;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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
public class GestionnaireUtilisateurs {

    @PersistenceContext  
    private EntityManager em;
    
    public Utilisateur authentificationFromDB(String login, String password)
    {
        return null;
    }
     
  
    public Utilisateur creeUtilisateur(String login, String password) { 
        Utilisateur u;
        u = new Utilisateur(login, password);
        em.persist(u);  
        return u;  
    }  
    
   
  
    public Collection<Utilisateur> getAllUsers() {  
        // Exécution d'une requête équivalente à un select *  
        Query q = em.createQuery("SELECT u from Utilisateur u"); 
        q.setFirstResult(0);
        return q.getResultList();
    }
    
    // On récupère le nombre de tuple dans la table et le nombre de pagination à faire
    public long getNumberOfUsers() {  
        ArrayList<Object> infos = new ArrayList<Object>();
        Query q = em.createQuery("SELECT COUNT(u) from Utilisateur u");   
        return (Long)q.getSingleResult();
    }
    
   
    
    public Collection<Utilisateur> getUsersPaginated(int start, int end)
    {
        Query q = em.createQuery("SELECT u from Utilisateur u"); 
        q.setFirstResult(start-1);
        q.setMaxResults(end-start+1);
        return q.getResultList();
    }
    
    public Collection<Utilisateur> getOneUserByLogin(String login) { 
        Query q = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login ='"+login+"'");  
        return q.getResultList(); 
    }
    
    public Collection<Utilisateur> getOneUserByLoginAndLastName(String login, String lastname) {  
        Query q = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login ='"+login+"'");  
        return q.getResultList(); 
    }
    
    public int updateUtilisateur(String nom, String prenom, String login) {
        // Exécution d'une requête équivalente à un update where login    
        Query q = em.createQuery("UPDATE Utilisateur u SET u.lastname = '"+nom+"', u.firstname = '"+prenom+"' WHERE u.login = '"+login+"'");
        return q.executeUpdate();
    }
    
    public int deleteUser(String login) {
        // Exécution d'une requête équivalente à un delete from where login    
        Query q = em.createQuery("DELETE FROM Utilisateur u WHERE u.login = '"+login+"'");
        return q.executeUpdate();
    }
    
    // Add business logic below. (Right-click in editor and choose  
    // "Insert Code > Add Business Method")  

 
}
