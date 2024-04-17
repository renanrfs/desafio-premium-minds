package com.premium.minds;

import java.util.Scanner;


/**
 * This class represents a Pokemon catcher game where the player (Ash) moves around
 * a grid to catch Pokemon. The player's movements are represented by a sequence
 * of characters (N, S, E, W) indicating the direction of each move.
 * <p>
 * The main functionality of this class is to count the number of unique positions
 * visited by Ash during the given movement sequence. This is achieved by keeping
 * track of Ash's current position on the grid and storing all visited positions
 * in a set.
 *
 * @author Renan Souza
 */
public class PokemonCatcher {

    public static void main(String[] args) {

        // read the string to the next moves
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the movement sequence (N, S, E, O) or Q to quit:");

        Game game;
        String nextMove;
        while (true) {

            nextMove = scanner.nextLine();
            if (nextMove.equalsIgnoreCase("Q")) {
                System.out.println("Bye!");
                 break;
             }
            // The pokemon catcher game
            game = new Game();
            System.out.println("Pokemons caught: " + game.catchPokemons(nextMove));
        }
        scanner.close();
    }

}
