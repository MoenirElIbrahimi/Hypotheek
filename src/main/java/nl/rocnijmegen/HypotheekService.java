package nl.rocnijmegen;

public class HypotheekService {
    private final HypotheekBerekening hypotheekBerekening;

    public HypotheekService() {
        this.hypotheekBerekening = new HypotheekBerekening();
    }

    // Voeg de methode om de maximale hypotheek te berekenen
    public double berekenMaximaleHypotheek(double inkomen, double partnerInkomen, boolean heeftStudieschuld, int rentevastePeriode) {
        return hypotheekBerekening.berekenMaximaleHypotheek(inkomen, partnerInkomen, heeftStudieschuld, rentevastePeriode);
    }

    // Voeg de methode om de rente per maand te berekenen
    public double berekenRentePerMaand(double hypotheekBedrag, int rentevastePeriode) {
        return hypotheekBerekening.berekenRentePerMaand(hypotheekBedrag, rentevastePeriode);
    }

    // Voeg de methode om de aflossing per maand te berekenen
    public double berekenAflossingPerMaand(double hypotheekBedrag, int looptijdJaren) {
        return hypotheekBerekening.berekenAflossingPerMaand(hypotheekBedrag, looptijdJaren);
    }

    // Voeg de methode om het totaal betaald bedrag te berekenen
    public double berekenTotaalBetaald(double maandLasten, int looptijdJaren) {
        return hypotheekBerekening.berekenTotaalBetaald(maandLasten, looptijdJaren);
    }
}
