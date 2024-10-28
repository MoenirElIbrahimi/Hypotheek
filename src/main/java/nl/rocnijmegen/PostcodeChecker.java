package nl.rocnijmegen;

import java.util.Scanner;

public class PostcodeChecker {

    // Methode met parameter voor testen
    public int postcode(int antwoord) {
        // Controleer of de ingevoerde postcode ongeldig is
        if (antwoord == 9679 || antwoord == 9681 || antwoord == 9682) {
            System.out.println("Ongeldige postcode.");
            return -1;
        } else {
            return antwoord;
        }
    }

    // Methode zonder parameter voor gebruik met Scanner
    public int postcode() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vul je postcode nummer in: ");
        int antwoord = scanner.nextInt();
        return postcode(antwoord);  // Hergebruik de parameter-methode
    }

    public static void main(String[] args) {
        PostcodeChecker checker = new PostcodeChecker();
        int result = checker.postcode();

        if (result != -1) {
            System.out.println("Geldige postcode: " + result);
        }
    }
}
