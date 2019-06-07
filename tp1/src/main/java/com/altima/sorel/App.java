package com.altima.sorel;

import com.altima.sorel.exception.NumeroCarteInvalideException;
import com.altima.sorel.exception.PositionInvalideException;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 * Main class m use to start app
 *
 */
public class App {
    static App app = new App();
    JeuDeCartes cartes = new JeuDeCartes();
    public final static Logger LOGGER = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        LOGGER.setLevel(Level.INFO);

        Scanner sc = new Scanner(System.in);
        String continuer = "oui";
        while (continuer.equalsIgnoreCase("oui")) {
            app.showMenu();
            System.out.println();
            System.out.print("Que voulez vous faire (1-4) ");

            /*
            As long as the user does not enter a number between 1 and 5, we do not leave the loop
             */
            int select = app.select(1, 4);

            switch (select) {
                case 1:
                    app.melangerCarte();
                    break;
                case 2:
                    app.trierCartes();
                    break;
                case 3:
                    app.poicherCartes();
                    break;
                case 4:
                    System.out.println("Fin du jeu");
                    continuer = "non";
                    break;
                 default:
                        break;
            }

            if (!continuer.equals("non")) {
                System.out.println("Voulez vous continuer avec le jeu ?");
                System.out.println("Entrez <<oui>> pour continuer et n'importe quel lettre pour arreter");
                continuer = sc.nextLine();
            }
        }
    }


    private void showMenu() {
        System.out.println("+-------BIENVENUE DANS LE TP1-------------+");
        System.out.println("|         by Sorel Clebert                |");
        System.out.println("|         ----------------                |");
        System.out.println("|*************** MENU ********************|");
        System.out.println("|                                         |");
        System.out.println("| 1-      Melanger les cartes             |");
        System.out.println("| 2-      Trier les cartes                |");
        System.out.println("| 3-      Piochez une carte               |");
        System.out.println("| 4-      Quitter la partie               |");
        System.out.println("|_________________________________________|");
    }

    private void melangerCarte() {
        System.out.println("+-----------------------------------------+");
        System.out.println("|        Melanger les cartes              |");
        System.out.println("|_________________________________________|");
        System.out.println("     Etat du jeu de carte actuelle        ");
        System.out.println();
        System.out.println(cartes);
        System.out.println("----------------Melange ----------------");
        // we can function to mix cards
        cartes.melangerJeuCarte();
        System.out.println("    Etat du jeu de carte apres melange       ");
        System.out.println(cartes);
    }

    private void trierCartes() {
        System.out.println("+-----------------------------------------+");
        System.out.println("|           Trier les cartes              |");
        System.out.println("|_________________________________________|");
        System.out.println("   Quel type de trie voulez vous faire ?     ");
        System.out.println("|                                         |");
        System.out.println("| 1-     Priorité descendante             |");
        System.out.println("| 2-     Priorité ascendante              |");
        System.out.println("|_________________________________________|");
        System.out.println();
        System.out.print("Que voulez vous faire (1-2) ");
        int select = select(1, 2);
        System.out.println("Les cartes avant le trie");
        System.out.println(cartes);
        String trie = "";
        if (select==1) {
            trie = "descendant";
            cartes.trierJeuCarte(true);
        }else{
                trie = "ascendant";
                cartes.trierJeuCarte(false);
        }
        System.out.println();
        System.out.println("Les cartes apres le trie " + trie);
        System.out.println(cartes);


    }

    private int select(int min, int max){
        boolean correctValue = false;
        int select = 0;
        Scanner sc = new Scanner(System.in);
        while (!correctValue) {
            String choice = sc.nextLine();
            try {
                select = Integer.parseInt(choice);
                if (select >= min && select <= max) {
                    correctValue = true;
                } else {
                    throw new NumeroCarteInvalideException(select);
                }
            } catch (NumberFormatException | NumeroCarteInvalideException ex) {
                System.out.print("SVP selectionnez un numero valide (" + min + "-" + max + ")");
            }
        }
        return select;
    }

    private void poicherCartes() {
        System.out.println("+-----------------------------------------+");
        System.out.println("|          Piochez une carte              |");
        System.out.println("|_________________________________________|");
        System.out.print("Selectionnez un numero entre 1 et 80_");
        int select =  select(1, 80);
        try {
            System.out.println();
            System.out.println(cartes.piochezUneCarte(select));
        }catch (PositionInvalideException ex){
            System.out.println("erreur avec le numero choisi");
        }
    }
}
