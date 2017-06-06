<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd">  
  
<!-- Ne pas oublier cette ligne sinon tous les tags de la JSTL seront ignorés ! -->  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <!--Favicons-->
        <link rel="apple-touch-icon" sizes="57x57" href="${pageContext.request.contextPath}/resources/favicons/apple-icon-57x57.png">
        <link rel="apple-touch-icon" sizes="60x60" href="${pageContext.request.contextPath}/resources/favicons/apple-icon-60x60.png">
        <link rel="apple-touch-icon" sizes="72x72" href="${pageContext.request.contextPath}/resources/favicons/apple-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/favicons/apple-icon-76x76.png">
        <link rel="apple-touch-icon" sizes="114x114" href="${pageContext.request.contextPath}/resources/favicons/apple-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="120x120" href="${pageContext.request.contextPath}/resources/favicons/apple-icon-120x120.png">
        <link rel="apple-touch-icon" sizes="144x144" href="${pageContext.request.contextPath}/resources/favicons/apple-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="152x152" href="${pageContext.request.contextPath}/resources/favicons/apple-icon-152x152.png">
        <link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/resources/favicons/apple-icon-180x180.png">
        <link rel="icon" type="image/png" sizes="192x192"  href="${pageContext.request.contextPath}/resources/favicons/android-icon-192x192.png">
        <link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/resources/favicons/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath}/resources/favicons/favicon-96x96.png">
        <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/resources/favicons/favicon-16x16.png">
        <link rel="manifest" href="/medias/favicons/manifest.json">
       
        
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        
        <!--Import materialize.css -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/materialize.css" /> 

        <!--Let browser know website is optimized for mobile -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      
        <!--Custom stylesheet -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />  
        
        <title>Gestionnaire d'utilisateurs</title>  
    </head>  
    <body>
         <header>
            <!--HEADER-->
            <nav class="nav-extended #7cb342 light-green darken-1" role="navigation">
                <div class="nav-wrapper">  
                     
                    <a href="/" class="brand-logo flow-text left">
                        <span class="flow-text">Lou Souleou</span>
                    </a>
                </div></nav></header>
        <main>
            <div class="row">
        <div>Le login n'existe pas dans la base de données.</div>
            </div>
            <div class="row">
        <a href="index.jsp" class="waves-effect waves-light btn">Retour vers la page de connexion</a>
            </div>
        </main>
        </body>
</html>
