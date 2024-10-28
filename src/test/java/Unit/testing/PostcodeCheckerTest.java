package Unit.testing;

import nl.rocnijmegen.PostcodeChecker;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostcodeCheckerTest {

    @Test
    public void testValidPostcode() {
        PostcodeChecker checker = new PostcodeChecker();

        // Test een geldige postcode, bijvoorbeeld 1234
        int result = checker.postcode(1234);
        assertEquals(1234, result, "De postcode moet geldig zijn.");
    }

    @Test
    public void testInvalidPostcodes() {
        PostcodeChecker checker = new PostcodeChecker();

        // Test de ongeldige postcodes
        int result1 = checker.postcode(9679);
        int result2 = checker.postcode(9681);
        int result3 = checker.postcode(9682);

        assertEquals(-1, result1, "De postcode 9679 moet ongeldig zijn en -1 retourneren.");
        assertEquals(-1, result2, "De postcode 9681 moet ongeldig zijn en -1 retourneren.");
        assertEquals(-1, result3, "De postcode 9682 moet ongeldig zijn en -1 retourneren.");
    }

    @Test
    public void testMainMethodWithValidInput() {
        // Simuleer de invoer voor de Scanner in de main-methode
        String input = "1234\n";  // Geldige postcode
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PostcodeChecker.main(new String[0]);

        // Hier kun je controleren op console-uitvoer of andere effecten indien nodig
    }

    @Test
    public void testMainMethodWithInvalidInput() {
        // Simuleer de invoer voor de Scanner in de main-methode
        String input = "9679\n";  // Ongeldige postcode
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PostcodeChecker.main(new String[0]);

        // Hier kun je controleren op console-uitvoer of andere effecten indien nodig
    }
}
