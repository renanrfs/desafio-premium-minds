package com.premium.minds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private Game game;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        game = new Game();
    }


    @Test
    public void should_CatchPokemons_When_CorrectMoveIsPassed() {
        // given
        String[] nextMoves = {"", "E", "e", "NESO", "nEsO", "NSNSNSNSNS", "NsNsNSnsNS", "EEENNNOENENENOOESSS"};
        int[] expected = {1, 2, 2, 4, 4, 2, 2, 16};

        // when
        int actual;
        for (int i = 0; i < nextMoves.length; i++) {
            actual = new Game().catchPokemons(nextMoves[i]);

            // then
            assertEquals(expected[i], actual);
        }
    }

    @Test
    public void should_CatchOnTime_When_PassedInTheSamePosition() {
        // given
        String[] nextMoves = {"sss", "sssnnn"};
        int expected = 4;

        // when
        int actual;
        for (String nextMove : nextMoves) {
            actual = new Game().catchPokemons(nextMove);

            // then
            assertEquals(actual, expected);
        }
    }

    @Test
    public void should_ThrowIllegalArgumentException_When_InvalidMove() {
        // given
        String[] nextMoves = {"a", "1", "Q", "NE1", "NESOA", " N", "E ", "1NE", "NE#", "@NES", "NES."};

        // when
        for (String nextMove : nextMoves) {
            Executable executable = () -> game.catchPokemons(nextMove);

            // then
            assertThrows(IllegalArgumentException.class, executable);
        }
    }
}
