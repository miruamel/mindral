# Fitur: Sistem non-politik


## Subfitur

### Proposal: Cuaca dan lingkungan

- Jenis cuaca, frekuensi, durasi, dan efek belum dikunci.

### Proposal: Riset dan teknologi

- Pohon teknologi, biaya, prerequisite, dan output riset belum dikunci.

### Proposal: Populasi dan tenaga kerja

- Model populasi dan detail tenaga kerja belum dikunci.

### Proposal: Keuangan dan modal

- Bunga, kredit, kebangkrutan, dan restrukturisasi belum dikunci.

### Proposal: Skenario dan Observabilitas

- Setiap sistem masuk melalui skenario terukur, bukan sekaligus tanpa Benchmark.
- Efek sistem terlihat melalui Event, grafik, atau overlay jika fitur observabilitas disetujui.
- Sistem tambahan memerlukan keputusan eksplisit sebelum masuk produk.

### Proposal: Interaksi

- Cuaca dapat mengubah kapasitas atau biaya.
- Riset dapat mengubah Recipe, Machine, atau Logistik.
- Tenaga kerja dapat membatasi operasi atau biaya.
- Keuangan dapat membatasi investasi dan kelangsungan Operator.
- Semua efek dapat terlihat melalui Event, grafik, atau overlay jika disetujui.

## Dependensi proposal

### Player-Visible

- Pemain melihat efek Cuaca dan lingkungan, Riset dan teknologi, Populasi dan tenaga kerja, serta Keuangan dan modal.
- Pemain membaca perubahan kemampuan, biaya, operasi, dan risiko.

### State dan Data

- Domain memakai state sistem, parameter, skenario, Event, Command, dan Snapshot.
- Snapshot digunakan untuk UI dan automation scripting; API automation masih proposal.

### Interaksi Lintas-Domain

- Cuaca dan lingkungan dapat memengaruhi kapasitas atau biaya.
- Riset dan teknologi dapat memengaruhi Recipe atau Logistik; Populasi dan tenaga kerja memengaruhi operasi dan biaya; Keuangan dan modal memengaruhi investasi.

### Failure dan Diagnosis

- Skenario Sistem non-politik menghasilkan perubahan state dan Event yang dapat dibaca.
- Efek kegagalan dapat ditelusuri ke sistem penyebab jika skenario disetujui.

### Observabilitas

- UI menampilkan Event, grafik, atau overlay jika mekanisme tersebut disetujui.
- Parameter dan metrik tetap proposal sampai Benchmark dan playtest tersedia.

- Event domain dari Produksi, Logistik, Ekonomi, dan Kondisi pabrik.
- Parameter dan skenario per sistem.
- UI observabilitas untuk sebab-akibat.
- Model keuangan dan modal jika sistem Keuangan dan modal disetujui.
- Keputusan sistem tambahan dan parameter tercatat di [`../keputusan-terbuka.md`](../keputusan-terbuka.md).

## Aturan

- Command mengubah state; game input atau Command masuk melalui batas input. Event hanya mencatat hasil.
- Keputusan yang memblokir Sistem non-politik tercatat di [`../keputusan-terbuka.md`](../keputusan-terbuka.md) sebelum skenario dianggap selesai.

## Kriteria selesai proposal

- Setiap sistem memiliki input, output, dan efek gameplay yang jelas setelah parameter disetujui.
- Pemain dapat melihat sebab dan akibat perubahan sistem.
- Sistem tambahan memerlukan keputusan eksplisit sebelum masuk.
