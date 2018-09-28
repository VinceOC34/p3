

package p3;
import java.util.Random;
import java.util.Scanner;

public abstract class Games {

	int gagne;
	int gagneUser;//permet de voir quand X chiffres proposés correspondent à X chiffres de la combinaison
	int gagneCompute;
	int tentativesUser;  // compteur de tentatives	
	int tentativesCompute;// compteur de tentatives
	int selectGame;
	int selectMode; //mode de jeu
	int selectFig; // nbre de chiffres cachés
	int selectAttempt;// nbre d'essais
	
	int retry; //Voulez vous réessayer / retourner au Menu / ou quitter
	
	
	int randTab[]; // combinaison Random de l'ordinateur 
	
	int [] input; //combinaison rentrée par l'utilisateur
	
	int [] userAttack; // l'utilisateur essaye de trouver la combinaison de l'ordi
		
	int [] computAttack;// l'ordi essaye de trouver la combinaison de l'utilisateur
	
	
	
Scanner sc = new Scanner (System.in);

Random rand = new Random();	
	
}


