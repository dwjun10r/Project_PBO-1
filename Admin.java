import java.util.*;

public class Admin {
    private Scanner scanner = new Scanner(System.in);

    // Menampilkan menu untuk Admin
    public void menuAdmin(List<Saham> daftarSaham, List<SBN> daftarSBN) {
        while (true) {
            System.out.println("\n===================================");
            System.out.println("|             Menu Admin          |");
            System.out.println("===================================");
            System.out.println("1. Saham");
            System.out.println("2. SBN");
            System.out.println("3. Logout");
            System.out.println("===================================");
            int pilihan = Validasi.inputInt("Pilih Menu: ");

            switch (pilihan) {
                case 1:
                    menuSaham(daftarSaham);
                    break;
                case 2:
                    menuSBN(daftarSBN);
                    break;
                case 3:
                    System.out.println("Logout dari admin.\n");
                    return;
                default:
                    System.out.println("-----------------------------------");
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    // Menu Saham
    private void menuSaham(List<Saham> daftarSaham) {
        while (true) {
            System.out.println("\n===================================");
            System.out.println("|               Saham             |");
            System.out.println("===================================");
            System.out.println("1. Tambah Saham");
            System.out.println("2. Ubah Harga Saham");
            System.out.println("3. Kembali");
            System.out.println("===================================");
            int  pilihan = Validasi.inputInt("Pilih Menu: ");

            switch (pilihan) {
                case 1:
                    tambahSaham(daftarSaham);
                    break;
                case 2:
                    ubahHargaSaham(daftarSaham);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("-----------------------------------");
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    // Menu SBN
    private void menuSBN(List<SBN> daftarSBN) {
        while (true) {
            System.out.println("\n===================================");
            System.out.println("|                 SBN             |");
            System.out.println("===================================");
            System.out.println("1. Tambah Produk SBN");
            System.out.println("2. Kembali");
            int   pilihan = Validasi.inputInt("Pilih Menu: ");

            switch (pilihan) {
                case 1:
                    tambahSBN(daftarSBN);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("-----------------------------------");
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    // Tambah Saham
    private  void tambahSaham(List<Saham> daftarSaham) {
        System.out.println("\n===================================");
        System.out.println("|            Tambah Saham         |");
        System.out.println("===================================");
        System.out.print("Masukkan Kode Saham: ");
        String kodeSaham = scanner.nextLine();
        System.out.print("Masukkan nama perusahaan: ");
        String namaPerusahaan = scanner.nextLine();
        double hargaSaham = Validasi.inputDouble("Masukkan Harga Saham: ");

        daftarSaham.add(new Saham(kodeSaham, namaPerusahaan, hargaSaham));
        System.out.println("-----------------------------------");
        System.out.println("Saham Berhasil Ditambahkan");
    }

    // Ubah Harga Saham
    private void ubahHargaSaham(List<Saham> daftarSaham) {
        if (daftarSaham.isEmpty()) {
            System.out.println("-----------------------------------");
            System.out.println("Belum Ada Saham Yang Tersedia.");
            return;
        }
        System.out.println("\n===================================");
        System.out.println("|            Daftar Saham         |");
        System.out.println("===================================");
        for (Saham saham : daftarSaham) {
            System.out.println(saham);
        }

        System.out.print("\nMasukkan Kode Saham Yang Ingin Diubah Harganya: ");
        String kodeSaham = scanner.nextLine();

        for (Saham saham : daftarSaham) {
            if (saham.getKode().equalsIgnoreCase(kodeSaham)) {
                double hargaBaru = Validasi.inputDouble("Masukkan Harga Baru: ");
                saham.setHarga(hargaBaru);
                System.out.println("-----------------------------------");
                System.out.println("Harga Saham Berhasil Diubah!");
                return;
            }
        }
        System.out.println("-----------------------------------");
        System.out.println("Saham Dengan Kode Tersebut Tidak Ditemukan.");
    }

    // Tambah SBN
    private void tambahSBN(List<SBN> daftarSBN) {
        System.out.println("\n===================================");
        System.out.println("|            Tambah SBN           |");
        System.out.println("===================================");
        System.out.print("Masukkan Nama SBN: ");
        String namaSBN = scanner.nextLine();
        double bunga = Validasi.inputDouble("Masukkan Bunga SBN (% per tahun): ");
        int jangkaWaktu = Validasi.inputInt("Masukkan Jangka Waktu (tahun): ");
        System.out.print("Masukkan Tanggal Jatuh Tempo: ");
        String tanggalJatuhTempo = scanner.nextLine();
        double koutaNasional = Validasi.inputDouble("Masukkan Kouta Nasional: ");

        daftarSBN.add(new SBN(namaSBN, bunga, jangkaWaktu, tanggalJatuhTempo, koutaNasional));
        System.out.println("-----------------------------------");
        System.out.println("SBN Berhasil Ditambahkan");
        }
}


