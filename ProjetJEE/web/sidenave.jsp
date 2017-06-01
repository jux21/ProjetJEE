<%-- 
    Document   : sidenave
    Created on : 24 avr. 2017, 23:51:11
    Author     : Cécile
--%>

 <header>
            <!--HEADER-->
            <nav class="nav-extended #7cb342 light-green darken-1" role="navigation">
                <div class="nav-wrapper">  
                     <a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>
                    <a class="brand-logo flow-text">
                        <span class="flow-text">Lou Souleou</span>
                    </a>
                    
                    <!--session-->
                   
                    
                    <i class="material-icons">view_module</i>
                   
                    
                    <div class="right">
                    <label for="" class="wrapper">
	<input type="text" class="datepickerr">
	<div class="datepicker sample"></div>
</label>
                    </div>               
                        
                       
                        
                
                    <!--<ul class="tabs tabs-transparent">
                        <li class="tab"><a id="lien_menu_accueil" target="_self" href="/">Accueil</a></li>
                        <li class="tab"><a id="lien_menu_map" target="_self" href="/map">Consulter les données</a></li>
                        <li class="tab"><a id="lien_menu_list" target="_self" href="/list">Liste des monuments</a></li>
                    </ul>-->
                </div>
            </nav>
        </header>

<ul id="slide-out" class="side-nav fixed">
            <li><div class="userView">
            <div class="background"></div>
           
             <!-- Message qui s'affiche lorsque la page est appelé avec un paramètre http message -->  
        <c:if test="${!empty param['message']}">  
            <h2>Reçu message : ${param.message}</h2>  
        </c:if>  
            <a href="#!name"><span class="white-text name">${requestScope['userlogin']}</span></a>
            <a href="#!email"><span class="white-text email"> </span></a>
            </div></li>
            <!--<h5>Menu de gestion des utilisateurs</h5>
            <div class="label">
                <label>Liste des fonctionnalités à implémenter dans la Servlet (note : après chaque action cette page sera rappelée par la servlet avec la liste des utilisateurs raffraichie et un message de confirmation</label>
            </div>-->
            <li><a class="subheader">Gestionnaire</a></li>
            <li><div class="divider"></div></li>
           
       <ul class="collapsible" data-collapsible="accordion">
    
    <li>
      <div class="collapsible-header"><i class="material-icons"></i>Créer un utilisateur</div>
              <div class="collapsible-body">
                  
                    <form onsubmit="return addUser();" id="form_crea_u" action="ServletUsers" method="get">  
                        Nom : <input class="form_crea_u_nom" type="text" name="nom"/><br>  
                        Prénom : <input class="form_crea_u_prenom" type="text" name="prenom"/><br>  
                        Login : <input class="form_crea_u_login"  type="text" name="login"/><br> 
                        <!-- Astuce pour passer des paramètres à une servlet depuis un formulaire JSP !-->  
                        <br><input class="form_crea_u_action" type="hidden" name="action" value="creerUnUtilisateur"/> 
                        <a class="waves-effect waves-light btn"><input type="submit" value="Créer utilisateur" name="submit"></a>
                    </form> 
                    <div id="containerForForms"></div>
                   <!--  <button class="btn-floating btn-large waves-effect waves-light green center" onclick="addAddForm()"/>
                        +
                    </button> -->
               </div>
    </li>
    <li>
      <div class="collapsible-header"><i class="material-icons"></i>Afficher les détails d'un utilisateur</div>
              <div class="collapsible-body"><span>
          <form action="ServletUsers" method="get">  
                login : <input type="text" name="login"/><br>  
                <input type="hidden" name="action" value="chercherParLogin"/>  
                <a class="waves-effect waves-light btn"><input type="submit" value="Chercher" name="submit"/></a>  
            </form>  
          </span></div>
    </li>
    <li>
      <div class="collapsible-header"><i class="material-icons"></i>Modifier les détails d'un utilisateur</div>
              <div class="collapsible-body"><span>
                    <form action="ServletUsers" method="get">  
                    Login : <input type="text" name="login"/><br>  
                    Nom : <input type="text" name="nom"/><br>  
                    Prénom : <input type="text" name="prenom"/><br>  
                    <input type="hidden" name="action" value="updateUtilisateur"/>  
                    <a class="waves-effect waves-light btn"><input type="submit" value="Mettre à jour" name="submit"/></a> 
                </form>  
          </span></div>
    </li>
    <li>
      <div class="collapsible-header"><i class="material-icons"></i>Supprimer un utilisateur</div>
              <div class="collapsible-body"><span>
                    <form action="ServletUsers" method="get">  
                    Login : <input type="text" name="login"/><br>    
                    <input type="hidden" name="action" value="deleteUtilisateur"/>  
                    <a class="waves-effect waves-light btn"><input type="submit" value="Supprimer" name="submit"/></a>
                </form> 
          </span></div>
    </li>
    
    <li><form action="ServletLogout" method="post">  
                        <ul>
                            
                               <input type="hidden" name="action" value="deconnexion"/>
                                <li><a href="${pageContext.request.contextPath}/index.jsp" class="waves-effect waves-light btn">Deconnexion</a></li>
                        </ul>
        </form></li>
    
  </ul>
        
        
           
       
            
            
            
      </ul>
            
            
              

 <!--Import jQuery before materialize.js -->
  
 
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src=" https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script> 
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/materialize.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>

<script>$(document).ready(function(){
    Materialize.updateTextFields();
  });
  

 
 
    $('input.datepickerr').datepicker({
		dateFormat: 'yy-mm-dd',
		showButtonPanel: true,
		changeMonth: true,
		changeYear: true,
		defaultDate: +0,
		showAnim: "fold"
	});

$('.datepickerr.sample').datepicker({
		dateFormat: 'yy-mm-dd',
		showButtonPanel: true,
		changeMonth: true,
		changeYear: true,
		defaultDate: +0,
		showAnim: "fold"
	});

        
        var tbody;

            window.onload = function () {
                tbody = document.querySelector("#tbody");
            };

            function loadUsers() {
                var url = "http://localhost:8080/JEE/ServletUsers?action=listerLesUtilisateurs";
                
                var xhr = new XMLHttpRequest();
                xhr.open('GET', url, true);

                xhr.onload = function (evt) {

                    // Transformation JSON -> objet JavaScript
                    var response = JSON.stringify(this.response);
                    var books = JSON.parse(response);
                    var debut = books.indexOf('<!-- Zone qui affiche les utilisateurs si le paramètre action vaut listerComptes -->');
                    var fin = books.indexOf('</main>');
                    var res = books.substring(debut, fin);
                    console.log(debut);
                    console.log(fin);
                    console.log(books);
                    tbody.innerHTML = res; 
                };

                xhr.send();

                console.log("requête envoyée");
            }

            // Adding book
            function addUser(form) {
                // Build a book object
                var book = {};
                var formClass = form.getClass();
                book.nom = document.querySelector(".form_crea_u_nom").value;
                book.prenom = document.querySelector("form .form_crea_u_prenom").value;
                book.login = document.querySelector("form .form_crea_u_login").value;
                book.action = document.querySelector("form .form_crea_u_action").value;

                var url = "http://localhost:8080/JEE/ServletUsers?action=creerUnUtilisateur&nom="+book.nom+"&prenom="+book.prenom+"&login="+book.login;

                // Envoi de la requête Ajax
                var xhr = new XMLHttpRequest();
                xhr.open('get', url, true);

                xhr.onloadend = function () {
                    console.log("User créer");

                    // refresh the table
                   // showBooks(JSON.parse(this.response));
                    // Reset the form
                    document.querySelector("#form_crea_u").reset();
                    document.querySelector(form).reset();
                };

                xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
                xhr.send(JSON.stringify(book));
                reloadUsers();
                return false;

            }
            
            function reloadUsers() {
                var url = "http://localhost:8080/projet-tp2/ServletUsers?action=listerLesUtilisateurs";

                // Envoi de la requête Ajax
                var xhr = new XMLHttpRequest();
                xhr.open('get', url, true);

                xhr.onloadend = function () {
                    console.log("User créer");

                    // refresh the table
                    //showBooks(JSON.parse(this.response));
                    // Reset the form
                    document.querySelector("#form_crea_u").reset();
                };

                xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
                xhr.send();

                return false;
            }
            
         
       </script>
    
      