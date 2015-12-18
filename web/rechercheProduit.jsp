<h2>Rechercher un produit</h2>
<div id="formRechercherProduit">   
    <form method="post" action="rechercherProd.do">
	<input name="elRecherche" id="elRecherche" type="text" placeholder="Chercher un produit">
        <select name="optionRecherche" onchange="chgPlaceHolder(value)">
		<option value="n">Nom</option>
		<option value="m">Catégorie</option>
	</select>
        <input name="action" value="rechercherProd" type="hidden" />        
	<input type="submit" classe="bouton" value="Chercher">
    </form>
</div>
<%
    if (request.getAttribute("messageRechercherProduit")!=null)
    {
        out.println("<span class=\"errorMessage\">"+request.getAttribute("messageRechercherProduit")+"</span>");
    }
%>
<script>
    function chgPlaceHolder($x){
        //alert($x);
        if ($x == 'n'){
                document.getElementById('elRecherche').placeholder='Recherche par nom de produit';  
        }
        if($x == 'c'){
                document.getElementById('elRecherche').placeholder='Recherche par catégorie de produit';  
        }          
    }       
</script> 