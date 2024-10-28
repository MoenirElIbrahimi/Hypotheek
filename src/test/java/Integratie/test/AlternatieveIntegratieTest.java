package Integratie.test;


import nl.rocnijmegen.App;
import nl.rocnijmegen.HypotheekService;
import nl.rocnijmegen.InputVerwerking;
import nl.rocnijmegen.PostcodeChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

    public class AlternatieveIntegratieTest {

        @Test
        public void testHypotheekBerekeningMetVariabeleInvoer() {
            // Maak instanties van de benodigde klassen
            PostcodeChecker postcodeChecker = new PostcodeChecker();
            HypotheekService hypotheekService = new HypotheekService();

            // Scenario 1: Klant zonder partner en zonder studieschuld
            int postcode1 = postcodeChecker.postcode(1234);
            assertNotEquals(-1, postcode1, "De postcode moet geldig zijn.");

            double inkomen1 = 30000; // Inkomen van de klant
            double partnerInkomen1 = 0.0; // Geen partner
            boolean heeftStudieschuld1 = false; // Geen studieschuld
            int rentevastePeriode1 = 5; // Rentevaste periode van 5 jaar

            // Bereken de maximale hypotheek
            double maximaleHypotheek1 = hypotheekService.berekenMaximaleHypotheek(inkomen1, partnerInkomen1, heeftStudieschuld1, rentevastePeriode1);
            assertTrue(maximaleHypotheek1 > 0, "Maximale hypotheek moet groter zijn dan 0.");

            // Scenario 2: Klant met partner en met studieschuld
            int postcode2 = postcodeChecker.postcode(5678);
            assertNotEquals(-1, postcode2, "De postcode moet geldig zijn.");

            double inkomen2 = 40000; // Inkomen van de klant
            double partnerInkomen2 = 20000; // Inkomen van de partner
            boolean heeftStudieschuld2 = true; // Heeft studieschuld
            int rentevastePeriode2 = 10; // Rentevaste periode van 10 jaar

            // Bereken de maximale hypotheek
            double maximaleHypotheek2 = hypotheekService.berekenMaximaleHypotheek(inkomen2, partnerInkomen2, heeftStudieschuld2, rentevastePeriode2);
            assertTrue(maximaleHypotheek2 > 0, "Maximale hypotheek moet groter zijn dan 0.");

            // Scenario 3: Klant met hoge inkomens en zonder studieschuld
            int postcode3 = postcodeChecker.postcode(9101);
            assertNotEquals(-1, postcode3, "De postcode moet geldig zijn.");

            double inkomen3 = 100000; // Hoog inkomen van de klant
            double partnerInkomen3 = 50000; // Hoog inkomen van de partner
            boolean heeftStudieschuld3 = false; // Geen studieschuld
            int rentevastePeriode3 = 30; // Rentevaste periode van 30 jaar

            // Bereken de maximale hypotheek
            double maximaleHypotheek3 = hypotheekService.berekenMaximaleHypotheek(inkomen3, partnerInkomen3, heeftStudieschuld3, rentevastePeriode3);
            assertTrue(maximaleHypotheek3 > 0, "Maximale hypotheek moet groter zijn dan 0.");
        }
    }


