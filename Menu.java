import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    Resums resums = new Resums(sc);

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.principal();
    }

    public void principal() {

        int opcio;

        do {

            System.out.println();
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Calcul de resums (Part 1)");
            System.out.println("2. Verificar integritat d'un missatge (Part 2)");
            System.out.println("3. Usuaris: registre i inici de sessio (Parts 3 i 4)");
            System.out.println("4. Proves de la practica (Part 5)");
            System.out.println("0. Sortir");
            System.out.print("Opcio: ");

            String entrada = sc.nextLine();

            try {
                opcio = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcio = -1;
            }

            switch (opcio) {

                case 1:
                    menuResums();
                    break;

                case 2:
                    verificarIntegritat();
                    break;

                case 3:
                    menuUsuaris();
                    break;

                case 4:
                    menuProves();
                    break;

                case 0:
                    System.out.println("Sortint...");
                    break;

                default:
                    System.out.println("Opcio incorrecta.");
                    break;
            }

        } while (opcio != 0);

    }

    public void menuResums() {

        int opcio;

        do {

            System.out.println();
            System.out.println("--- CALCUL DE RESUMS (SHA-256) ---");
            System.out.println("1. Calcular el hash d'un missatge");
            System.out.println("2. Comparar els hashes de dos missatges");
            System.out.println("3. Modificar un missatge i tornar a calcular el hash");
            System.out.println("4. Repetir el hash d'un mateix missatge");
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
                    resums.calcularHash();
                    break;

                case 2:
                    resums.compararDosMissatges();
                    break;

                case 3:
                    resums.modificarMissatge();
                    break;

                case 4:
                    resums.repetirHash();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcio incorrecta.");
                    break;
            }

        } while (opcio != 0);

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
                    registrarUsuari();
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

    public void menuProves() {

        int opcio;

        do {

            System.out.println();
            System.out.println("--- PROVES DE LA PRACTICA ---");
            System.out.println("1. Dos usuaris amb la mateixa contrasenya");
            System.out.println("2. Verificar amb una salt diferent de la guardada");
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
                    provaMateixaContrasenya();
                    break;

                case 2:
                    provaSaltDiferent();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcio incorrecta.");
                    break;
            }

        } while (opcio != 0);

    }

    public void verificarIntegritat() {
        //
    }


    public void registrarUsuari() {
        //
    }

    public void iniciarSessio() {
        //
    }

    
    public void provaMateixaContrasenya() {
        //
    }

    public void provaSaltDiferent() {
        //
    }
}