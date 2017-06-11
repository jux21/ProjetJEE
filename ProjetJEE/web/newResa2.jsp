<%-- 
    Document   : newResa2
    Created on : 11 juin 2017, 16:59:43
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd">  
  
<!-- Ne pas oublier cette ligne sinon tous les tags de la JSTL seront ignorés ! -->  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="jourA" value="${requestScope['jourA']}"/>
        <c:set var="jourD" value="${requestScope['jourD']}"/>
        <c:set var="apaye" value="${requestScope['apaye']}"/>
       
        <c:set var="estarrive" value="${requestScope['estarrive']}"/>
        <c:set var="nom" value="${requestScope['nom']}"/>
        <c:set var="prenom" value="${requestScope['prenom']}"/>
       
        <c:set var="heureA" value="${requestScope['heureA']}"/>
        <c:set var="prix" value="${requestScope['prix']}"/>
        <c:set var="chambre" value="${requestScope['chambre']}"/>
        
    <div class="row">
    <form class="col s12" action="ServletClients" method="get">
         <div class="row">
        <div class="input-field col s12">
            <h2>Chambre</h2>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input value="${chambre}" id="chambre" name="chambre" type="text" class="validate">
          <label for="chambre">Chambre</label>
        </div>
        <div class="input-field col s12">
          <input value="${prenom}" id="first_name" name="first_name" type="text" class="validate">
          <label for="first_name">First Name</label>
        </div>
        <div class="input-field col s12">
          <input value="${nom}" id="last_name" name="last_name" type="text" class="validate">
          <label for="last_name">Last Name</label>
        </div>
      </div>
     
      <div class="row">
           <div class="input-field col s12">
            <label for="heureA">Heure d'arrivée</label>    
        </div>
          </div>
          <div class="row">
        <div class="input-field col s12">         
          <input value="${heureA}" type="time" name="heureA">    
        </div>
      </div>
        
        <div class="row">
           <div class="input-field col s12">
            <label for="jourA">Jour d'arrivé</label>    
        </div>
          </div>
          <div class="row">
        <div class="input-field col s12">         
          <input value="${jourA}" type="date" name="jourA">    
        </div>
      </div>
         <div class="row">
           <div class="input-field col s12">
            <label for="jourD">Jour de départ</label>    
        </div>
          </div>
          <div class="row">
        <div class="input-field col s12">         
          <input value="${jourD}" type="date" name="jourD">    
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input value="${prix}" id="prix" name="prix" type="number" step="0.01" class="validate">
          <label for="prix">Prix</label>
        </div>
      </div>        
      <!-- Switch -->
      <div class="row">
        <div class="input-field col s12">
      <label for="estarrive">Est arrivé</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
            <div class="switch">
              <label>
                Non
                <input checked="${estarrive}" name="estarrive" type="checkbox">
                <span class="lever"></span>
                Oui
              </label>
            </div>
        </div>
      </div>
      <!-- Switch -->
      <div class="row apayer">
        <div class="input-field col s12">
      <label for="apaye">A payé</label>
        </div></div>
      <div class="row">
        <div class="input-field col s12">
            <div class="switch">
              <label>
                Non
                <input checked="${apaye}" name="apaye" type="checkbox">
                <span class="lever"></span>
                Oui
              </label>
            </div>
        </div>
      </div>
      <div class="row submitnewresa">
        <div class="input-field col s12">
            <input type="hidden" name="action" value="insererClient"/>  
            <input type="submit" value="Ajouter" name="submit"/>
            <a href="ServletUsers?action=connexion" class="waves-effect waves-teal btn-flat">Retour</a>     
        </div>
       </div>
    </form>
  </div>
          
          <script>
</script>
