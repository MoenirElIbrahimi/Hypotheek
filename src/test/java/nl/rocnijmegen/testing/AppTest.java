package nl.rocnijmegen.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testBerekenMaximaleHypotheekZonderPartnerMetGeldigeRentePeriode() {
        double inkomen = 60000;
        double partnerInkomen = 0;
        boolean heeftStudieschuld = false;
        int rentevastePeriode = 30;  // Voeg hier de rentevaste periode toe

        // Roep de methode aan met alle vier parameters
        double resultaat = HypotheekBerekening.berekenMaximaleHypotheek(inkomen, partnerInkomen, heeftStudieschuld, rentevastePeriode);

        assertEquals(255000, resultaat, "Het maximale bedrag voor een enkel inkomen van 60000 moet 255000 zijn.");
    }


    @Test
    public void testBerekenMaximaleHypotheekMetPartnerMetGeldigeRentePeriode() {
        double inkomen = 60000;
        double partnerInkomen = 30000;
        boolean heeftStudieschuld = false;
        int rentevastePeriode = 20;

        double resultaat = HypotheekBerekening.berekenMaximaleHypotheek(inkomen, partnerInkomen, heeftStudieschuld, rentevastePeriode);

        assertEquals(382500, resultaat, "Het maximale bedrag voor een gezamenlijk inkomen van 90000 moet 382500 zijn.");
    }

    @Test
    public void testBerekenMaximaleHypotheekMetOngeldigeRentePeriode() {
        double inkomen = 60000;
        double partnerInkomen = 30000;
        boolean heeftStudieschuld = false;
        int rentevastePeriode = 15;  // Ongeldige periode

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            HypotheekBerekening.berekenMaximaleHypotheek(inkomen, partnerInkomen, heeftStudieschuld, rentevastePeriode);
        });

        assertEquals("Ongeldige rentevaste periode. Kies 1, 5, 10, 20 of 30 jaar.", exception.getMessage());
    }
}
