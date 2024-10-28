package Integratie.test;



import nl.rocnijmegen.App;
import nl.rocnijmegen.HypotheekService;
import nl.rocnijmegen.InputVerwerking;
import nl.rocnijmegen.PostcodeChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {

    @Test
    public void testCompleteHypotheekBerekening() {
        // Maak instanties van de benodigde klassen
        PostcodeChecker postcodeChecker = new PostcodeChecker();
        InputVerwerking inputVerwerking = new InputVerwerking();
        HypotheekService hypotheekService = new HypotheekService();

        // Simuleer een geldige postcode
        int postcode = postcodeChecker.postcode(1234);
        assertNotEquals(-1, postcode, "De postcode moet geldig zijn.");

        // Simuleer invoer voor inkomen
        double inkomen = inputVerwerking.vraagInkomen("uzelf");
        double partnerInkomen = inputVerwerking.vraagHeeftPartner() ? inputVerwerking.vraagInkomen("uw partner") : 0.0;
        boolean heeftStudieschuld = inputVerwerking.vraagHeeftStudieschuld();
        int rentevastePeriode = inputVerwerking.vraagRentevastePeriode();

        // Bereken de maximale hypotheek
        double maximaleHypotheek = hypotheekService.berekenMaximaleHypotheek(inkomen, partnerInkomen, heeftStudieschuld, rentevastePeriode);
        assertTrue(maximaleHypotheek > 0, "Maximale hypotheek moet groter zijn dan 0.");

        // Bereken de maandelijkse rente
        double rentePerMaand = hypotheekService.berekenRentePerMaand(maximaleHypotheek, rentevastePeriode);
        assertTrue(rentePerMaand >= 0, "Rente per maand moet niet negatief zijn.");

        // Bereken de maandelijkse aflossing
        double aflossingPerMaand = hypotheekService.berekenAflossingPerMaand(maximaleHypotheek, 30); // 30 jaar looptijd
        assertTrue(aflossingPerMaand >= 0, "Aflossing per maand moet niet negatief zijn.");

        // Bereken de totale maandlasten
        double totaleMaandLasten = rentePerMaand + aflossingPerMaand;

        // Bereken het totaal betaald bedrag na 30 jaar
        double totaalBetaald = hypotheekService.berekenTotaalBetaald(totaleMaandLasten, 30); // 30 jaar looptijd
        assertTrue(totaalBetaald >= 0, "Totaal betaald bedrag moet niet negatief zijn.");
    }
}
