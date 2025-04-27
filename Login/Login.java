package Login;

import java.io.File;Upd
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {
    private String username;
    private String password;

    public boolean loginUser() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== FORM LOGIN =====");
            System.out.print("Masukkan username: ");
            username = scanner.nextLine();

            File userFile = new File("akun/user", username + ".txt");

            if (!userFile.exists()) {
                System.out.println("\nAkun tidak ditemukan.");
                System.out.println("1. Coba lagi");
                System.out.println("2. Keluar");
                System.out.print("Pilih: ");
                String opsi = scanner.nextLine();
                if (opsi.equals("2")) {
                    return false;
                } else {
                    continue;
                }
            }

            // Username ditemukan, minta password dalam loop
            while (true) {
                System.out.print("Masukkan password: ");
                password = scanner.nextLine();

                try (Scanner fileScanner = new Scanner(userFile)) {
                    String fileUsername = "";
                    String filePassword = "";

                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        if (line.startsWith("Username: ")) {
                            fileUsername = line.substring(10).trim();
                        } else if (line.startsWith("Password: ")) {
                            filePassword = line.substring(10).trim();
                        }
                    }

                    if (username.equals(fileUsername) && password.equals(filePassword)) {
                        System.out.println("\nLogin berhasil! Selamat datang, " + username + ".");
                        return true;
                    } else {
                        System.out.println("\nPassword salah.");
                        System.out.println("1. Coba lagi");
                        System.out.println("2. Keluar");
                        System.out.print("Pilih: ");
                        String opsi = scanner.nextLine();
                        if (opsi.equals("2")) {
                            return false;
                        } else {
                            continue;
                        }
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("Terjadi kesalahan saat membaca file akun.");
                    e.printStackTrace();
                    return false;
                }
            }
        }
    }
}
