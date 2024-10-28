package Unit.testing;

import org.junit.jupiter.api.Test;
import nl.rocnijmegen.InputVerwerking;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InputVerwerkingTest {

    @Test
    void testVraagInkomen() {
        String input = "50000\n"; // Simuleer invoer
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // Zet de inputstream om te lezen van de gesimuleerde invoer
        InputVerwerking inputVerwerking = new InputVerwerking();

        double inkomen = inputVerwerking.vraagInkomen("testpersoon");

        assertEquals(50000, inkomen);
    }

    @Test
    void testVraagHeeftPartner() {
        String input = "ja\n"; // Simuleer invoer
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputVerwerking inputVerwerking = new InputVerwerking();

        boolean heeftPartner = inputVerwerking.vraagHeeftPartner();

        assertTrue(heeftPartner);
    }

    @Test
    void testVraagHeeftStudieschuld() {
        String input = "nee\n"; // Simuleer invoer
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputVerwerking inputVerwerking = new InputVerwerking();

        boolean heeftStudieschuld = inputVerwerking.vraagHeeftStudieschuld();

        assertFalse(heeftStudieschuld);
    }

    @Test
    void testVraagRentevastePeriode() {
        String input = "5\n"; // Simuleer invoer
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputVerwerking inputVerwerking = new InputVerwerking();

        int periode = inputVerwerking.vraagRentevastePeriode();

        assertEquals(5, periode);
    }
}
