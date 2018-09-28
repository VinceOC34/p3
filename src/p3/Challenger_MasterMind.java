package p3;

import java.util.Random;

public class Challenger_MasterMind extends Games {

	
public Challenger_MasterMind () {

	do {
	
	tentativesUser=0;
	tentativesCompute=0;
	gagneUser=0;
	gagneCompute=0;	
	
System.out.println("Combien de chiffres / couleurs voulez vous utiliser ?");
	
	selectFig = sc.nextInt();
	
	System.out.println("Combien d'essais sont autorisés avant de perdre la partie ?");
	selectAttempt = sc.nextInt();
	
	
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------
	//L'ordinateur génère sa combinaison
	
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
	do {	
	System.out.println("Attaque "+(tentativesUser+1)+"/"+selectAttempt);
	
	
	//sc.nextLine();// je vide le sc en créant un Scan vide à masquer par la suite et à reproduire en bas de la boucle pour vider le cache
	
	 //Je scanne la réponse en String, pour l'utiliser en tableau de char...convertit en int au passage
	
	
	String str = sc.nextLine();
	
	System.out.print("Votre proposition est : ");
	
	userAttack = new int [selectFig];

	for (int j= 0;j< selectFig;j++) {
	
		userAttack[j] = Character.getNumericValue(str.charAt(j));	

		System.out.print(userAttack[j]);
}

	System.out.println();
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------	
// Analyse des résultats en mode MasterMind
	
	int i =0;
	gagneUser=0;//bien placés
	int c =0;// présent mais mal placés
	
	while (i<selectFig) {
		
	
	if (userAttack[i]==randTab[i]) {
	
	gagneUser++;
	
	}
		
	for (int a = 0 ; a<selectFig ;a++) {
	
	if (userAttack[i]==randTab[a]) {
	
	c++; //:)
	}
	
	
	}
	i++;

	}
	System.out.println("bien placés "+ gagneUser);
	System.out.println("présents mais mal placés "+c);
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


	}while ( gagneUser < selectFig && tentativesUser < selectAttempt);

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
