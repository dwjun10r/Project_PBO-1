package Login;

import Saham.Saham;
import SBN.SBN;

import java.util.*;

public class Customer {
    private Scanner scanner = new Scanner(System.in);
    private  Map<String, Integer> sahamDimiliki = new HashMap<>();
    private  Map<String, Double> sbnDimiliki = new HashMap<>();

    public void menuCustomer(List<Saham> daftarSaham, List<SBN> daftarSBN) {
        while (true) {
            System.out.println("\n--- Menu Customer ---");
            System.out.println("1. Beli Saham");
            System.out.println("2. Jual Saham");
            System.out.println("3. Beli SBN");
            System.out.println("4. Simulasi SBN");
            System.out.println("5. Portofolio");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    beliSaham(daftarSaham);
                    break;
                case 2:
                    jualSaham(daftarSaham);
                    break;
                case 3:
                    beliSBN(daftarSBN);
                    break;
                case 4:
                    simulasiSBN(daftarSBN);
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

    private void beliSaham(List<Saham> daftarSaham) {
        System.out.println("\n--- Beli Saham ---");
        if (daftarSaham.isEmpty()) {
            System.out.println("Tidak ada saham tersedia.");
            return;
        }
        for (int i = 0; i < daftarSaham.size(); i++) {
            Saham s = daftarSaham.get(i);
            System.out.println((i + 1) + ". " + s.getKode() + " - " + s.getNamaPerusahaan() + " - Rp" +s.getHarga());
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

    private void jualSaham(List<Saham> daftarSBN) {
        System.out.println("\n--- Jual Saham ---");
        if (sahamDimiliki.isEmpty()) {
            System.out.println("Anda tidak memiliki saham.");
            return;
        }
        List<String> kodeSahamList = new ArrayList<>(sahamDimiliki.keySet());
        for (int i = 0; i < kodeSahamList.size(); i++) {
            String kode = kodeSahamList.get(i);
            System.out.println((i + 1) +  ". " + kode + " - " + sahamDimiliki.get(kode) + " lembar");
        }

        System.out.print("Pilih nomor saham yang ingin dijual: ");
        int pilihan = scanner.nextInt();
        if (pilihan < 1 || pilihan > kodeSahamList.size()) {
            System.out.println("Pilih tidak valid.");
            return;
        }
        String kodeDipilih =  kodeSahamList.get(pilihan - 1);

        System.out.print("Masukkan jumlah lembar yang ingin dijual: ");
        int jumlahJual = scanner.nextInt();

        int jumlahDimiliki = sahamDimiliki.get(kodeDipilih);
        if (jumlahJual > jumlahDimiliki) {
            System.out.println("Gagal. Anda hanya memiliki " + jumlahDimiliki + " lembar.");
            return;
        } else if (jumlahJual == jumlahDimiliki) {
            sahamDimiliki.remove(kodeDipilih);
        } else {
            sahamDimiliki.put(kodeDipilih, jumlahDimiliki -  jumlahJual);
        }
        System.out.println("Penjualan berhasil!");
    }

    private void beliSBN(List<SBN> daftarSBN) {
        System.out.println("\n--- Beli SBN ---");
        if (daftarSBN.isEmpty()) {
            System.out.println("Tidak ada SBN tersedia.");
            return;
        }
        for (int i = 0; i < daftarSBN.size(); i++) {
            SBN sbn = daftarSBN.get(i);
            System.out.println((i + 1) + ". " + sbn.getNama() + " - Bunga: " + sbn.getBunga() + "% - kouta: Rp" + sbn.getKuotaNasional());
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
            System.out.println("Gagal. Kouta tidak mencukupi.");
            return;
        }

        sbnDipilih.setKuotaNasional(sbnDipilih.getKuotaNasional() - nominal);
        sbnDimiliki.put(sbnDipilih.getNama(), sbnDimiliki.getOrDefault(sbnDipilih.getNama(), 0.0) + nominal);

        System.out.println("Pembelian SBN berhasil!");
    }

    private void simulasiSBN(List<SBN> daftarSBN) {
        System.out.println("\n--- Simulasi SBN ---");
        if (daftarSBN.isEmpty()) {
            System.out.println("Tidak ada SBN tersedia.");
            return;
        }
        System.out.print("Masukkan nama SBN: ");
        String nama = scanner.nextLine();

        SBN sbn = null;
        for (SBN s : daftarSBN) {
            if (s.getNama().equalsIgnoreCase(nama)) {
                sbn = s;
                break;
            }
        }

        if (sbn == null) {
            System.out.println("SBN tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan nominal investasi: ");
        double nominal = scanner.nextDouble();

        double bungaBulanan = (sbn.getBunga() / 100.0) / 12.0 * 0.9 * nominal;
        System.out.println("Estimasi kupon bulanan: Rp" + bungaBulanan);
    }

    private void lihatPortofolio(List<Saham> daftarSaham, List<SBN> daftarSBN) {
        System.out.println("\n--- Portofolio Investasi ---");

        System.out.println("\nSaham Dimiliki: ");
        if (sahamDimiliki.isEmpty()) {
            System.out.println("Tidak ada saham.");
        } else {
            double totalPembelian = 0;
            double totalPasar = 0;
            for (String kode :  sahamDimiliki.keySet()) {
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

        System.out.println("\nSBN Dimiliki: ");
        if (sbnDimiliki.isEmpty()) {
            System.out.println("Tidak ada SBN.");
        } else {
            for  (String nama :  sbnDimiliki.keySet()) {
                double nominal =  sbnDimiliki.get(nama);
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