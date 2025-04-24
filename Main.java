import java.util.Scanner;
import Login.Login;
import Login.SignUp;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        while (true) {
            System.out.println("==== MENU UTAMA ====");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Masukkan pilihan: ");

            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();

                if (pilihan >= 1 && pilihan <= 3) {
                    break;
                } else {
                    System.out.println("Pilihan harus 1, 2, atau 3. Coba lagi.\n");
                }
            } else {
                System.out.println("Input harus berupa angka. Coba lagi.\n");
                scanner.next();
            }
        }


        switch (pilihan) {
            case 1: {
                Login login = new Login();
                login.loginUser();
                break;
            }
            case 2: {
                SignUp signUp = new SignUp();
                signUp.daftarUserBaru();
                break;
            }
            case 3: {
                System.out.println("Keluar dari program.");
                break;
            }
            default: {
                System.out.println("Pilihan tidak valid.");
                break;
            }
        }

        scanner.close();
    }
}
