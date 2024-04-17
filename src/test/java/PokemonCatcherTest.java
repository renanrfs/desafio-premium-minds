import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonCatcherTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void should_PrintBye_When_InputIsQ() {
        // given
        String input = "Q";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        PokemonCatcher.main(null);

        // then
        assertEquals("Enter the movement sequence (N, S, E, O) or Q to quit:\nBye!", outputStreamCaptor.toString().trim());
    }

    @Test
    public void should_PrintBye_When_InputIsq() {
        // given
        String input = "q";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        PokemonCatcher.main(null);

        // then
        assertEquals("Enter the movement sequence (N, S, E, O) or Q to quit:\nBye!", outputStreamCaptor.toString().trim());
    }

    @Test
    public void should_PrintPokemonsCaught2AndBye_When_InputIsEq() {
        // given
        String input = "E\nq\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        PokemonCatcher.main(null);

        // then
        assertEquals("Enter the movement sequence (N, S, E, O) or Q to quit:\nPokemons caught: 2\nBye!", outputStreamCaptor.toString().trim());
    }

}
