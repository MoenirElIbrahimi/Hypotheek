package Unit.testing;

import nl.rocnijmegen.HypotheekService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HypotheekServiceTest {

    @Test
    void testBerekenMaximaleHypotheek() {
        HypotheekService hypotheekService = new HypotheekService();

        double inkomen = 40000;
        double partnerInkomen = 20000;
        boolean heeftStudieschuld = false;
        int rentevastePeriode = 20;

        // Dit is een verwachte waarde, pas deze aan op basis van de implementatie van HypotheekBerekening
        double verwachteMaximaleHypotheek = 250000; // voorbeeldwaarde
        double werkelijkeMaximaleHypotheek = hypotheekService.berekenMaximaleHypotheek(inkomen, partnerInkomen, heeftStudieschuld, rentevastePeriode);

        assertEquals(verwachteMaximaleHypotheek, werkelijkeMaximaleHypotheek, 0.01);
    }

    @Test
    void testBerekenRentePerMaand() {
        HypotheekService hypotheekService = new HypotheekService();

        double hypotheekBedrag = 200000;
        int rentevastePeriode = 20;

        // Dit is een verwachte waarde, pas deze aan op basis van de implementatie van HypotheekBerekening
        double verwachteRentePerMaand = 1000; // voorbeeldwaarde
        double werkelijkeRentePerMaand = hypotheekService.berekenRentePerMaand(hypotheekBedrag, rentevastePeriode);

        assertEquals(verwachteRentePerMaand, werkelijkeRentePerMaand, 0.01);
    }

    @Test
    void testBerekenAflossingPerMaand() {
        HypotheekService hypotheekService = new HypotheekService();

        double hypotheekBedrag = 200000; // Hypotheekbedrag
        int looptijdJaren = 20; // Aflossingstermijn in jaren
        double rente = 0.03; // Rentepercentage, bijvoorbeeld 3%

        // Bereken de maandlasten met de formule
        double maandlasten = (hypotheekBedrag * rente / 12) / (1 - Math.pow(1 + rente / 12, -looptijdJaren * 12));

        // Dit is een verwachte waarde, pas deze aan op basis van de implementatie van HypotheekBerekening
        double verwachteAflossingPerMaand = maandlasten; // gebruik de berekende maandlasten
        double werkelijkeAflossingPerMaand = hypotheekService.berekenAflossingPerMaand(hypotheekBedrag, looptijdJaren);

        assertEquals(verwachteAflossingPerMaand, werkelijkeAflossingPerMaand, 0.01);
    }


    @Test
    void testBerekenTotaalBetaald() {
        HypotheekService hypotheekService = new HypotheekService();

        double maandLasten = 1000;
        int looptijdJaren = 20;

        // Dit is een verwachte waarde, pas deze aan op basis van de implementatie van HypotheekBerekening
        double verwachteTotaalBetaald = 240000; // voorbeeldwaarde
        double werkelijkeTotaalBetaald = hypotheekService.berekenTotaalBetaald(maandLasten, looptijdJaren);

        assertEquals(verwachteTotaalBetaald, werkelijkeTotaalBetaald, 0.01);
    }
}
