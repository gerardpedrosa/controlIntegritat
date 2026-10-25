import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Integritat {

    Scanner sc;

    public Integritat(Scanner sc) {
        this.sc = sc;
    }

    public void verificar() {

        try {
            System.out.print("Emissor, escriu el missatge: ");
            String missatge = sc.nextLine();

            Files.writeString(Path.of("missatge.txt"), missatge,
                    StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Missatge guardat a missatge.txt");

            String hashOriginal = Hash01.sha256(missatge);
            Files.writeString(Path.of("missatge.hash"), hashOriginal,
                    StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Hash original guardat a missatge.hash: " + hashOriginal);

            System.out.println();
            System.out.println("Enviant missatge...");
            System.out.println("Missatge rebut pel receptor.");
            System.out.println();

            System.out.print("Nom del fitxer rebut (missatge.txt o missatgeCanviat.txt): ");
            String nomFitxer = sc.nextLine();

            if (!Files.exists(Path.of(nomFitxer))) {
                System.out.println("El fitxer " + nomFitxer + " no existeix.");
                return;
            }

            byte[] contingutRebut = Files.readAllBytes(Path.of(nomFitxer));
            String hashRebut = Hash01.sha256(contingutRebut);
            String hashGuardat = Files.readString(Path.of("missatge.hash")).trim();

            System.out.println("Hash original: " + hashGuardat);
            System.out.println("Hash rebut:    " + hashRebut);

            if (hashRebut.equals(hashGuardat)) {
                System.out.println("INTEGRITAT CORRECTA: els hashes coincideixen.");
            } else {
                System.out.println("MODIFICACIO DETECTADA: els hashes no coincideixen.");
            }

        } catch (IOException e) {
            System.out.println("Error amb el fitxer: " + e.getMessage());
        }
    }
}