import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Saham> daftarSaham = new ArrayList<>();
        List<SBN> daftarSBN = new ArrayList<>();


        Admin admin = new Admin();
        Customer customer = new Customer();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu Utama ---");
            System.out.println("1. Masuk sebagai Admin");
            System.out.println("2. Masuk sebagai Customer");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = -1;
            boolean validInput = false;

            while (!validInput) {
                try {
                    pilihan = Integer.parseInt(scanner.nextLine());
                    if (pilihan < 1 || pilihan > 3) {
                        System.out.println("Pilihan tidak valid. Coba lagi.");
                    } else {
                        validInput = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input harus berupa angka. Coba lagi.");
                }
            }

            switch (pilihan) {
                case 1:
                    // Masuk menjadi Admin
                    System.out.println("\nMasuk sebagai Admin...");
                    admin.menuAdmin(daftarSaham, daftarSBN);
                    break;
                case 2:
                    // Masuk menjadi Customer
                    System.out.println("\nMasuk sebagai Customer...");
                    customer.menuCustomer(daftarSaham, daftarSBN);
                    break;
                case 3:
                    // Keluar
                    System.out.println("Keluar program...");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}
