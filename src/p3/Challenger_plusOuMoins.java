package p3;

import java.util.Random;

public class Challenger_plusOuMoins extends Games{

public Challenger_plusOuMoins () {

	tentativesUser=0;
	tentativesCompute=0;
	gagneUser=0;
	gagneCompute=0;
			
	
	
do {// boucle se terminant à la fin du programme, pour rejouer au même jeu

// réinitialisation de valeurs à zéro, en cas de nouveau jeu
	tentativesUser=0;
	tentativesCompute=0;
	gagneUser=0;
	gagneCompute=0;
			
	
	System.out.println("Combien de chiffres / couleurs voulez vous utiliser ?");
	
	selectFig = sc.nextInt();
	
	System.out.println("Combien d'essais sont autorisés avant de perdre la partie ?");
	selectAttempt = sc.nextInt();

	randTab= new int [selectFig];

	//System.out.println(randTab.length);

	//ici on est sur un code comme Scanner sc = new Scanner(); Seul le rand peut être modifié

	Random rand = new Random ();

	for (int i=0; i<randTab.length;i++) {

	//ici on utilise la fonction nextInt(et la limite NON INCLUE dans la parenthèse)...ici encore c'est comme le sc.nextLine();	
		
	int nombreAleatoire = rand.nextInt(10);
	randTab[i]=nombreAleatoire;
	
	System.out.print(randTab[i]);
}
	sc.nextLine();
	
System.out.println();

System.out.println("l'ordinateur a choisi une proposition à "+selectFig+" chiffres. Vous avez "+selectAttempt+" essais pour trouver le bon résultat");



//----------------------------------------------------------------------------------------------------------------------------------------------------------------	
// Maintenant l'utilisateur attaque	

	
	// l'utilisateur saisie une proposition à x chiffres en String, qui est en fait convertible en tab de char, puis en int.
	// on s'accroche aux branches ! Je scanne le retour de l'utilisateur en String, puis je convertis chaque lettre en char avec la fonction .charAt(j...pour faire défiler chaque caractère).
	// mais en plus, je convertis chaque caractère, dans un même temps, via la fonction Character.getNumericValue();
	 
	// le programme boucle, jusqu'à ce que l'utilisateur gagne, ou qu'il atteingne le nombre d'essais max
	
	
	do {
	System.out.println("Attaque "+(tentativesUser+1)+"/"+selectAttempt);
	
	
	//sc.nextLine();// je vide le sc en créant un Scan vide
	
	 //Je scanne la réponse en String, pour l'utiliser en tableau de char...convertit en int au passage
	
	
	String str = sc.nextLine();
	
	System.out.print("Votre proposition est : ");
	
	input = new int [selectFig];

	for (int j= 0;j< input.length;j++) {
	
		input[j] = Character.getNumericValue(str.charAt(j));	

		System.out.print(input[j]);
}

	System.out.println();
	

	//----------------------------------------------------------------------------------------------------------------------------------------------------------------	
	//Analyse des résultats chiffres par chiffres, via les 2 tableaux créés plus haut.

for (int k=0; k<randTab.length;k++) {
	
	if (randTab[k]==input[k]) {
		
		System.out.print(randTab[k]);	

		//A chaque fois qu'un chiffre est bon, "gagneUser" prend +1. Lorsque que gagneUser est égal à selectFig, cela signifie que tous les chiffres sont bons.	
	gagneUser++;

	}
	else if (randTab[k]>input[k]) {
	
		System.out.print("+");			
	}
	else {
		System.out.print("-");	
	}
}
tentativesUser++;
if (gagneUser ==selectFig) {
	System.out.println();
	System.out.println("Bravo vous avez gagné");
	break;
	}
else if (tentativesUser==selectAttempt) {
	System.out.println();
	System.out.println("Vous avez perdu");
	break;
	
}
else {
	gagneUser =0;
}
System.out.println();


}while ( gagneUser < selectFig);

	System.out.println("Voulez vous :");
	System.out.println("1. Jouer au même jeu");
	System.out.println("2. Retourner au menu");
	System.out.println("3. Quitter le programme");
	
	retry = sc.nextInt();

	
	
	if (retry==1) {
		
	//break;
	}
	else if (retry ==2) {
	Object retry = new Menu();
	}
	else {
	System.out.println("Merci d'avoir joué et à bientôt");
	}
	
	}while (retry <2);	// fin de la boucle do while
		
	}



	

}

	

