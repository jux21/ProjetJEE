<%-- 
    Document   : header
    Created on : 24 avr. 2017, 23:38:19
    Author     : Cécile
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd">  
  
<!-- Ne pas oublier cette ligne sinon tous les tags de la JSTL seront ignorés ! -->  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
   
        <header>
            <!--HEADER-->
            <nav class="nav-extended #7cb342 light-green darken-1" role="navigation">
                <div class="nav-wrapper">  
                     
                    <a href="/" class="brand-logo flow-text left">
                        <span class="flow-text">Lou Souleou</span>
                    </a>
                    
                    <!--session-->
                    <c:if test="${ empty sessionScope['userlogin']}">
                        
                        <form action="ServletLogin" method="post">  
                        <ul class="right">
                            <li>login :</li>
                             <li><input type="text" name="login_connexion"/></li>
                             <!--  <li>password :</li>
                               <li><input type="text" name="password"/></li>-->
                               <input type="hidden" name="action" value="connexion"/>
                                <li><a class="waves-effect waves-light btn"><input type="submit" value="connexion" name="connexion"/></a></li>
                        </ul>
                        </form>
                        
                    </c:if>
                    
                     <c:if test="${ !empty requestScope['userlogin']}">
                        
                        <form action="ServletLogout" method="post">  
                        <ul class="right hide-on-med-and-down">
                            
                               <input type="hidden" name="action" value="deconnexion"/>
                                <li><a href="${pageContext.request.contextPath}/index.jsp" class="waves-effect waves-light btn">Deconnexion</a></li>
                        </ul>
                        </form>
                        
                    </c:if>
                    <!--<ul class="tabs tabs-transparent">
                        <li class="tab"><a id="lien_menu_accueil" target="_self" href="/">Accueil</a></li>
                        <li class="tab"><a id="lien_menu_map" target="_self" href="/map">Consulter les données</a></li>
                        <li class="tab"><a id="lien_menu_list" target="_self" href="/list">Liste des monuments</a></li>
                    </ul>-->
                </div>
            </nav>
        </header>

 <!--Import jQuery before materialize.js -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/materialize.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>

<script>$(document).ready(function(){
    Materialize.updateTextFields();
  });</script>


 

