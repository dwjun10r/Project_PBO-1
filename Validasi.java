import java.util.Scanner;

public class Validasi {
    private  static final Scanner scanner = new Scanner(System.in);

    // Validasi Input Int
    public static int inputInt(String pesan) {
        while (true) {
            System.out.print(pesan);
            if (scanner.hasNextInt()) {
                int nilai = scanner.nextInt();
                scanner.nextLine();
                return nilai;
            } else {
                System.out.println("-----------------------------------");
                System.out.println("Input Harus Berupa Angka. Coba Lagi.");
                scanner.nextLine();
            }
        }
    }

    // Validasi Input Double
    public static double inputDouble(String pesan) {
        while (true) {
            System.out.print(pesan);
            if (scanner.hasNextDouble()) {
                double nilai = scanner.nextDouble();
                scanner.nextLine();
                return nilai;
            } else {
                System.out.println("-----------------------------------");
                System.out.println("Input Harus Berupa Angka Desimal. Coba Lagi.");
                scanner.nextLine();
            }
        }
    }
}
