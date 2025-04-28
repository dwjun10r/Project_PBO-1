import java.util.*;

public class Customer {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Integer> sahamDimiliki = new HashMap<>();
    private Map<String, Double> sbnDimiliki = new HashMap<>();

    public void menuCustomer(List<Saham> daftarSaham, List<SBN> daftarSBN) {

        while (true) {
            System.out.println("\n--- Menu Customer ---");
            System.out.println("1. Lihat Daftar Saham");
            System.out.println("2. Lihat Daftar SBN");
            System.out.println("3. Beli Saham");
            System.out.println("4. Beli SBN");
            System.out.println("5. Portofolio");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = -1;
            boolean validInput = false;

            // Validasi input untuk menu Customer
            while (!validInput) {
                try {
                    pilihan = Integer.parseInt(scanner.nextLine());
                    if (pilihan < 1 || pilihan > 6) {
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
                    lihatDaftarSaham(daftarSaham);
                    break;
                case 2:
                    lihatDaftarSBN(daftarSBN);
                    break;
                case 3:
                    beliSaham(daftarSaham);
                    break;
                case 4:
                    beliSBN(daftarSBN);
                    break;
                case 5:
                    lihatPortofolio(daftarSaham, daftarSBN);
                    break;
                case 6:
                    System.out.println("Keluar.\n");
                    return;
                default:
                    System.out.println("Pilih tidak valid. Coba lagi.");
            }
        }
    }

    // Melihat daftar saham yang tersedia
    private void lihatDaftarSaham(List<Saham> daftarSaham) {
        System.out.println("\n--- Daftar Saham Tersedia ---");
        if (daftarSaham.isEmpty()) {
            System.out.println("Tidak ada saham tersedia.");
            return;
        }
        for (int i = 0; i < daftarSaham.size(); i++) {
            Saham s = daftarSaham.get(i);
            System.out.println((i + 1) + ". " + s.getKode() + " - " + s.getNamaPerusahaan() + " - Rp" + s.getHarga());
        }
    }

    // Melihat daftar SBN yang tersedia
    private void lihatDaftarSBN(List<SBN> daftarSBN) {
        System.out.println("\n--- Daftar SBN Tersedia ---");
        if (daftarSBN.isEmpty()) {
            System.out.println("Tidak ada SBN tersedia.");
            return;
        }
        for (int i = 0; i < daftarSBN.size(); i++) {
            SBN sbn = daftarSBN.get(i);
            System.out.println((i + 1) + ". " + sbn.getNama() + " - Bunga: " + sbn.getBunga() + "% - Kuota: Rp" + sbn.getKuotaNasional());
        }
    }

    // Membeli saham
    private void beliSaham(List<Saham> daftarSaham) {
        System.out.println("\n--- Beli Saham ---");
        if (daftarSaham.isEmpty()) {
            System.out.println("Tidak ada saham tersedia.");
            return;
        }
        for (int i = 0; i < daftarSaham.size(); i++) {
            Saham s = daftarSaham.get(i);
            System.out.println((i + 1) + ". " + s.getKode() + " - " + s.getNamaPerusahaan() + " - Rp" + s.getHarga());
        }

        System.out.print("Pilih nomor saham: ");
        int pilihan = scanner.nextInt();
        if (pilihan < 1 || pilihan > daftarSaham.size()) {
            System.out.println("Pilih tidak valid.");
            return;
        }
        Saham sahamDipilih = daftarSaham.get(pilihan - 1);

        System.out.print("Masukkan jumlah lembar: ");
        int jumlah = scanner.nextInt();

        sahamDimiliki.put(sahamDipilih.getKode(), sahamDimiliki.getOrDefault(sahamDipilih.getKode(), 0) + jumlah);

        System.out.println("Pembelian berhasil!");
    }

    // Membeli SBN
    private void beliSBN(List<SBN> daftarSBN) {
        System.out.println("\n--- Beli SBN ---");
        if (daftarSBN.isEmpty()) {
            System.out.println("Tidak ada SBN tersedia.");
            return;
        }
        for (int i = 0; i < daftarSBN.size(); i++) {
            SBN sbn = daftarSBN.get(i);
            System.out.println((i + 1) + ". " + sbn.getNama() + " - Bunga: " + sbn.getBunga() + "% - Kuota: Rp" + sbn.getKuotaNasional());
        }

        System.out.print("Pilih nomor SBN: ");
        int pilihan = scanner.nextInt();
        if (pilihan < 1 || pilihan > daftarSBN.size()) {
            System.out.println("Pilih tidak valid.");
            return;
        }
        SBN sbnDipilih = daftarSBN.get(pilihan - 1);

        System.out.print("Masukkan nominal pembelian: ");
        double nominal = scanner.nextDouble();

        if (nominal < sbnDipilih.getKuotaNasional()) {
            System.out.println("Gagal. Kuota tidak mencukupi.");
            return;
        }

        sbnDipilih.setKuotaNasional(sbnDipilih.getKuotaNasional() - nominal);
        sbnDimiliki.put(sbnDipilih.getNama(), sbnDimiliki.getOrDefault(sbnDipilih.getNama(), 0.0) + nominal);

        System.out.println("Pembelian SBN berhasil!");
    }

    // Melihat portofolio
    private void lihatPortofolio(List<Saham> daftarSaham, List<SBN> daftarSBN) {
        System.out.println("\n--- Portofolio Investasi ---");

        // Menampilkan saham yang dimiliki
        System.out.println("\nSaham Dimiliki: ");
        if (sahamDimiliki.isEmpty()) {
            System.out.println("Tidak ada saham.");
        } else {
            double totalPembelian = 0;
            double totalPasar = 0;
            for (String kode : sahamDimiliki.keySet()) {
                int jumlah = sahamDimiliki.get(kode);
                Saham saham = null;
                for (Saham s : daftarSaham) {
                    if (s.getKode().equalsIgnoreCase(kode)) {
                        saham = s;
                        break;
                    }
                }
                if (saham != null) {
                    double hargaSekarang = saham.getHarga();
                    System.out.println(kode + " - " + jumlah + " lembar - Harga sekarang: Rp" + hargaSekarang);
                    totalPembelian += hargaSekarang * jumlah;
                    totalPasar += hargaSekarang * jumlah;
                }
            }
            System.out.println("Total nilai pasar saham: Rp" + totalPasar);
        }

        // Menampilkan SBN yang dimiliki
        System.out.println("\nSBN Dimiliki: ");
        if (sbnDimiliki.isEmpty()) {
            System.out.println("Tidak ada SBN.");
        } else {
            for (String nama : sbnDimiliki.keySet()) {
                double nominal = sbnDimiliki.get(nama);
                double bungaBulanan = 0;
                for (SBN s : daftarSBN) {
                    if (s.getNama().equalsIgnoreCase(nama)) {
                        bungaBulanan = (s.getBunga() / 100.0 / 12.0 * 0.9 * nominal);
                        break;
                    }
                }
                System.out.println(nama + " - Nominal: Rp" + nominal + " - Kupon bulanan: Rp" + bungaBulanan);
            }
        }
    }
}
