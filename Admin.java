import java.util.*;

public class Admin {
    private Scanner scanner = new Scanner(System.in);

    // Menampilkan menu untuk Admin
    public void menuAdmin(List<Saham> daftarSaham, List<SBN> daftarSBN) {
        while (true) {
            System.out.println("\n--- Menu Admin ---");
            System.out.println("1. Tambah Saham");
            System.out.println("2. Tambah SBN");
            System.out.println("3. Lihat Daftar Saham");
            System.out.println("4. Lihat Daftar SBN");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline

            switch (pilihan) {
                case 1:
                    tambahSaham(daftarSaham);
                    break;
                case 2:
                    tambahSBN(daftarSBN);
                    break;
                case 3:
                    lihatDaftarSaham(daftarSaham);
                    break;
                case 4:
                    lihatDaftarSBN(daftarSBN);
                    break;
                case 5:
                    System.out.println("Keluar dari menu Admin.\n");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    // Menambah saham baru
    private void tambahSaham(List<Saham> daftarSaham) {
        System.out.println("\n--- Tambah Saham ---");
        System.out.print("Masukkan kode saham: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan nama perusahaan: ");
        String namaPerusahaan = scanner.nextLine();
        System.out.print("Masukkan harga saham: ");
        double harga = scanner.nextDouble();
        scanner.nextLine(); // konsumsi newline

        daftarSaham.add(new Saham(kode, namaPerusahaan, harga));
        System.out.println("Saham berhasil ditambahkan!");
    }

    // Menambah SBN baru
    private void tambahSBN(List<SBN> daftarSBN) {
        System.out.println("\n--- Tambah SBN ---");
        System.out.print("Masukkan nama SBN: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan bunga SBN: ");
        double bunga = scanner.nextDouble();
        System.out.print("Masukkan jangka waktu (dalam tahun): ");
        int jangkaWaktu = scanner.nextInt();
        scanner.nextLine(); // konsumsi newline
        System.out.print("Masukkan tanggal jatuh tempo: ");
        String tanggalJatuhTempo = scanner.nextLine();
        System.out.print("Masukkan kuota nasional: ");
        double kuotaNasional = scanner.nextDouble();

        daftarSBN.add(new SBN(nama, bunga, jangkaWaktu, tanggalJatuhTempo, kuotaNasional));
        System.out.println("SBN berhasil ditambahkan!");
    }

    // Menampilkan daftar saham
    private void lihatDaftarSaham(List<Saham> daftarSaham) {
        System.out.println("\n--- Daftar Saham ---");
        if (daftarSaham.isEmpty()) {
            System.out.println("Tidak ada saham.");
        } else {
            for (Saham saham : daftarSaham) {
                System.out.println(saham);
            }
        }
    }

    // Menampilkan daftar SBN
    private void lihatDaftarSBN(List<SBN> daftarSBN) {
        System.out.println("\n--- Daftar SBN ---");
        if (daftarSBN.isEmpty()) {
            System.out.println("Tidak ada SBN.");
        } else {
            for (SBN sbn : daftarSBN) {
                System.out.println(sbn);
            }
        }
    }
}
