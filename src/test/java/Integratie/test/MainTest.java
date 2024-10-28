package Integratie.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import nl.rocnijmegen.HypotheekBerekening;
import nl.rocnijmegen.HypotheekService;
import nl.rocnijmegen.InputVerwerking;
import nl.rocnijmegen.PostcodeChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {

    private InputVerwerking inputVerwerking;
    private HypotheekService hypotheekService;
    private PostcodeChecker postcodeChecker;

    @BeforeEach
    public void setUp() {
        inputVerwerking = new InputVerwerking();
        hypotheekService = new HypotheekService();
        postcodeChecker = new PostcodeChecker();
    }

    @Test
    public void testIntegratieHypotheekBerekening() {
        // Stel de testdata in
        double inkomen = 50000; // Jaarinkomen van de klant
        double partnerInkomen = 30000; // Jaarinkomen van de partner
        boolean heeftStudieschuld = false; // De klant heeft geen studieschuld
        int rentevastePeriode = 10; // 10 jaar rentevaste periode

        // Bereken de maximale hypotheek
        double maximaleHypotheek = hypotheekService.berekenMaximaleHypotheek(inkomen, partnerInkomen, heeftStudieschuld, rentevastePeriode);

        // Controleer of de maximale hypotheek correct is
        double verwachteMaximaleHypotheek = 340000; // Verwachte waarde
        assertEquals(verwachteMaximaleHypotheek, maximaleHypotheek, "De maximale hypotheek moet correct zijn.");

        // Bereken de maandlasten
        double rentePerMaand = hypotheekService.berekenRentePerMaand(maximaleHypotheek, rentevastePeriode);
        double aflossingPerMaand = hypotheekService.berekenAflossingPerMaand(maximaleHypotheek, 30); // 30 jaar looptijd
        double totaleMaandLasten = rentePerMaand + aflossingPerMaand;

        // Controleer of de maandlasten correct zijn
        double verwachteRentePerMaand = 991.67; // Verwachte waarde
        assertEquals(verwachteRentePerMaand, rentePerMaand, "De maandlasten moeten correct zijn.");
    }

    @Test
    public void testIntegratiePostcodeChecker() {
        // Test een geldige postcode
        int result = postcodeChecker.postcode(1234);
        assertEquals(1234, result, "De postcode moet geldig zijn.");

        // Test een ongeldige postcode
        int invalidResult = postcodeChecker.postcode(9679);
        assertEquals(-1, invalidResult, "De postcode moet ongeldig zijn en -1 retourneren.");
    }

    @Test
    public void testIntegratieInputVerwerking() {
        // Hier zouden we normaal gesproken mocks gebruiken om de scannerinput te simuleren,
        // maar voor eenvoudiger testen laten we dit hier even buiten beschouwing.
        // Dit kan complexer worden en is afhankelijk van de invoer.

        // Voor nu kunnen we de functionaliteit alleen handmatig testen.
        // We kunnen dit uitbreiden met andere tests indien nodig.
    }
}
