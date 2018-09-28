package p3;
import java.util.Random;
import java.util.Scanner;
public class Menu extends Games {

	
public Menu() {

	
	Scanner sc = new Scanner (System.in);
	
	
	System.out.println("A quel jeu souhaitez vous jouer");	

	System.out.println("1. Plus ou Moins");
	System.out.println("2. Mastermind");

	selectGame = sc.nextInt();
	
	System.out.println("Quel mode voulez vous utiliser ?");	

	System.out.println("1. Challenger (trouver la combinaison secr�te de l'ordinateur)");
	System.out.println("2. D�fenseur  (l'ordinateur essaye de trouver votre combinaison secr�te)");
	System.out.println("3. Duel       (tour � tour contre l'ordinateur)");
	System.out.println("4. Developpeur (affiche directement la solution pour �tude du programme)");
	
	selectMode = sc.nextInt();
	
	

	
	
	
	
	if (selectMode == 3) {
		
		Object three = new Duel_plusOuMoins();
		
	}
		else if (selectMode ==1){
			
			Object two = new Challenger_plusOuMoins();
			
		}
			
		else {
						
		}
		
		
		
		
		
		

	if (selectMode == 1) { // si Challenger
		
		System.out.println("Combien de chiffres / couleurs voulez vous utiliser ?");
		selectFig = sc.nextInt();
		
		System.out.println("Combien d'essais sont autoris�s avant de perdre la partie ?");
		selectAttempt = sc.nextInt();

		
		randTab= new int [selectFig];

		//System.out.println(randTab.length);

		//ici on est sur un code comme Scanner sc = new Scanner(); Seul le rand peut �tre modifi�

		Random rand = new Random ();

		for (int i=0; i<randTab.length;i++) {

		//ici on utilise la fonction nextInt(et la limite NON INCLUE dans la parenth�se)...ici encore c'est comme le sc.nextLine();	
			
		int nombreAleatoire = rand.nextInt(10);
		randTab[i]=nombreAleatoire;

		
		
		System.out.print(randTab[i]);
	}
		System.out.println();
		
		System.out.println("l'ordinateur a choisi une proposition � "+selectFig+" chiffres. Vous avez "+selectAttempt+" essais pour trouver le bon r�sultat");
		
			
		

		// maintenant l'utilisateur saisie une proposition � x chiffres en String, qui est en fait convertible en tab de char, puis en int.
		// on s'accroche aux branches ! Je scanne le retour de l'utilisateur en String, puis je convertis chaque lettre en char avec la fonction .charAt(j...pour faire d�filer chaque caract�re).
		//Mais en plus, je convertis chaque caract�re, dans un m�me temps, via la fonction Character.getNumericValue();
		
		
			do {
			
			System.out.println();
			System.out.println("Entrez une combinaison � "+selectFig+" chiffres");
		
		sc.nextLine();// je vide le sc en cr�ant un Scan vide
		
		 //Je scanne la r�ponse en String, pour l'utiliser en tableau de char...convertit en int au passage
		
		
		String str = sc.nextLine();
		System.out.print("Votre proposition est : ");


		input = new int [selectFig];


		for (int j= 0;j< input.length;j++) {
		input[j] = Character.getNumericValue(str.charAt(j));	

	System.out.print(input[j]);
}
	
	System.out.println();
	
	
	//Analyse des r�sultats chiffres par chiffres, via les 2 tableaux cr��s plus haut.
	
	for (int k=0; k<randTab.length;k++) {
		
		if (randTab[k]==input[k]) {
			
			System.out.print(randTab[k]);	
			
		
	//A chaque fois qu'un chiffre est bon, "gagne" prend +1. Lorsque que gagne est �gal � selectFig, cela signifie que tous les chiffres sont bons.	
		gagne++;
		
	// Idem pour les tentatives. 	
		//tentatives ++; ne va pas ici

		
		}
		
		else if (randTab[k]>input[k]) {
		
			System.out.print("+");
			
			
				
		}
		
		else {
			System.out.print("-");
			
		}
			
			
			
	}
		
	
	
	}while ( gagne < selectFig);
	
		
		
	//System.out.println();
		System.out.println("Bravo,vous avez gagn�");
	
		
	
	}
}}
