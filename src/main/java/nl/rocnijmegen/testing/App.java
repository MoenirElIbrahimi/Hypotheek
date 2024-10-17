package nl.rocnijmegen.testing;

public class App {

    public static void main(String[] args) {

        InputVerwerking inputVerwerking = new InputVerwerking();
        HypotheekService hypotheekService = new HypotheekService();

        // Vraag het inkomen van de klant
        double inkomen = inputVerwerking.vraagInkomen("uzelf");

        // Vraag het inkomen van de partner indien van toepassing
        double partnerInkomen = 0.0;
        if (inputVerwerking.vraagHeeftPartner()) {
            partnerInkomen = inputVerwerking.vraagInkomen("uw partner");
        }

        // Vraag of de klant een studieschuld heeft
        boolean heeftStudieschuld = inputVerwerking.vraagHeeftStudieschuld();

        // Vraag naar de rentevaste periode
        int rentevastePeriode = inputVerwerking.vraagRentevastePeriode();

        // Bereken de maximale hypotheek
        double maximaleHypotheek = hypotheekService.berekenMaximaleHypotheek(inkomen, partnerInkomen, heeftStudieschuld, rentevastePeriode);

        // Bereken de maandelijkse rente
        double rentePerMaand = hypotheekService.berekenRentePerMaand(maximaleHypotheek, rentevastePeriode);

        // Bereken de maandelijkse aflossing
        double aflossingPerMaand = hypotheekService.berekenAflossingPerMaand(maximaleHypotheek, 30);  // 30 jaar looptijd

        // Bereken de totale maandlasten
        double totaleMaandLasten = rentePerMaand + aflossingPerMaand;

        // Bereken het totaal betaald bedrag na 30 jaar
        double totaalBetaald = hypotheekService.berekenTotaalBetaald(totaleMaandLasten, 30);  // 30 jaar looptijd

        // Toon het resultaat
        System.out.printf("U kunt maximaal €%.2f lenen.%n", maximaleHypotheek);
        System.out.printf("Rente per maand: €%.2f%n", rentePerMaand);
        System.out.printf("Aflossing per maand: €%.2f%n", aflossingPerMaand);
        System.out.printf("Totale maandlasten: €%.2f%n", totaleMaandLasten);
        System.out.printf("Totaal betaald bedrag na %d jaar: €%.2f%n", rentevastePeriode, totaalBetaald);
    }
}
