package Unit.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import nl.rocnijmegen.HypotheekBerekening;
import org.junit.jupiter.api.Test;

public class HypotheekBerekeningTest {

    @Test
    public void testBerekenMaximaleHypotheek() {
        // Test de berekening van de maximale hypotheek zonder studieschuld.
        double inkomen = 40000;
        double partnerInkomen = 30000;
        boolean heeftStudieschuld = false;
        int rentevastePeriode = 10;

        double verwachtMaximaleHypotheek = (inkomen + partnerInkomen) * 4.25;
        double resultaat = HypotheekBerekening.berekenMaximaleHypotheek(inkomen, partnerInkomen, heeftStudieschuld, rentevastePeriode);

        assertEquals(verwachtMaximaleHypotheek, resultaat, 0.01, "De maximale hypotheek moet correct berekend worden.");
    }

    @Test
    public void testBerekenMaximaleHypotheekMetStudieschuld() {
        // Controleert of de maximale hypotheek wordt verminderd met 25% als er een studieschuld is.
        double inkomen = 40000;
        double partnerInkomen = 30000;
        boolean heeftStudieschuld = true;
        int rentevastePeriode = 10;

        double verwachtMaximaleHypotheek = (inkomen + partnerInkomen) * 4.25 * 0.75;
        double resultaat = HypotheekBerekening.berekenMaximaleHypotheek(inkomen, partnerInkomen, heeftStudieschuld, rentevastePeriode);

        assertEquals(verwachtMaximaleHypotheek, resultaat, 0.01, "De maximale hypotheek moet correct berekend worden als er een studieschuld is.");
    }

    @Test
    public void testOngeldigeRentevastePeriode() {
        // Test of er een uitzondering wordt gegooid bij een ongeldige rentevaste periode.
        double inkomen = 40000;
        double partnerInkomen = 30000;
        boolean heeftStudieschuld = false;
        int ongeldigeRentevastePeriode = 15;

        assertThrows(IllegalArgumentException.class, () -> {
            HypotheekBerekening.berekenMaximaleHypotheek(inkomen, partnerInkomen, heeftStudieschuld, ongeldigeRentevastePeriode);
        }, "Ongeldige rentevaste periode moet een IllegalArgumentException geven.");
    }

    @Test
    public void testBerekenRentePerMaand() {
        // Test de berekening van de maandelijkse rente.
        double hypotheekBedrag = 250000;
        int rentevastePeriode = 10;

        double verwachtRentePerMaand = hypotheekBedrag * 0.035 / 12;  // 3.5% rente voor 10 jaar
        double resultaat = HypotheekBerekening.berekenRentePerMaand(hypotheekBedrag, rentevastePeriode);

        assertEquals(verwachtRentePerMaand, resultaat, 0.01, "De maandelijkse rente moet correct berekend worden.");
    }

    @Test
    public void testBerekenAflossingPerMaand() {
        // Controleert de berekening van de maandelijkse aflossing op basis van een looptijd in jaren.
        double hypotheekBedrag = 250000;
        int looptijdJaren = 30;

        double verwachtAflossingPerMaand = hypotheekBedrag / (looptijdJaren * 12);
        double resultaat = HypotheekBerekening.berekenAflossingPerMaand(hypotheekBedrag, looptijdJaren);

        assertEquals(verwachtAflossingPerMaand, resultaat, 0.01, "De maandelijkse aflossing moet correct berekend worden.");
    }

    @Test
    public void testBerekenTotaalBetaald() {
        // Test de berekening van het totaal betaalde bedrag over de gehele looptijd.
        double maandLasten = 1200;
        int looptijdJaren = 30;

        double verwachtTotaalBetaald = maandLasten * (looptijdJaren * 12);
        double resultaat = HypotheekBerekening.berekenTotaalBetaald(maandLasten, looptijdJaren);

        assertEquals(verwachtTotaalBetaald, resultaat, 0.01, "Het totaal betaalde bedrag moet correct berekend worden.");
    }
}
