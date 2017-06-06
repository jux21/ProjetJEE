<%--  
    Document   : index  
    Created on : 16 sept. 2009, 16:54:32  
    Author     : michel buffa  
    Debug glassFish port occupied : netstat -aon | find ":80" | find "LISTENING"
--%>  
  
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd">  
  
<!-- Ne pas oublier cette ligne sinon tous les tags de la JSTL seront ignorés ! -->  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
        <meta name="msapplication-TileColor" content="#ffffff">
        <meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
        <meta name="theme-color" content="#ffffff">
        
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
    
          <c:if test="${empty requestScope['userlogin']}">
         
            <jsp:include page="header.jsp"/> 

        </c:if>
  

        <!-- Message qui s'affiche lorsque la page est appelé avec un paramètre http message -->  
         


    <main>
        
            <c:if test="${param['action'] == 'datepicker'}" >  
                <c:set var="date" value="${requestScope['date']}"/>
                <section>
             <h2>Planning du ${date}</h2>
                </section>
         </c:if>
             
         <c:if test="${param['action'] == 'chercherParLogin'}" >  
             <section>
             <h2>Détail de l'utilisateur </h2>  
             <section>
         </c:if>
        
        <c:if test="${param['action'] == 'newResa'}">
              <jsp:include page="newResa.jsp"/> 
         </c:if>
        
             <c:if test="${(param['action'] == 'connexion') || (param['action'] == 'datepicker') || (param['action'] == 'suivant')}">
        
     
        
    
        
        
        <c:set var="total" value="${requestScope['month']}"/>
        <c:set var="jour" value="${requestScope['jour']}"/>
        <c:set var="jourNb" value="${requestScope['jourNb']}"/>
       
        <c:set var="total2" value="${requestScope['month2']}"/>
        <c:set var="jour2" value="${requestScope['jour2']}"/>
        <c:set var="jourNb2" value="${requestScope['jourNb2']}"/>
       
        <c:set var="total3" value="${requestScope['month3']}"/>
        <c:set var="jour3" value="${requestScope['jour3']}"/>
        <c:set var="jourNb3" value="${requestScope['jourNb3']}"/>
        
        <c:set var="totalM2" value="${requestScope['monthM2']}"/>
        <c:set var="jourM2" value="${requestScope['jourM2']}"/>
        <c:set var="jourNbM2" value="${requestScope['jourNbM2']}"/>
        
        <c:set var="totalM3" value="${requestScope['monthM3']}"/>
        <c:set var="jourM3" value="${requestScope['jourM3']}"/>
        <c:set var="jourNbM3" value="${requestScope['jourNbM3']}"/>
        
        <c:set var="totalM4" value="${requestScope['monthM4']}"/>
        <c:set var="jourM4" value="${requestScope['jourM4']}"/>
        <c:set var="jourNbM4" value="${requestScope['jourNbM4']}"/>
        
        <c:set var="dateF" value="${requestScope['currentdate']}"/>
        
        <section>
            <div class="agenda">
                <h2>Planning du ${dateF}</h2>
                <div class="row suivprec">
                   
                <a href="ServletAgenda?currentdate=${dateF}&action=precedent" class="left">Précédent</a>
                <a href="ServletAgenda?currentdate=${dateF}&action=suivant" class="right">Suivant</a>
                </div>
            <div class="row jours">
              <div class="col l2 hide-on-med-and-down">
            <!-- Promo Content 1 goes here -->
            <h6>${jourM4}<span class="nJour">${jourNbM4}</span> <span class="moi">${totalM4}</span></h6>
          </div>
          <div class ="col l2 hide-on-med-and-down">
           <h6>${jourM3}<span class="nJour">${jourNbM3}</span> <span class="moi">${totalM3}</span></h6>
          
          </div>
               <div class="col l2 m3 hide-on-small-only">
           <h6>${jourM2}<span class="nJour">${jourNbM2}</span> <span class="moi">${totalM2}</span></h6>
          </div>
               <div class="col l2 m3 s12 ">
            <h6>${jour}<span class="nJour">${jourNb}</span> <span class="moi">${total}</span></h6>
          </div>
               <div class="col l2 m3 hide-on-small-only">
           <h6>${jour2}<span class="nJour">${jourNb2}</span> <span class="moi">${total}</span></h6>
          
          </div>
               <div class="col l2 hide-on-med-and-down">
           <h6>${jour3}<span class="nJour">${jourNb3}</span> <span class="moi">${total3}</span></h6>
               </div>
         </div>
           <div class="row">

              
          
          <div class="col l2 m3 s12">
            <!-- Promo Content 1 goes here -->
            <div class="divider"></div>
                <a class="waves-effect waves-teal btn">
                    <div class="section">
                        <h5>Simple</h5>
                        <c:forEach var="u" items="${requestScope['listeDesClientsSimpleTodayMoins3']}">  
                        <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p>>  
                        </c:forEach>
                    </div>
                </a>
                <div class="divider"></div>
                <a class="waves-effect waves-teal btn"><div class="section">
                  <h5>Zen</h5>
                  <c:forEach var="u" items="${requestScope['listeDesClientsZenTodayMoins3']}">  
                        <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p>
                        </c:forEach>
                </div></a>
                <div class="divider"></div>
                <a class="waves-effect waves-teal btn"><div class="section">
                  <h5>Swazi</h5>
                  <c:forEach var="u" items="${requestScope['listeDesClientsSwaziTodayMoins3']}">  
                        <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p>
                        </c:forEach>
                </div></a>
                <div class="divider"></div>
                
                  <!--<h5>Dor3</h5>
                  
                  <a class="waves-effect waves-teal btn"><div class="section">
                          <h6>Lit 1</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 2</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 3</h6>
                  <p></p></div></a>
                <div class="divider"></div>
                
                  <h5>Dor4</h5>
				  <a class="waves-effect waves-teal btn"><div class="section">
                          <h6>Lit 1</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 2</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 3</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                          <h6>Lit 4</h6>
                  <p></p></div></a>-->
                </div>
          
         
          <div class="col l2 m3 s12">
            <!-- Promo Content 1 goes here -->
            <div class="divider"></div>
                <a class="waves-effect waves-teal btn">
                    <div class="section">
                        <h5>Simple</h5>
                        <c:forEach var="u" items="${requestScope['listeDesClientsSimpleTodayMoins2']}">  
                        <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p>  
                        </c:forEach>
                    </div>
                </a>
                <div class="divider"></div>
                <a class="waves-effect waves-teal btn"><div class="section">
                  <h5>Zen</h5>
                  <c:forEach var="u" items="${requestScope['listeDesClientsZenTodayMoins2']}">  
                        <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p> 
                        </c:forEach>
                </div></a>
                <div class="divider"></div>
                <a class="waves-effect waves-teal btn"><div class="section">
                  <h5>Swazi</h5>
                  <c:forEach var="u" items="${requestScope['listeDesClientsSwaziTodayMoins2']}">  
                        <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p>  
                        </c:forEach>
                </div></a>
                <div class="divider"></div>
                
                  <!--<h5>Dor3</h5>
                  
                  <a class="waves-effect waves-teal btn"><div class="section">
                          <h6>Lit 1</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 2</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 3</h6>
                  <p></p></div></a>
                <div class="divider"></div>
                
                  <h5>Dor4</h5>
				  <a class="waves-effect waves-teal btn"><div class="section">
                          <h6>Lit 1</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 2</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 3</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                          <h6>Lit 4</h6>
                  <p></p></div></a>-->
                </div>
          
          
               <div class="col l2 m3 hide-on-small-only">
            <!-- Promo Content 1 goes here -->
            <div class="divider"></div>
                <a class="waves-effect waves-teal btn"><div class="section">
                  <h5>Simple</h5>
                  <c:forEach var="u" items="${requestScope['listeDesClientsSimpleTodayMoins1']}">  
                        <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p>  
                        </c:forEach>
                    </div></a>
                <div class="divider"></div>
                <a class="waves-effect waves-teal btn"><div class="section">
                  <h5>Zen</h5>
                  <c:forEach var="u" items="${requestScope['listeDesClientsZenTodayMoins1']}">  
                        <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p>  
                        </c:forEach>
                </div></a>
                <div class="divider"></div>
                <a class="waves-effect waves-teal btn"><div class="section">
                  <h5>Swazi</h5>
                  <c:forEach var="u" items="${requestScope['listeDesClientsSwaziTodayMoins1']}">  
                        <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p>  
                        </c:forEach>
                </div></a>
                <div class="divider"></div>
                
                  <!--<h5>Dor3</h5>
                  
                  <a class="waves-effect waves-teal btn"><div class="section">
                          <h6>Lit 1</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 2</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 3</h6>
                  <p></p></div></a>
                <div class="divider"></div>
                
                  <h5>Dor4</h5>
				  <a class="waves-effect waves-teal btn"><div class="section">
                          <h6>Lit 1</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 2</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 3</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                          <h6>Lit 4</h6>
                  <p></p></div></a>>-->
               </div>
                  
          
               <div class="col l2 hide-on-med-and-down">
            <!-- Promo Content 1 goes here -->
            <div class="divider"></div>
                <a class="waves-effect waves-teal btn">
                    <div class="section">
                        <h5>Simple</h5>
                        <c:forEach var="u" items="${requestScope['listeDesClientsSimpleToday']}">  
                        <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p>  
                        </c:forEach>
                    </div>
                </a>
                <div class="divider"></div>
                <a class="waves-effect waves-teal btn"><div class="section">
                  <h5>Zen</h5>
                  <c:forEach var="u" items="${requestScope['listeDesClientsZenToday']}">  
                       <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p>  
                        </c:forEach>
                </div></a>
                <div class="divider"></div>
                <a class="waves-effect waves-teal btn"><div class="section">
                  <h5>Swazi</h5>
                  <c:forEach var="u" items="${requestScope['listeDesClientsSwaziToday']}">  
                        <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p>  
                  </c:forEach>
                </div></a>
                <div class="divider"></div>
                
                  <!--<h5>Dor3</h5>
                  
                  <a class="waves-effect waves-teal btn"><div class="section">
                          <h6>Lit 1</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 2</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 3</h6>
                  <p></p></div></a>
                <div class="divider"></div>
                
                  <h5>Dor4</h5>
				  <a class="waves-effect waves-teal btn"><div class="section">
                          <h6>Lit 1</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 2</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 3</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                          <h6>Lit 4</h6>
                  <p></p></div></a>>-->
               </div>
          
          
               <div class="col l2 hide-on-med-and-down">
            <!-- Promo Content 1 goes here -->
            <div class="divider"></div>
                <a class="waves-effect waves-teal btn"><div class="section">
                  <h5>Simple</h5>
                  <c:forEach var="u" items="${requestScope['listeDesClientsSimpleTodayPlus1']}">  
                        <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p>  
                        </c:forEach>
                    </div></a>
                <div class="divider"></div>
                <a class="waves-effect waves-teal btn"><div class="section">
                  <h5>Zen</h5>
                  <c:forEach var="u" items="${requestScope['listeDesClientsZenTodayPlus1']}">  
                        <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p>  
                  </c:forEach>
                </div></a>
                <div class="divider"></div>
                <a class="waves-effect waves-teal btn"><div class="section">
                  <h5>Swazi</h5>
                  <c:forEach var="u" items="${requestScope['listeDesClientsSwaziTodayPlus1']}">  
                        <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p>  
                  </c:forEach>
                </div></a>
                <div class="divider"></div>
                
                  <!--<h5>Dor3</h5>
                  
                  <a class="waves-effect waves-teal btn"><div class="section">
                          <h6>Lit 1</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 2</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 3</h6>
                  <p></p></div></a>
                <div class="divider"></div>
                
                  <h5>Dor4</h5>
				  <a class="waves-effect waves-teal btn"><div class="section">
                          <h6>Lit 1</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 2</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 3</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                          <h6>Lit 4</h6>
                  <p></p></div></a>>-->
               </div>
          
      
               <div class="col l2 hide-on-med-and-down">
            <!-- Promo Content 1 goes here -->
           <div class="divider"></div>
                <a class="waves-effect waves-teal btn"><div class="section">
                  <h5>Simple</h5>
                  <c:forEach var="u" items="${requestScope['listeDesClientsSimpleTodayPlus2']}">  
                        <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p>  
                        </c:forEach>
                    </div></a>
                <div class="divider"></div>
                <a class="waves-effect waves-teal btn"><div class="section">
                  <h5>Zen</h5>
                  <c:forEach var="u" items="${requestScope['listeDesClientsZenTodayPlus2']}">  
                        <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p>  
                        </c:forEach>
                </div></a>
                <div class="divider"></div>
                <a class="waves-effect waves-teal btn"><div class="section">
                  <h5>Swazi</h5>
                  <c:forEach var="u" items="${requestScope['listeDesClientsSwaziTodayPlus2']}">  
                        <p>${u.prenom} ${u.nom} ${u.heureArrivee}
                            <fmt:formatDate value="${u.jourArrivee}" pattern="dd-MM-yyyy"/>
                            </br><fmt:formatDate value="${u.jourDepart}" pattern="dd-MM-yyyy"/>
                            </br> ${u.prix}€</td>
                        </p> 
                        </c:forEach>
                </div></a>
                <div class="divider"></div>
                
                  <!--<h5>Dor3</h5>
                  
                  <a class="waves-effect waves-teal btn"><div class="section">
                          <h6>Lit 1</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 2</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 3</h6>
                  <p></p></div></a>
                <div class="divider"></div>
                
                  <h5>Dor4</h5>
				  <a class="waves-effect waves-teal btn"><div class="section">
                          <h6>Lit 1</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 2</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                           <h6>Lit 3</h6>
                  <p></p></div></a>
				  <a class="waves-effect waves-teal btn"><div class="section">
                                          <h6>Lit 4</h6>
                  <p></p></div></a>>-->
                </div>
          
         

        </div>
        
            </div>
        </section>
        </c:if>
            
             
        
       <c:if test="${! empty requestScope['userlogin']}">
         
            <jsp:include page="sidenave.jsp"/> 

     
        
        
  
    
             
    </c:if>
            
       
            
            
            
       
     
        
        <tbody id="tbody">
        </tbody>
        
        <!-- Zone qui affiche les utilisateurs si le paramètre action vaut listerComptes -->  
        <c:if test="${param['action'] == 'listerLesUtilisateurs'}" >  
            <h2>Liste des utilisateurs</h2>  
            <table border="10">  
                <!-- La ligne de titre du tableau des comptes -->  
                <tr>  
                    <td><b>Login</b></td>  
                    <td><b>Nom</b></td>  
                    <td><b>Prénom</b></td>  
                </tr>  
  
                <!-- Ici on affiche les lignes, une par utilisateur -->  
                <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->  
                <c:set var="total" value="0"/>  
  
                <c:forEach var="u" items="${requestScope['listeDesUsers']}">  
                    <tr>  
                        <td>${u.login}</td>  
                        <td>${u.lastname}</td>  
                        <td>${u.firstname}</td>  
                        <!-- On compte le nombre de users -->  
                        <c:set var="total" value="${total+1}"/>  
                    </tr>  
                </c:forEach>  

                <c:set var="affiche" value="${fn:length(listeDesUsers)}"/>
                <tr><td><b>Affichés</b></td><td></td><td><b>${affiche}</b></td><td></td></tr>
                
                <!-- Affichage du solde total dans la dernière ligne du tableau -->
                <c:set var="total" value="${requestScope['numberOfUsers']}"/>
                <tr><td><b>TOTAL</b></td><td></td><td><b>${total}</b></td><td></td></tr>  
            </table>    
            
            <!-- Zone pagination -->
            
            <c:if test="${fn:length(paginationPages) > 1}" >
                <c:forEach var="count" begin="0" step="2" end="${fn:length(paginationPages)-1}">
                    <a href="ServletUsers?action=getUsersPaginated&start=${requestScope['paginationPages'][count]}&end=${requestScope['paginationPages'][count+1]}">${requestScope['paginationPages'][count]} - ${requestScope['paginationPages'][count+1]}</a>&nbsp;&nbsp;&nbsp;
                </c:forEach>
            </c:if>
                   
        </c:if> 
                   
                    
                </section>
        </main>
     
     
        <jsp:include page="footer.jsp"/>  
        
    </body>  
</html>