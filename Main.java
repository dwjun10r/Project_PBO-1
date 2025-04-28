import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    // Akun default
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String CUSTOMER_USERNAME = "user";
    private static final String CUSTOMER_PASSWORD = "user123";

    public static void main(String[] args) {
        List<Saham> daftarSaham = new ArrayList<>();
        List<SBN> daftarSBN = new ArrayList<>();

        Admin admin = new Admin();
        Customer customer = new Customer();

        while (true) {
            System.out.println("===================================");
            System.out.println("|     INVESTASI SAHAM DAN SBN     |");
            System.out.println("===================================");
            System.out.println("===================================");
            System.out.println("|            Menu Utama           |");
            System.out.println("===================================");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Customer");
            System.out.println("3. Keluar");
            System.out.println("===================================");
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
                    if (loginAdmin()) {
                        admin.menuAdmin(daftarSaham, daftarSBN);
                    } else {
                        System.out.println("Login Admin gagal!");
                    }
                    break;
                case 2:
                    if (loginCustomer()) {
                        customer.menuCustomer(daftarSaham, daftarSBN);
                    } else {
                        System.out.println("Login Customer gagal!");
                    }
                    break;
                case 3:
                    System.out.println("Keluar dari program...");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static boolean loginAdmin() {
        System.out.println("\n===================================");
        System.out.println("|           LOGIN ADMIN           |");
        System.out.println("===================================");
        System.out.print("Masukkan username Admin: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password Admin: ");
        String password = scanner.nextLine();

        return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }

    private static boolean loginCustomer() {
        System.out.print("\nMasukkan username Customer: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password Customer: ");
        String password = scanner.nextLine();

        return username.equals(CUSTOMER_USERNAME) && password.equals(CUSTOMER_PASSWORD);
    }
}
