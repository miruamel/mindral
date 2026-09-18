# Indeks Fitur

> Status: draft. Indeks ini tidak mendefinisikan scope; scope berada di [`../PRODUK.md`](../PRODUK.md).

## Cara Membaca

- **Status** mengikuti definisi di [`../PRODUK.md`](../PRODUK.md); status bukan jaminan fitur sudah selesai.
- **Detail** merangkum arah domain, bukan mendefinisikan scope.
- **Proposal** berarti mekanisme masih perlu keputusan atau Benchmark.
- **Terbuka** berarti pertanyaan harus masuk [`../keputusan-terbuka.md`](../keputusan-terbuka.md).
- Urutan kerja dan bukti selesai ada di [`../roadmap-mvp.md`](../roadmap-mvp.md).

## Tautan Keputusan

- [`PRODUK.md`](../PRODUK.md): scope, batas, status, dan glosarium.
- [`roadmap-mvp.md`](../roadmap-mvp.md): fase, prerequisite, dan kriteria selesai.
- [`keputusan-terbuka.md`](../keputusan-terbuka.md): pertanyaan yang belum boleh diisi asumsi.
- [`arsitektur.md`](../arsitektur.md): ownership teknis dan alur data kandidat.

| Domain | Status | Detail |
|---|---|---|
| [`Produksi`](produksi.md) | Disetujui sebagian | Recipe, Machine, Buffer, diagnosis, automation scripting; API dan parameter terbuka |
| [`Ekonomi`](ekonomi.md) | Disetujui sebagai arah | Harga, stok, permintaan, Operator, modal, kontrak; formula dan kontrak terbuka |
| [`Logistik`](logistik.md) | Disetujui sebagian | Conveyor MVP; routing, loss, reliability, hybrid Flow/Shipment, moda future terbuka |
| [`Kondisi pabrik`](kondisi-pabrik.md) | Disetujui sebagian | Energi dipilih; panas, keausan, kerusakan, kualitas, limbah terbuka |
| [`Sistem non-politik`](sistem-nonpolitik.md) | Disetujui sebagian | Daftar lengkap roadmap saat ini: Cuaca dan lingkungan, Riset dan teknologi, Populasi dan tenaga kerja, dan Keuangan dan modal; efek, skenario, parameter terbuka |
| [`Strategi dan ancaman`](strategi-dan-ancaman.md) | Roadmap disetujui | Combat operasional masuk roadmap; mekanisme combat terbuka |
| [`Simulasi`](simulasi.md) | Disetujui sebagian | Device dan backend terkunci; target tick berupa hipotesis kerja, belum terkunci; headless, determinisme, pause, replay, save/load, multiplayer terbuka |

## Aturan Indeks

- Jangan memasukkan politik, diplomasi, pemilu, ideologi, hukum, atau voting warga.
- Jangan memasukkan moda selain Conveyor ke MVP.
- Jangan menganggap combat sudah ada di MVP.
- Jangan mengisi angka performa, kapasitas, harga, atau ukuran Sektor tanpa keputusan atau Benchmark.
- Jangan mengubah proposal menjadi scope final tanpa persetujuan.
