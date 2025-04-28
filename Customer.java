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
            System.out.println("1. Beli Saham: ");
            System.out.println("2. Jual Saham: ");
            System.out.println("3. Beli SBN: ");
            System.out.println("4. Simulasi SBN: ");
            System.out.println("5. Portofolio: ");
            System.out.println("6. Logout: ");
            System.out.println("===================================");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

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

    // Beli Saham
    private void beliSaham(List<Saham> daftarSaham) {
        if (daftarSaham.isEmpty()) {
            System.out.println("-----------------------------------");
            System.out.println("Tidak Ada Saham Tersedia");
            return;
        }

        System.out.println("\n===================================");
        System.out.println("|           Daftar Saham          |");
        System.out.println("===================================");
        for (int i = 0; i < daftarSaham.size(); i++) {
            System.out.println((i + 1) +  ". " + daftarSaham.get(i));
        }
        System.out.print("\nPilih Nomor Saham: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan < 1 || pilihan > daftarSaham.size()) {
            System.out.println("-----------------------------------");
            System.out.println("Pilihan Tidak Valid");
            return;
        }

        Saham sahamDipilih = daftarSaham.get(pilihan - 1);
        System.out.print("Masukkan Jumlah Lembar Yang Dibeli: ");
        int jumlahLembar = scanner.nextInt();
        scanner.nextLine();

        portofolioSaham.put(sahamDipilih, portofolioSaham.getOrDefault(sahamDipilih, 0) + jumlahLembar);
        System.out.println("-----------------------------------");
        System.out.println("Berhasil Membeli Saham " + sahamDipilih.getNamaPerusahaan() + " Sebanyak " + jumlahLembar + " Lembar ");
    }

    // Jual Saham
    private void jualSaham() {
        if (portofolioSaham.isEmpty()) {
            System.out.println("-----------------------------------");
            System.out.println("Anda Belum Memiliki Saham");
            return;
        }

        System.out.println("\n===================================");
        System.out.println("|    Daftar Saham Yang Dimiliki   |");
        System.out.println("===================================");
        List<Saham> sahamList = new ArrayList<>(portofolioSaham.keySet());
        for (int i = 0; i < sahamList.size(); i++) {
            Saham saham =  sahamList.get(i);
            System.out.println((i + 1) + ". "  + saham + " (Lembar:  " + portofolioSaham.get(saham) + ")");
        }

        System.out.print("\nPilih Nomor Saham Yang Ingin Dijual: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan < 1 || pilihan > sahamList.size()) {
            System.out.println("-----------------------------------");
            System.out.println("Pilihan Tidak Valid");
            return;
        }

        Saham sahamDipilih = sahamList.get(pilihan - 1);
        System.out.print("Masukkan Jumlah Lembar Yang Dijual: ");
        int jumlahLembar = scanner.nextInt();
        scanner.nextLine();

        int lembarDimiliki = portofolioSaham.get(sahamDipilih);
        if (jumlahLembar > lembarDimiliki) {
            System.out.println("-----------------------------------");
            System.out.println("Gagal. Jumlah Lembar Tidak Mencukupi.");
        } else if (jumlahLembar == lembarDimiliki) {
            portofolioSaham.remove(sahamDipilih);
            System.out.println("-----------------------------------");
            System.out.println("Semua Saham Berhasil Dijual.");
        } else {
            portofolioSaham.put(sahamDipilih, lembarDimiliki -  jumlahLembar);
            System.out.println("-----------------------------------");
            System.out.println("Sebagian Saham Berhasil Dijual.");
        }
    }

    // Beli SBN
    private void beliSBN(List<SBN> daftarSBN) {
        if (daftarSBN.isEmpty()) {
            System.out.println("-----------------------------------");
            System.out.println("Tidak Ada SBN tersedia");
            return;
        }

        System.out.println("\n===================================");
        System.out.println("|             Daftar SBN          |");
        System.out.println("===================================");
        for (int i = 0; i < daftarSBN.size(); i++) {
            System.out.println((i + 1) + ". " + daftarSBN.get(i));
        }
        System.out.print("\nPilih Nomor SBN: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan < 1 || pilihan > daftarSBN.size()) {
            System.out.println("-----------------------------------");
            System.out.println("Pilihan Tidak Valid");
            return;
        }

        SBN sbnDipilih = daftarSBN.get(pilihan - 1);
        System.out.print("Masukkan Nominal Pembelian: ");
        double nominal = scanner.nextDouble();
        scanner.nextLine();

        if (nominal > sbnDipilih.getKuotaNasional()) {
            System.out.println("-----------------------------------");
            System.out.println("Gagal. Nominal Melebihi Kouta Nasional.");
            return;
        }

        portofolioSBN.put(sbnDipilih, portofolioSBN.getOrDefault(sbnDipilih, 0.0) + nominal);
        sbnDipilih.setKuotaNasional(sbnDipilih.getKuotaNasional() - nominal);
        System.out.println("-----------------------------------");
        System.out.println("Berhasil Membeli SBN " + sbnDipilih.getNama() + " Senilai Rp " + nominal);
    }

    // Simulasi SBN
    private void simulasiSBN() {
        if (portofolioSBN.isEmpty()) {
            System.out.println("-----------------------------------");
            System.out.println("Anda Belum Memiliki SBN.");
            return;
        }

        System.out.println("\n===================================");
        System.out.println("|  Simulasi Kupon SBN Per Bulan   |");
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
            System.out.println("Saham: Tidak Ada.");
        } else {
            double totalBeliSaham = 0;
            double totalNilaiPasar = 0;
            System.out.println("Saham: ");
            for (Map.Entry<Saham, Integer>  entry : portofolioSaham.entrySet()) {
                Saham saham = entry.getKey();
                int jumlah = entry.getValue();
                double totalBeli = jumlah * saham.getHarga();
                totalBeliSaham += totalBeli;
                totalNilaiPasar += totalBeli;
                System.out.println(saham.getKode() + " - " + saham.getNamaPerusahaan() + ", Lembar: " + jumlah + ", Total Beli: Rp " + String.format("%.2f", totalBeli) + ", Nilai Pasar: Rp " +  String.format("%.2f", jumlah * saham.getHarga()));
            }
            System.out.println("Total Investasi Saham: Rp " + String.format("%.2f", totalBeliSaham));
        }

        if (portofolioSaham.isEmpty()) {
            System.out.println("\nSBN: Tidak Ada.");
        } else {
            double totalSBN = 0;
            System.out.println("\nSBN: ");
            for (Map.Entry<SBN, Double>  entry : portofolioSBN.entrySet()) {
                SBN sbn = entry.getKey();
                double nominal = entry.getValue();
                double kuponBulanan = (sbn.getBunga() / 100 / 12) * 0.9 * nominal;
                totalSBN += nominal;
                System.out.println(sbn.getNama() + ", Nominal: Rp " + String.format("%.2f", nominal) + ", Kupon Per Bulan: Rp " +  String.format("%.2f", kuponBulanan));
            }
            System.out.println("Total Investasi SBN: Rp " + String.format("%.2f", totalSBN));
        }
    }
}