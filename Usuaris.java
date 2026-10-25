import java.util.Scanner;
import java.util.HashMap;

public class Usuaris {

    Scanner sc;
    HashMap<String, Usuari> usuaris = new HashMap<>();

    public Usuaris(Scanner sc) {
        this.sc = sc;
    }

    public void menuUsuaris() {

        int opcio;

        do {

            System.out.println();
            System.out.println("--- USUARIS ---");
            System.out.println("1. Registrar usuari");
            System.out.println("2. Iniciar sessio");
            System.out.println("0. Tornar enrere");
            System.out.print("Opcio: ");

            String entrada = sc.nextLine();

            try {
                opcio = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcio = -1;
            }

            switch (opcio) {

                case 1:
                    registrar();
                    break;

                case 2:
                    iniciarSessio();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcio incorrecta.");
                    break;
            }

        } while (opcio != 0);

    }

    
    public void registrar() {
        
        System.out.print("Nom d'usuari: ");
        String nom = sc.nextLine();

        if (nom.isEmpty()) {
            System.out.println("El nom no pot estar buit.");
            return;
        }

        if (usuaris.containsKey(nom)) {
            System.out.println("Aquest usuari ja existeix.");
            return;
        }

        System.out.print("Contrasenya: ");
        String contrasenya = sc.nextLine();

        byte[] salt = Hash01.generarSalt();
        String hash = Hash01.hashAmbSalt(contrasenya, salt);

        usuaris.put(nom, new Usuari(nom, salt, hash));

        System.out.println("Usuari registrat correctament.");
        System.out.println("Salt: " + Hash01.saltAHex(salt));
        System.out.println("Hash: " + hash);
    }

    public void iniciarSessio() {
        
        System.out.print("Nom d'usuari: ");
        String nom = sc.nextLine();

        System.out.print("Contrasenya: ");
        String contrasenya = sc.nextLine();

        Usuari u = usuaris.get(nom);

        if (u == null) {
            System.out.println("Usuari o contrasenya incorrectes.");
            return;
        }

        String hashCalculat = Hash01.hashAmbSalt(contrasenya, u.salt);

        if (hashCalculat.equals(u.hash)) {
            System.out.println("Acces concedit. Benvingut, " + nom + "!");
        } else {
            System.out.println("Usuari o contrasenya incorrectes.");
        }
    }
}