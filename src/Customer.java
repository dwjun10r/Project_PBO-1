package src;

import java.util.*;

public class Customer {
    private Scanner scanner = new Scanner(System.in);

    private Map<Saham, Integer> portofolioSaham = new HashMap<>();
    private Map<SBN, Double> portofolioSBN = new HashMap<>();

    public void menuCustomer(List<Saham> daftarSaham, List<SBN> daftarSBN) {
        while (true) {
            System.out.println("\n===================================");
            System.out.println("|          MENU CUSTOMER          |");
            System.out.println("===================================");
            System.out.println("1. Beli src.Saham: ");
            System.out.println("2. Jual src.Saham: ");
            System.out.println("3. Beli src.SBN: ");
            System.out.println("4. Simulasi src.SBN: ");
            System.out.println("5. Portofolio: ");
            System.out.println("6. Logout: ");
            System.out.println("===================================");
            int pilihan = Validasi.inputInt("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    beliSaham(daftarSaham);
                    break;
                case 2:
                    jualSaham();
                    break;
                case 3:
                    beliSBN(daftarSBN);
                    break;
                case 4:
                    simulasiSBN();
                    break;
                case 5:
                    lihatPortofolio();
                    break;
                case 6:
                    System.out.println("Logout");
                    return;
                default:
                    System.out.println("-----------------------------------");
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    // Beli src.Saham
    private void beliSaham(List<Saham> daftarSaham) {
        if (daftarSaham.isEmpty()) {
            System.out.println("-----------------------------------");
            System.out.println("Tidak Ada src.Saham Tersedia");
            return;
        }

        System.out.println("\n===================================");
        System.out.println("|           Daftar src.Saham          |");
        System.out.println("===================================");
        for (int i = 0; i < daftarSaham.size(); i++) {
            System.out.println((i + 1) +  ". " + daftarSaham.get(i));
        }
        int pilihan = Validasi.inputInt("Pilih Nomor src.Saham: ");

        if (pilihan < 1 || pilihan > daftarSaham.size()) {
            System.out.println("-----------------------------------");
            System.out.println("Pilihan Tidak Valid");
            return;
        }

        Saham sahamDipilih = daftarSaham.get(pilihan - 1);
        int jumlahLembar = Validasi.inputInt("Masukkan Jumlah Lembar Yang Dibeli: ");

        portofolioSaham.put(sahamDipilih, portofolioSaham.getOrDefault(sahamDipilih, 0) + jumlahLembar);
        System.out.println("-----------------------------------");
        System.out.println("Berhasil Membeli src.Saham " + sahamDipilih.getNamaPerusahaan() + " Sebanyak " + jumlahLembar + " Lembar ");
    }

    // Jual src.Saham
    private void jualSaham() {
        if (portofolioSaham.isEmpty()) {
            System.out.println("-----------------------------------");
            System.out.println("Anda Belum Memiliki src.Saham");
            return;
        }

        System.out.println("\n===================================");
        System.out.println("|    Daftar src.Saham Yang Dimiliki   |");
        System.out.println("===================================");
        List<Saham> sahamList = new ArrayList<>(portofolioSaham.keySet());
        for (int i = 0; i < sahamList.size(); i++) {
            Saham saham =  sahamList.get(i);
            System.out.println((i + 1) + ". "  + saham + " (Lembar:  " + portofolioSaham.get(saham) + ")");
        }

        int pilihan = Validasi.inputInt("Pilihan Nomor src.Saham Yang Ingin Dijual: ");

        if (pilihan < 1 || pilihan > sahamList.size()) {
            System.out.println("-----------------------------------");
            System.out.println("Pilihan Tidak Valid");
            return;
        }

        Saham sahamDipilih = sahamList.get(pilihan - 1);
        int jumlahLembar = Validasi.inputInt("Masukkan Jumlah Lembar Yang Dijual: ");

        int lembarDimiliki = portofolioSaham.get(sahamDipilih);
        if (jumlahLembar > lembarDimiliki) {
            System.out.println("-----------------------------------");
            System.out.println("Gagal. Jumlah Lembar Tidak Mencukupi.");
        } else if (jumlahLembar == lembarDimiliki) {
            portofolioSaham.remove(sahamDipilih);
            System.out.println("-----------------------------------");
            System.out.println("Semua src.Saham Berhasil Dijual.");
        } else {
            portofolioSaham.put(sahamDipilih, lembarDimiliki -  jumlahLembar);
            System.out.println("-----------------------------------");
            System.out.println("Sebagian src.Saham Berhasil Dijual.");
        }
    }

    // Beli src.SBN
    private void beliSBN(List<SBN> daftarSBN) {
        if (daftarSBN.isEmpty()) {
            System.out.println("-----------------------------------");
            System.out.println("Tidak Ada src.SBN tersedia");
            return;
        }

        System.out.println("\n===================================");
        System.out.println("|             Daftar src.SBN          |");
        System.out.println("===================================");
        for (int i = 0; i < daftarSBN.size(); i++) {
            System.out.println((i + 1) + ". " + daftarSBN.get(i));
        }
        int pilihan =  Validasi.inputInt("Pilih Nomor src.SBN: ");

        if (pilihan < 1 || pilihan > daftarSBN.size()) {
            System.out.println("-----------------------------------");
            System.out.println("Pilihan Tidak Valid");
            return;
        }

        SBN sbnDipilih = daftarSBN.get(pilihan - 1);
        double nominal = Validasi.inputDouble("Masukkan Nominal Pembelian: ");

        if (nominal > sbnDipilih.getKuotaNasional()) {
            System.out.println("-----------------------------------");
            System.out.println("Gagal. Nominal Melebihi Kouta Nasional.");
            return;
        }

        portofolioSBN.put(sbnDipilih, portofolioSBN.getOrDefault(sbnDipilih, 0.0) + nominal);
        sbnDipilih.setKuotaNasional(sbnDipilih.getKuotaNasional() - nominal);
        System.out.println("-----------------------------------");
        System.out.println("Berhasil Membeli src.SBN " + sbnDipilih.getNama() + " Senilai Rp " + nominal);
    }

    // Simulasi src.SBN
    private void simulasiSBN() {
        if (portofolioSBN.isEmpty()) {
            System.out.println("-----------------------------------");
            System.out.println("Anda Belum Memiliki src.SBN.");
            return;
        }

        System.out.println("\n===================================");
        System.out.println("|  Simulasi Kupon src.SBN Per Bulan   |");
        System.out.println("===================================");
        for (Map.Entry<SBN, Double>  entry : portofolioSBN.entrySet()) {
            SBN sbn = entry.getKey();
            double nominal = entry.getValue();
            double kuponPerBulan = (sbn.getBunga() / 100 / 12) * 0.9 * nominal;
            System.out.println(sbn.getNama() + ": Rp " + String.format("%.2f", kuponPerBulan) + "/ Bulan");
        }
    }

    // Portofolio
    private void lihatPortofolio() {
        System.out.println("\n===================================");
        System.out.println("|            Portofolio           |");
        System.out.println("===================================");

        if (portofolioSaham.isEmpty()) {
            System.out.println("src.Saham: Tidak Ada.");
        } else {
            double totalBeliSaham = 0;
            double totalNilaiPasar = 0;
            System.out.println("src.Saham: ");
            for (Map.Entry<Saham, Integer>  entry : portofolioSaham.entrySet()) {
                Saham saham = entry.getKey();
                int jumlah = entry.getValue();
                double totalBeli = jumlah * saham.getHarga();
                totalBeliSaham += totalBeli;
                totalNilaiPasar += totalBeli;
                System.out.println(saham.getKode() + " - " + saham.getNamaPerusahaan() + ", Lembar: " + jumlah + ", Total Beli: Rp " + String.format("%.2f", totalBeli) + ", Nilai Pasar: Rp " +  String.format("%.2f", jumlah * saham.getHarga()));
            }
            System.out.println("Total Investasi src.Saham: Rp " + String.format("%.2f", totalBeliSaham));
        }

        if (portofolioSBN.isEmpty()) {
            System.out.println("\nsrc.SBN: Tidak Ada.");
        } else {
            double totalSBN = 0;
            System.out.println("\nsrc.SBN: ");
            for (Map.Entry<SBN, Double>  entry : portofolioSBN.entrySet()) {
                SBN sbn = entry.getKey();
                double nominal = entry.getValue();
                double kuponBulanan = (sbn.getBunga() / 100 / 12) * 0.9 * nominal;
                totalSBN += nominal;
                System.out.println(sbn.getNama() + ", Nominal: Rp " + String.format("%.2f", nominal) + ", Kupon Per Bulan: Rp " +  String.format("%.2f", kuponBulanan));
            }
            System.out.println("Total Investasi src.SBN: Rp " + String.format("%.2f", totalSBN));
        }
    }
}