package nl.rocnijmegen;

import java.util.Scanner;

public class InputVerwerking {

    private Scanner scanner = new Scanner(System.in);

    public double vraagInkomen(String persoon) {
        System.out.printf("Voer het jaarinkomen van %s in: ", persoon);
        return scanner.nextDouble();
    }

    public boolean vraagHeeftPartner() {
        System.out.print("Heeft u een partner? (ja/nee): ");
        String antwoord = scanner.next();
        return antwoord.equalsIgnoreCase("ja");
    }

    public boolean vraagHeeftStudieschuld() {
        System.out.print("Heeft u een studieschuld? (ja/nee): ");
        String antwoord = scanner.next();
        return antwoord.equalsIgnoreCase("ja");
    }

    public int vraagRentevastePeriode() {
        System.out.print("Voer de rentevaste periode in (1, 5, 10, 20, 30 jaar): ");
        return scanner.nextInt();
    }
}
