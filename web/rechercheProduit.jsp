<form>
	<input name="elRecherche" id="elRecherche" type="text" placeholder="chercher un produit">
        <select name="optionRecherche" onchange="chgPlaceHolder(value)">
		<option value="n">nom</option>
		<option value="d">description</option>
		<option value="m">mot clés</option>
	</select>
	<input type="button" value="chercher">
        <input type="hidden" name="action" value="rechercherProd">
</form>
<script>
        function chgPlaceHolder($x){
        //alert($x);
        if ($x == 'n'){
                document.getElementById('elRecherche').placeholder='recherche par nom de produit';  
        }
        if($x == 'd'){
                document.getElementById('elRecherche').placeholder='recherche par description de produit';  
        }
        if($x == 'm'){
                document.getElementById('elRecherche').placeholder='recherche par mot-clés de produit';  
        }          
        }       
</script> 