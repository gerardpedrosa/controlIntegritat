import java.util.Scanner;

public class Usuaris {

    Scanner sc;

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
    }

    public void iniciarSessio() {
    }
}