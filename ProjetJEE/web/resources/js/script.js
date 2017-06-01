/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 // Initialize collapse button
  $(".button-collapse").sideNav();
  
  
  // Initialize collapsible (uncomment the line below if you use the dropdown variation)
//  $('.collapsible').collapsible();

var cpt = 0;
function addAddForm()
{
    cpt++;
    var parent = document.getElementById("containerForForms");
    var form = document.createElement("form");
    var input;
    var a;
    
    form.action = "ServletUsers";
    form.onsubmit = function (form) {
        return addUser();
    }
    form.method = "get";
    input = document.createElement("input");
    input.className = "form_crea_u_nom";
    input.type = "text";
    input.name = "nom";
    form.appendChild(input);
    
    input = document.createElement("input");
    input.className = "form_crea_u_prenom";
    input.type = "text";
    input.name = "prenom";
    form.appendChild(input);
    
    input = document.createElement("input");
    input.className = "form_crea_u_login";
    input.type = "text";
    input.name = "login";
    form.appendChild(input);
    
    input = document.createElement("input");
    input.className = "form_crea_u_action";
    input.type = "hidden";
    input.name = "action";
    input.value = "creerUnUtilisateur";
    form.appendChild(input);

    input = document.createElement("input");
    input.type = "submit";
    input.name = "submit";
    input.value = "Créer utilisateur";
    
    a = document.createElement("a");
    a.className = "waves-effect waves-light btn";
    a.appendChild(input);
    form.appendChild(a);

    parent.appendChild(form);

}

  

