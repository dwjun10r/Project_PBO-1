package Login;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SignUp {
    private String username;
    private String password;



    // Fungsi untuk mendaftarkan user baru
    public void daftarUserBaru() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== FORM SIGN UP =====");

        // Path ke folder akun/user
        File folderUser = new File("akun/user");
        if (!folderUser.exists()) {
            folderUser.mkdirs(); // buat folder jika belum ada
        }

        // Looping sampai user memasukkan username yang belum digunakan
        while (true) {
            System.out.print("Masukkan username: ");
            username = scanner.nextLine();

            File userFile = new File(folderUser, username + ".txt");

            if (userFile.exists()) {
                System.out.println("\nUsername sudah digunakan. Silakan coba username lain.\n");
            } else {
                break;
            }
        }

        // Setelah username valid, minta password
        System.out.print("Masukkan password: ");
        password = scanner.nextLine();

        // Simpan ke file
        File userFile = new File(folderUser, username + ".txt");
        try (FileWriter writer = new FileWriter(userFile)) {
            writer.write("Username: " + username + "\n");
            writer.write("Password: " + password + "\n");
            System.out.println("\nAkun berhasil dibuat!");
            System.out.println("Username: " + username);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data akun.");
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
