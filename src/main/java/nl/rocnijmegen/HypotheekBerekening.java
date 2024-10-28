package nl.rocnijmegen;

public class HypotheekBerekening {

    public static double berekenMaximaleHypotheek(double inkomen, double partnerInkomen, boolean heeftStudieschuld, int rentevastePeriode) {
        double maximaalInkomen = (inkomen + partnerInkomen) * 4.25;

        // Als de klant een studieschuld heeft, wordt het maximaal te lenen bedrag met 25% verminderd
        if (heeftStudieschuld) {
            maximaalInkomen *= 0.75;
        }

        // Controleer of de rentevaste periode geldig is
        double rentePercentage = getRentePercentage(rentevastePeriode);
        if (rentePercentage == -1) {
            throw new IllegalArgumentException("Ongeldige rentevaste periode. Kies 1, 5, 10, 20 of 30 jaar.");
        }

        return maximaalInkomen;
    }

    public static double berekenRentePerMaand(double hypotheekBedrag, int rentevastePeriode) {
        double rentePercentage = getRentePercentage(rentevastePeriode);
        return hypotheekBedrag * rentePercentage / 12;  // Maandelijkse rente
    }

    public static double berekenAflossingPerMaand(double hypotheekBedrag, int looptijdJaren) {
        int looptijdMaanden = looptijdJaren * 12;  // Aantal maanden
        return hypotheekBedrag / looptijdMaanden;  // Maandelijkse aflossing
    }

    public static double berekenTotaalBetaald(double maandLasten, int looptijdJaren) {
        int looptijdMaanden = looptijdJaren * 12;  // Aantal maanden
        return maandLasten * looptijdMaanden;  // Totaal betaald bedrag
    }

    private static double getRentePercentage(int rentevastePeriode) {
        switch (rentevastePeriode) {
            case 1:
                return 0.02;  // 2% voor 1 jaar
            case 5:
                return 0.03;  // 3% voor 5 jaar
            case 10:
                return 0.035; // 3.5% voor 10 jaar
            case 20:
                return 0.045; // 4.5% voor 20 jaar
            case 30:
                return 0.05;  // 5% voor 30 jaar
            default:
                return -1;    // Ongeldige periode
        }
    }
}
