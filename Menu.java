import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    Resums resums = new Resums(sc);
    Integritat integritat = new Integritat(sc);
    Usuaris usuaris = new Usuaris(sc);

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
                    resums.menu();
                    break;

                case 2:
                    integritat.verificar();
                    break;

                case 3:
                    usuaris.menuUsuaris();
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
}