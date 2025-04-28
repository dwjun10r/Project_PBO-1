public class SBN {
    private String nama;
    private double bunga;
    private int jangkaWaktu; // dalam tahun misal
    private String tanggalJatuhTempo;
    private double kuotaNasional;

    // Constructor
    public SBN(String nama, double bunga, int jangkaWaktu, String tanggalJatuhTempo, double kuotaNasional) {
        this.nama = nama;
        this.bunga = bunga;
        this.jangkaWaktu = jangkaWaktu;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.kuotaNasional = kuotaNasional;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public double getBunga() {
        return bunga;
    }

    public int getJangkaWaktu() {
        return jangkaWaktu;
    }

    public String getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public double getKuotaNasional() {
        return kuotaNasional;
    }

    public void setKuotaNasional(double kuotaNasional) {
        this.kuotaNasional = kuotaNasional;
    }

    @Override
    public String toString() {
        return "Nama: " + nama +
                ", Bunga: " + bunga + "%" +
                ", Jangka Waktu: " + jangkaWaktu + " tahun" +
                ", Jatuh Tempo: " + tanggalJatuhTempo +
                ", Kuota Nasional: Rp " + String.format("%.2f", kuotaNasional);
    }
}
