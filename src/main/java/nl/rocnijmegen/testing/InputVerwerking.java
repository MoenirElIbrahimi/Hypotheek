package nl.rocnijmegen.testing;

import java.util.Scanner;

public class InputVerwerking {

    private Scanner scanner = new Scanner(System.in);



    public class PostcodeChecker {

        // Correcte methode: 'Postcode' zonder hoofdletter P bij aanroepen
        public int postcode() {
            Scanner scanner = new Scanner(System.in); // Maak een Scanner-object
            System.out.print("Vul je postcode nummer in: ");
            int antwoord = scanner.nextInt(); // Gebruik 'int' voor het vastleggen van een geheel getal

            // Vergelijking met meerdere waarden
            if (antwoord == 9679 || antwoord == 9681 || antwoord == 9682) {
                return antwoord; // Retourneer de postcode als deze overeenkomt
            } else {
                System.out.println("Ongeldige postcode.");
                return -1; // Geeft -1 terug als de postcode ongeldig is
            }
        }

        public static void main(String[] args) {
            PostcodeChecker checker = new PostcodeChecker();  // Klasse correct aangeroepen
            int result = checker.postcode();  // Let op de kleine letter 'p' in postcode()

            if (result != -1) {
                System.out.println("Geldige postcode: " + result);
            }
        }
    }

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
