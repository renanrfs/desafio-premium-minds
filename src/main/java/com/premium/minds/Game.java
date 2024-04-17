package com.premium.minds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a Pokemon catcher game where the player (Ash) moves around
 */
public class Game {

    // The current position of Ash
    private int x = 0, y = 0;

    // Keeps track of all visited positions
    private final Set<String> visitor = new HashSet<>();

    /**
     * Creates a new com.premium.minds.Game.
     */
    public Game() {
        visitor.add(x + "," + y);
    }

    /**
     * Calculates a number of pokemons that will be caught
     *
     * @param nextMove - the next moves to be processed
     * @return the number of pokemons that will be caught
     */
    public int catchPokemons(String nextMove) {



        // go through the sequence of moves to the end
        for (char move : nextMove.toCharArray()) {
            switch (move) {
                case 'N':
                case 'n':
                    y++;
                    break;
                case 'S':
                case 's':
                    y--;
                    break;
                case 'E':
                case 'e':
                    x++;
                    break;
                case 'O':
                case 'o':
                    x--;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid move: " + move);

            }
            // add the current position to the set of visited positions
            visitor.add(x + "," + y);
        }

        return visitor.size();
    }
}
