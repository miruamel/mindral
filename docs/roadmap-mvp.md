# Roadmap dan MVP

> Status: draft. Semua fase, target MVP, dan kriteria selesai masih proposal sampai keputusan terbuka selesai.

## Tujuan Draft

Menghasilkan playable solo sandbox factory automation di Android tanpa politik. MVP draft menargetkan core loop Produksi, Conveyor, Ekonomi lokal, Kondisi pabrik, dan automation scripting.

## Kriteria Selesai Proposal

MVP selesai jika pemain dapat:

- membangun rantai Produksi dari Resource mentah ke produk;
- mengirim barang dengan Conveyor;
- melihat harga, stok, biaya, dan dampak Ekonomi;
- membaca bottleneck dan kondisi Machine;
- menggunakan automation scripting dasar;
- bermain di banyak Sektor besar dalam batas performa yang sudah dibuktikan oleh Benchmark;
- menyimpan progres jika save/load disetujui;
- memahami semua failure melalui Event dan overlay.

## Prasyarat Sebelum Implementasi

- [x] Empat sistem non-politik—Cuaca dan lingkungan, Riset dan teknologi, Populasi dan tenaga kerja, dan Keuangan dan modal—menjadi daftar lengkap roadmap saat ini; sistem tambahan memerlukan keputusan scope baru.
- [ ] Kunci bahasa/API automation scripting dan permission model.
- [x] Resolve libGDX latest stable `1.14.2`, pin versi dan checksum via `gradle/verification-metadata.xml`.
- [ ] Tentukan batas Sektor, entity, dan ukuran dunia melalui Benchmark Pixel 8.
- [ ] Kunci keputusan Simulasi: determinisme, pause, replay, Headless, save/load, dan multiplayer.
- [ ] Kunci formula Ekonomi minimum dan jenis kontrak MVP.
- [ ] Kunci prioritas Kondisi pabrik: energi, panas, keausan, kerusakan, kualitas, limbah.


## Aturan Roadmap

- Urutan fase bukan scope baru; scope tetap milik [`PRODUK.md`](PRODUK.md).
- Fase hanya mulai jika prerequisite dan dependency terkait sudah cukup untuk pengujian.
- Fitur conditional masuk kriteria selesai hanya setelah keputusan menerima fitur tersebut; jika ditolak, keluarkan dari scope/kriteria dan catat dampaknya.
- Setiap fase menyimpan bukti observabel: build/scenario, Event, UI, atau Benchmark yang dapat diperiksa.
- Angka performa, kapasitas, dan ukuran dunia tidak dianggap selesai sebelum Benchmark Pixel 8.

## Dependensi Fase Proposal

- Fondasi menyediakan data definition, Simulation kernel, dan Benchmark.
- Produksi membutuhkan Resource, Recipe, Machine, Buffer, dan Conveyor.
- Ekonomi membutuhkan Event Produksi, stok, distribusi, dan keputusan Operator.
- automation scripting membutuhkan read state, Command, permission, dan sandbox.
- Banyak Sektor membutuhkan Benchmark serta koneksi Conveyor lintas Sektor.
- Sistem non-politik membutuhkan Event domain dan observabilitas.
- Combat Roadmap membutuhkan Ekonomi-Logistik stabil.

## Fase Proposal 0: Fondasi dan Benchmark

- Setup project Android dan adapter libGDX.
- Buat Simulation kernel headless jika disetujui.
- Buat data definition untuk Resource, Recipe, Machine, Node, Edge, dan skenario.
- Jalankan Benchmark tick dan entity.
- Keluaran: target performa konkret dan arsitektur backend terkunci.

**Bukti selesai:** Android build berjalan pada device acuan; adapter input/lifecycle dapat diuji; Benchmark tick dan entity tercatat; batas backend ditulis sebagai data terukur.

## Fase Proposal 1: Produksi dan Conveyor MVP

- Implementasi Recipe, Machine state, Buffer, dan Conveyor.
- Implementasi input/output blocking dan Event diagnosis.
- Buat satu skenario rantai Produksi yang dapat gagal dan pulih.
- Keluaran: pemain dapat membangun dan membaca rantai Produksi dasar.

**Bukti selesai:** satu skenario membangun rantai, mengirim barang melalui Conveyor, gagal karena requirement, lalu pulih setelah penyebab diperbaiki.

## Fase Proposal 2: Ekonomi Lokal

- Implementasi stok, permintaan, harga lokal, dan biaya distribusi.
- Implementasi Operator, inventori, modal, dan keputusan Ekonomi minimum.
- Hubungkan gangguan Produksi/Logistik dengan harga dan laba/rugi.
- Keluaran: Ekonomi bereaksi terhadap keputusan pabrik.

**Bukti selesai:** perubahan pasokan, permintaan, biaya distribusi, atau gangguan Produksi/Logistik terlihat pada harga, stok, biaya, atau risiko Operator.

## Fase Proposal 3: Automation Scripting

- Tentukan bahasa/API dan permission model.
- Implementasi read state, alarm, dan Command dasar.
- Tambahkan sandbox/limit yang disetujui.
- Keluaran: pemain dapat mengotomasi operasi tanpa mengakses sistem terlarang.

**Bukti selesai:** script membaca state, mengirim Command yang diizinkan, dan ditolak saat permission atau sandbox melarang aksi.

## Fase Proposal 4: Banyak Sektor Besar

- Tambahkan Sektor dan koneksi Conveyor lintas Sektor.
- Tambahkan observabilitas lintas Sektor.
- Validasi batas entity dan tick dari Benchmark.
- Keluaran: satu sesi sandbox dengan rantai pasok lintas Sektor.

**Bukti selesai:** rantai lintas Sektor berjalan dalam batas Benchmark; UI menunjukkan bottleneck atau gangguan lintas Sektor.

## Fase Proposal 5: Sistem non-politik

- Cuaca dan lingkungan.
- Riset dan teknologi.
- Populasi dan tenaga kerja.
- Keuangan dan modal.
- Setiap sistem masuk melalui skenario terukur, bukan sekaligus tanpa Benchmark.

**Bukti selesai:** setiap sistem tersebut memiliki skenario, Event, efek gameplay, dan cara pemain melihat sebab-akibat; sistem tambahan tidak masuk tanpa keputusan scope baru.

## Fase Proposal 6: Combat Operasional

- Ancaman Infrastruktur.
- Recon dan Informasi.
- Blokade dan Gangguan Rute.
- Konvoi, Pertahanan, Sabotase, dan Serangan.
- Fase ini dimulai setelah Ekonomi-Logistik stabil.

**Bukti selesai:** ancaman dapat mengganggu infrastruktur atau rute, pemain dapat mendeteksi dan memulihkan gangguan, serta efek terlihat pada Ekonomi atau Logistik.

## Bukan MVP

- Truk, Kereta, Kapal, Pesawat, dan Pipa.
- Combat Operasional.
- Sistem non-politik lain yang belum disebut.
- Politik, diplomasi, pemilu, ideologi, hukum, atau voting warga.
- Angka performa yang belum di-Benchmark.
