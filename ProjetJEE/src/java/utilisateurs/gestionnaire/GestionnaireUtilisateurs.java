/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.gestionnaire;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
