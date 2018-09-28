package p3;

import java.util.Random;

public class Duel_plusOuMoins extends Games {
	
	
public Duel_plusOuMoins () {

	tentativesUser=0;
	tentativesCompute=0;
	gagneUser=0;
	gagneCompute=0;
			
	
do {// boucle se terminant � la fin du programme, pour rejouer au m�me jeu	
	// r�initialisation de valeurs � z�ro, en cas de nouveau jeu	
	tentativesUser=0;
	tentativesCompute=0;
	gagneUser=0;
	gagneCompute=0;	
	
	
// On d�finit le nombre de chiffres et d'essais
	
System.out.println("Combien de chiffres / couleurs voulez vous utiliser ?");
selectFig = sc.nextInt();

System.out.println("Combien d'essais sont autoris�s avant de perdre la partie ?");
selectAttempt = sc.nextInt();
randTab= new int [selectFig];

//----------------------------------------------------------------------------------------------------------------------------------------------------------------


//L'ordinateur g�n�re sa combinaison

//ici on est sur un code comme Scanner sc = new Scanner(); Seul le rand peut �tre modifi�
// cette commande sert � g�n�rer une r�ponse al�atoire de l'ordinateur pour 1 chiffre.

Random rand = new Random ();

for (int i=0; i<selectFig;i++) {

//ici on utilise la fonction nextInt(et la limite NON INCLUE dans la parenth�se)...ici encore c'est comme le sc.nextLine();	
	
int nombreAleatoire = rand.nextInt(10);
randTab[i]=nombreAleatoire;
// Ici je stocke les nombres al�atoires dans un tableau de la taille de la combinaison souhait�e

System.out.print(randTab[i]);

}
System.out.println();

System.out.println("l'ordinateur a choisi une combinaison � "+selectFig+" chiffres.");


System.out.println();


//----------------------------------------------------------------------------------------------------------------------------------------------------------------

// L'utilisateur choisi sa  combinaison


System.out.println("A votre tour de choisir une combinaison � "+selectFig+" chiffres.");

sc.nextLine();// je vide le sc en cr�ant un Scan vide

//Je scanne la r�ponse en String, pour l'utiliser en tableau de char...convertit en int au passage


String str = sc.nextLine();
System.out.print("Votre proposition est : ");


input = new int [selectFig];


for (int j= 0;j< selectFig;j++) {
	

input[j] = Character.getNumericValue(str.charAt(j));	

System.out.print(input[j]);
}

System.out.println();


//----------------------------------------------------------------------------------------------------------------------------------------------------------------


// Maintenant l'ordinateur attaque

computAttack = new int [selectFig];

Random randAttack = new Random ();

System.out.print("L'ordinateur effectue son attaque n� "+(tentativesCompute+1)+"/"+selectAttempt);
System.out.println();
gagneCompute = 0;
for (int l=0; l<selectFig;l++) {

//ici on utilise la fonction nextInt(et la limite NON INCLUE dans la parenth�se)...ici encore c'est comme le sc.nextLine();	
	
	int nombreAleatolre = rand.nextInt(10);
	computAttack[l]=nombreAleatolre;	

	System.out.print(computAttack[l]);
	}
	System.out.println();
	

// verification des r�sultats de l'attaque de l'ordinateur

for (int i=0;i<selectFig;i++) {
	
	if (computAttack[i]==input[i]) {
		System.out.print(input[i]);
		gagneCompute++;
	}
	else if (computAttack[i]>input[i]) {
		System.out.print("-");
	}
	else {
		System.out.print("+");	
	}
}
	tentativesCompute++;
	if (gagneCompute ==selectFig) {
		System.out.println();
		System.out.println("L'ordinateur a gagn�");
		}
	else gagneCompute =0;
		
	System.out.println();
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
//A l'utilisateur d'attaquer	
	
	//System.out.println();
	while(gagneUser<selectFig && gagneCompute<selectFig && tentativesUser <selectAttempt) {// et boucle tant que personne n'a gagn�, ou que le nombre d'essai n'est pas atteint
	
		System.out.println("A votre tour d'attaquer. Choisissez une combinaison � "+selectFig+" chiffres");
	
		System.out.println("Attaque "+(tentativesUser+1)+"/"+selectAttempt);
	 // boucle pour rejouer autant que necessaire
	
		gagneUser=0;
	
	str = sc.nextLine();
	System.out.print("Votre proposition est : ");
	
	userAttack = new int [selectFig];

	// inscription des r�sultats dans un tableau
		
	for (int i= 0;i< selectFig;i++) {
		

	userAttack[i] = Character.getNumericValue(str.charAt(i));	

	System.out.print(userAttack[i]);
	}

	System.out.println();
		
	// et comparaison des r�sultats avec la combinaison cach�e par l'ordinateur
	
	for (int a=0; a<selectFig;a++) {
		
		if (userAttack[a]==randTab[a]) {
			
			System.out.print(userAttack[a]);
			gagneUser++;
		}
		else if (userAttack[a]>randTab[a]) {
		
			System.out.print("-");		
		}
		
		else {
			System.out.print("+");	
		}
	}
	tentativesUser++;
	if (gagneUser ==selectFig) {
		System.out.println();
		System.out.println("Bravo vous avez gagn�");
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

	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	//Attaques suivantes avec adaptations de l'ordinateur	
	
	
	
	// j'apprend � l'ordinateur � choisir son chiffre en fonction des retours
//System.out.println();	
System.out.print("L'ordinateur effectue son attaque n� "+(tentativesCompute+1)+"/"+selectAttempt);
System.out.println();	
gagneCompute =0;
	for (int m=0; m<selectFig;m++) {
		
	if (computAttack[m]<input[m]) {
	
	// ici je lui dis "Si le chiffre que tu as propos� est inf�rieur au chiffre de l'utilisateur, le minimum de ton random devient donc le chiffre pr�c�dent +1. La limite haute non inclue () est toujours 10 pour obtenir 9	
		computAttack[m]= rand.nextInt((10-(computAttack[m]+1))+computAttack[m]);
		System.out.print(computAttack[m]);
	}
	
	else if (computAttack[m]>input[m]) {
	
		computAttack[m]=rand.nextInt(computAttack[m]);
		System.out.print(computAttack[m]);
	}
	else {
		System.out.print(computAttack[m]);
	}
	
}	
	// V�rification des r�sultats
	System.out.println();
for (int a=0; a<selectFig;a++) {
		
		
		if (computAttack[a]==input[a]) {
			
			System.out.print(computAttack[a]);
			gagneCompute++;
		}
		else if (computAttack[a]>input[a]) {
		
			System.out.print("-");		
		}
		
		else {
			System.out.print("+");	
		}
}
	tentativesCompute++;
	if (gagneCompute ==selectFig) {
	System.out.println();
	System.out.println("L'ordinateur a gagn�");
	break;
	}
	else gagneCompute=0;
	System.out.println();
	} // fin de la boucle while
	
	
	
	
	
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------
// Sortie de la boucle while, proposition de choix "retry". Si l'utilisateur r�pond 1, c'est la boucle do while qui prend le relai, et le jeu recommence du d�but
	

	System.out.println("Voulez vous :");
	System.out.println("1. Jouer au m�me jeu");
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
	System.out.println("Merci d'avoir jou� et � bient�t");
	}
	
	}while (retry <2);	// fin de la boucle do while
		
	}


}


	
	
	