import java.util.Scanner;

public class Resums {

    Scanner sc;

    public Resums(Scanner sc) {
        this.sc = sc;
    }

    public void calcularHash() {
        System.out.print("Entra el missatge: ");
        String missatge = sc.nextLine();
        System.out.println("Hash: " + Hash01.sha256(missatge));
    }

    public void compararDosMissatges() {
        System.out.print("Missatge 1: ");
        String m1 = sc.nextLine();
        System.out.print("Missatge 2: ");
        String m2 = sc.nextLine();

        String h1 = Hash01.sha256(m1);
        String h2 = Hash01.sha256(m2);

        System.out.println("Hash 1: " + h1);
        System.out.println("Hash 2: " + h2);

        if (h1.equals(h2)) {
            System.out.println("Els hashes COINCIDEIXEN.");
        } else {
            System.out.println("Els hashes NO coincideixen.");
        }
    }

    public void modificarMissatge() {
        System.out.print("Missatge original: ");
        String original = sc.nextLine();
        System.out.println("Hash original:  " + Hash01.sha256(original));

        System.out.print("Missatge modificat (canvia una sola lletra): ");
        String modificat = sc.nextLine();
        System.out.println("Hash modificat: " + Hash01.sha256(modificat));
    }

    // Calcular diverses vegades el hash d'un mateix missatge
    public void repetirHash() {
        System.out.print("Entra el missatge: ");
        String missatge = sc.nextLine();

        String primer = Hash01.sha256(missatge);
        boolean iguals = true;

        for (int i = 1; i <= 5; i++) {
            String hash = Hash01.sha256(missatge);
            System.out.println("Intent " + i + ": " + hash);
            if (!hash.equals(primer)) {
                iguals = false;
            }
        }

        if (iguals) {
            System.out.println("El resultat es mante sempre igual.");
        } else {
            System.out.println("El resultat ha canviat (no hauria de passar).");
        }
    }
}
