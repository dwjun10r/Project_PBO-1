import java.util.*;
import java.io.*;

public class Admin {
    private Scanner scanner = new Scanner(System.in);

    // Menampilkan menu untuk Admin
    public void menuAdmin(List<Saham> daftarSaham, List<SBN> daftarSBN) {
        // Muat daftar saham dari file
        daftarSaham.addAll(bacaSaham());

        while (true) {
            System.out.println("\n--- Menu Admin ---");
            System.out.println("1. Tambah Saham");
            System.out.println("2. Tambah SBN");
            System.out.println("3. Lihat Daftar Saham");
            System.out.println("4. Lihat Daftar SBN");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

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
                    // Simpan daftar saham ke file saat keluar
                    simpanSaham(daftarSaham);
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

        Saham sahamBaru = new Saham(kode, namaPerusahaan, harga);
        daftarSaham.add(sahamBaru);
        System.out.println("Saham berhasil ditambahkan!");

        // Simpan daftar saham ke file setelah menambah saham
        simpanSaham(daftarSaham);
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

    // Menyimpan daftar saham ke file
    private void simpanSaham(List<Saham> daftarSaham) {
        try (FileWriter writer = new FileWriter("saham.txt")) {
            for (Saham saham : daftarSaham) {
                writer.write(saham.getKode() + "," + saham.getNamaPerusahaan() + "," + saham.getHarga() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan saham: " + e.getMessage());
        }
    }

    // Membaca daftar saham dari file
    private List<Saham> bacaSaham() {
        List<Saham> daftarSaham = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("saham.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String kode = data[0];
                String namaPerusahaan = data[1];
                double harga = Double.parseDouble(data[2]);
                daftarSaham.add(new Saham(kode, namaPerusahaan, harga));
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca saham: " + e.getMessage());
        }
        return daftarSaham;
    }
}
