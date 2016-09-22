import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Darcie on 27/08/2016.
 *
 */

public class Game {

    public static void main(String args[]) {

        showWelcome();
        showMenu();
        int opt = getUserMenuChoice();

        if (opt == 1) {
            System.out.println("You have started a new game.");
            startNewGame();
        } else {
            System.exit(0);
        }

    }

    private static void startNewGame() {
        int numberOfPlayers = getNumberPlayers();
        //ArrayList<Card> cards = new ArrayList<Card>();
        SuperTrumpGame game = new SuperTrumpGame(numberOfPlayers);
        System.out.print("You have chosen to play a game with " + numberOfPlayers + " players. \n");
        game.selectDealer(numberOfPlayers);
        System.out.print("The dealer is player number " + game.dealerNumber + ". \n");
        game.dealHand(numberOfPlayers);
        int firstPlayer = game.determineFirstPlayer(game.dealerNumber, numberOfPlayers);
        System.out.println("Player " + firstPlayer + " is playing the first card.");

        if (firstPlayer == 1){
            game.printHand();
            game.firstPlayerTurn();
        }
        else {
            game.firstBotTurn(firstPlayer);

        }



        while (!game.gameIsover) {

            for (int i = 0; i < game.players.length; i++) {
                if (game.players[i].isHuman) {
                    game.playerTurn();
                } else {
                    System.out.println("Player " + (i + 1) + " has played a turn:");
                    game.botTurn(i);
                }

            }
        }


    }

    private static int getNumberPlayers() {

        System.out.println("How many players would you like to play with?");
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        int n = reader.nextInt();

        //Check that the users input is valid number between 3 and 5 players.
        while (n <= 2 || n >= 5) {
            System.out.println("How many players would you like to play with?");
            Scanner reader2 = new Scanner(System.in);
            System.out.println("Enter your choice: ");
            n = reader2.nextInt();
        }
        return n + 1;

    }

    private static int getUserMenuChoice() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        int n = reader.nextInt();
        return n;
    }

    private static void showMenu() {
        System.out.println("1. Start game.");
        System.out.println("2. Exit.");
    }

    private static void showWelcome() {
        System.out.print("Welcome to Mineral SuperTrumps! What would you like to do? \n");
    }

    public static void dealCards(STDeck Deck, int numberOfPlayers) {
        System.out.println(Deck);
    }



}



