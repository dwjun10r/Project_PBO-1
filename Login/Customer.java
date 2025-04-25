package Login;

import java.util.*;

public class Customer {
    String username;
    String password;
    Map<String, Integer> portofolioSaham = new HashMap<>();
    Map<String, Double> portofolioSBN = new HashMap<>();

    Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    void menu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Menu Customer ---");
            System.out.println("1. Beli Saham");
            System.out.println("2. Jual Saham");
            System.out.println("3. Beli SBN");
            System.out.println("4. Simulasi SBN");
            System.out.println("5. Portofolio");
            System.out.println("6. Logout" );
            System.out.println("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 6) return;


        }
    }
}
