<!DOCTYPE html>
<html>
<head>
<title>Modifier Compte</title>
</head>
<body>

<h1>Modification d'un compte</h1>
    <div>
        <form>
            courriel *: <input type="email" name=""><br>	
            mot de passe *: <input type="password" name=""><br>
            Confirmer mot de passe *: <input type="password" name=""><br>
            nom*: <input type="text" name=""><br>
            Pr�nom *: <input type="text" name=""><br>
            adresse: <input type="text" name=""><br>
            t�l�phone: <input type="text" name=""><br>
            t�l�phone secondaire: <input type="text" name=""><br>
            Ville: <input type="text" name=""><br>
            Province: <input type="text" name=""><br>
            Code postal: <input type="text" name=""><br>
            num�ro de carte de cr�dit : <input type="text" name=""><br>
            <h4 style="color : red">* obligatoire</h4>
            <input type="button" name=""value="creer">
        </form>
        <form>
            <input type="hidden" name="action" value="loginAcheteur">
            <input type="button" name=""value="annuler">
        </form>
    </div>

</body>
</html>