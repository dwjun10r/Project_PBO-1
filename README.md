# PBO-Tugas1

# Program Investasi Saham dan Surat Berharga Negara (SBN)
Halo Dunia! Ini adalah proyek Investasi Saham dan Surat Berharga Negara (SBN). demi menuntaskanmenyelesaikan Tugas I PBO KAMI.

Program Java ini dirancang untuk dua jenis user dengan akses yang berbeda, yaitu:
1. Admin memiliki otoritas penuh untuk mengelola produk investasi, seperti menambah, mengubah harga, dan melihat daftar produk Saham dan SBN (Surat Berharga Negara).
2. Customer diberikan fasilitas untuk melakukan investasi, menjual aset, serta memantau portofolio yang dimilikinya.

Untuk menjaga kualitas input dari pengguna, program ini dilengkapi dengan validasi pada setiap proses input agar tidak terjadi kesalahan saat dijalankan.

Repositori ini juga menyediakan:
- Penjelasan struktur program dan alur kerjanya.
- Diagram UML yang menggambarkan relasi antar kelas.
- Komentar dalam kode untuk membantu pemahaman lebih lanjut.

Silakan eksplorasi lebih lanjut kode yang telah disediakan, dan semoga bermanfaat untuk pembelajaran maupun pengembangan sistem yang lebih kompleks ke depannya!


# Identitas Kami
* Nama  : Dewa Gede Junior Satria Erlangga 
  NIM   : 2405551096
  Matkul: PBO (E)

* Nama  : Pande Putu Satya Naraya Adyana 
  NIM   : 2405551087
  Matkul: PBO (F)

# UML



# Bagaimana Program Di jalankan
Program ini dibuat dengan konsep Object-Oriented Programming (OOP) dan terbagi menjadi beberapa class utama, yaitu Main, Admin, Customer, Saham, dan SBN. Berikut fitur dan konsep utama yang digunakan:
1. Class dan Object
Setiap peran (admin, customer, produk) diwakili oleh class masing-masing.
2. Kontrol Alur (Flow Control)
Menggunakan while, if-else, dan switch untuk navigasi menu dan validasi input.
3. ArrayList
Untuk menyimpan dan mengelola daftar produk investasi (saham dan SBN).
4. Encapsulation
Data penting disimpan dalam atribut private dan diakses lewat getter dan setter.

# Penggunaan Program
Di bawah ini merupakan penggunaan program Investasi Saham dan Surat Berharga Negara (SBN). Beberapa penjelasan bagaimana kode berjalan akan di jelaskan di bawah.
# Login Admin dan Customer
![wlcome menu]()
![admin]()
![admin]()
![customer]()
![customer]()
Setelah program dijalankan, pengguna akan diminta memilih login sebagai Admin atau Customer. Jika login berhasil, pengguna akan diarahkan ke menu sesuai dengan peran masing-masing. Jika terjadi kesalahan pada input, sistem akan meminta User untuk mengulangi hingga data yang dimasukkan benar.
# Menu Admin
![]()
Setelah melakukan login sebagai admin, maka user akan diberi intruksi kembali pada menu admin seperti gambar di atas. Admin akan diminta untuk memilih opsi di atas dengan menginputkan angka. Jika terjadi kesalahan pada input, sistem akan meminta Admin untuk mengulangi hingga data yang dimasukkan benar.

# Menu src.Saham
![]()
Saat Admin mengakses menu ini, tersedia opsi untuk menambahkan saham baru atau memperbarui harga saham yang sudah terdaftar.  Jika terjadi kesalahan pada input, sistem akan meminta Admin untuk mengulangi hingga data yang dimasukkan benar.

# Tambah src.Saham
![]()
Pada menu tambah saham, Admin dapat menambahkan data saham dengan memasukkan kode saham, nama perusahaan, dan harga saham ke dalam program. Jika terjadi kesalahan pada input, sistem akan meminta Admin untuk mengulangi hingga data yang dimasukkan benar.

# Ubah Harga src.Saham
![]()
Pada menu ubah harga saham, Admin dapat memperbarui harga saham dengan memilih saham yang ingin diubah, kemudian memasukkan harga baru sesuai kebutuhan. Jika terjadi kesalahan pada input, sistem akan meminta Admin untuk mengulangi hingga data yang dimasukkan benar.

# Menu src.SBN
![]()
Pada menu SBN, dapat memilih untuk menambahkan Surat Berharga Negara (SBN) baru ke dalam program.  Jika terjadi kesalahan pada input, sistem akan meminta Admin untuk mengulangi hingga data yang dimasukkan benar.

# Menu Tambah src.SBN
![]()
Pada menu Tambah SBN, Admin dapat menambahkan Surat Berharga Negara (SBN) baru ke dalam program dengan menginputkan data-data yang diperlukan. Jika terjadi kesalahan pada input, sistem akan meminta Admin untuk mengulangi hingga data yang dimasukkan benar.

# Menu Customer
![]()
Setelah melakukan login sebagai customer, maka user akan diberi instruksi kembali pada menu customer seperti gambar di atas. Customer akan diminta untuk memilih opsi di atas dengan menginputkan angka. Jika terjadi kesalahan pada input, sistem akan meminta Customer untuk mengulangi hingga data yang dimasukkan benar.

# Menu Beli src.Saham
![]()
Pada menu beli saham, Customer dapat memilih saham yang ingin dibeli serta menentukan jumlah lembar saham yang akan dibeli. Jika terjadi kesalahan pada input, sistem akan meminta Customer untuk mengulangi hingga data yang dimasukkan benar.


# Menu Jual src.Saham
![]() 
Pada menu jual saham, Customer dapat memilih saham yang dimilikinya untuk dijual serta menentukan jumlah lembar saham yang akan dijual. Jika terjadi kesalahan pada input, sistem akan meminta Customer untuk mengulangi hingga data yang dimasukkan benar.

# Menu Beli src.SBN
![]()
Pada menu beli SBN, Customer dapat memilih SBN yang diinginkan dan menentukan nominal pembelian sesuai keinginan. jika terjadi kesalahan pada input, sistem akan meminta Customer untuk mengulangi hingga data yang dimasukkan benar.

# Menu Simulasi src.SBN
![]()
Pada menu simulasi SBN, Customer dapat melihat estimasi nominal hasil investasi yang diperoleh dari SBN yang dimiliki. jika terjadi kesalahan pada input, sistem akan meminta Customer untuk mengulangi hingga data yang dimasukkan benar.

# Portofolio
![]()
Pada menu portofolio, Customer dapat melihat daftar saham dan SBN yang dimiliki beserta harga masing-masing aset tersebut. Jika terjadi kesalahan pada input, sistem akan meminta Customer untuk mengulangi hingga data yang dimasukkan benar.
