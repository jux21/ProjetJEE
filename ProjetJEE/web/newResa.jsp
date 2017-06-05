  <div class="row">
    <form class="col s12" action="ServletClients" method="get">
         <div class="row">
        <div class="input-field col s12">
            <h2>Chambre</h2>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="first_name" name="first_name" type="text" class="validate">
          <label for="first_name">First Name</label>
        </div>
        <div class="input-field col s12">
          <input id="last_name" name="last_name" type="text" class="validate">
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
          <input type="time" name="heureA">    
        </div>
      </div>
        
        <div class="row">
           <div class="input-field col s12">
            <label for="jourA">Jour d'arrivé</label>    
        </div>
          </div>
          <div class="row">
        <div class="input-field col s12">         
          <input type="date" name="jourA">    
        </div>
      </div>
         <div class="row">
           <div class="input-field col s12">
            <label for="jourD">Jour de départ</label>    
        </div>
          </div>
          <div class="row">
        <div class="input-field col s12">         
          <input type="date" name="jourD">    
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="prix" name="prix" type="number" step="0.01" class="validate">
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
                <input name="estarrive" type="checkbox">
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
                <input name="apaye" type="checkbox">
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
