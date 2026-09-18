# Fitur: Kondisi pabrik


## Subfitur

### Proposal: Energi

- Proposal: Machine dapat membutuhkan energi untuk bekerja.
- Proposal: kekurangan energi dapat menurunkan throughput atau menghentikan Machine.
- Prioritas distribusi energi belum dikunci.

### Proposal: Panas

- Proses dapat menghasilkan panas.
- Panas berlebih dapat menyebabkan derating, shutdown, atau kerusakan.
- Ambang dan mekanisme pendinginan belum dikunci.

### Proposal: Keausan dan Maintenance

- Penggunaan Machine menambah keausan.
- Maintenance mengembalikan kondisi dengan biaya dan waktu.
- Jadwal maintenance dapat menjadi target automation scripting jika API disetujui.
- Formula keausan belum dikunci.

### Proposal: Recovery

- Maintenance atau perbaikan dapat mengembalikan Machine ke state yang dapat bekerja jika aturan recovery disetujui.
- Biaya, waktu, dan prioritas recovery belum dikunci.
- automation scripting dapat menjadwalkan maintenance hanya jika API dan permission disetujui.

### Proposal: Kerusakan

- Machine dapat gagal karena keausan, panas, gangguan eksternal, atau penyebab lain yang disetujui.
- Kerusakan dapat menghentikan atau menurunkan output Machine; dampak Ekonomi muncul melalui biaya downtime jika aturan terkait disetujui.
- Probabilitas dan recovery belum dikunci.

### Proposal: Kualitas, Cacat, dan Limbah

- Recipe dapat menghasilkan kualitas berbeda.
- Cacat dan limbah dapat mengurangi output efektif.
- Parameter kualitas belum dikunci.

### Proposal: Diagnosis

- Setiap Machine menampilkan penyebab state saat ini.
- Event mencatat perubahan kondisi penting.
- UI membedakan masalah energi, panas, maintenance, kerusakan, input, dan output.
- Keputusan parameter Kondisi pabrik tercatat di [`../keputusan-terbuka.md`](../keputusan-terbuka.md).

## Dependensi proposal

### Player-Visible

- Pemain melihat energi, panas, keausan, kerusakan, kualitas, dan limbah.
- Pemain membaca status Machine dan dampak Kondisi pabrik pada Produksi.

### State dan Data

- Domain memakai state Machine, threshold, Event, Command, dan Snapshot.
- Snapshot digunakan untuk UI dan automation scripting; API automation masih proposal.

### Interaksi Lintas-Domain

- Produksi membaca output Machine; Ekonomi membaca biaya energi dan downtime.
- automation scripting dapat memicu maintenance jika Command disetujui; Strategi dan ancaman dapat menyebabkan kerusakan.

### Failure dan Diagnosis

- Energi, panas, keausan, atau kerusakan dapat menghentikan atau menurunkan Produksi.
- Recovery tetap proposal sampai maintenance, kerusakan, dan Command disetujui.

### Observabilitas

- UI menampilkan penyebab, Event, dan overlay Kondisi pabrik.
- metrik Kondisi pabrik tetap proposal sampai threshold dan playtest tersedia.

- Machine state dan Recipe.
- Model Energi.
- Maintenance, panas, kerusakan, kualitas, dan limbah rules jika disetujui.
- Event diagnosis dan UI overlay.
- automation API jika script membaca alarm.

## Aturan

- Tidak ada simulasi fisika detail di luar kebutuhan gameplay.
- Tidak ada failure rate, ambang panas, atau formula keausan tanpa Benchmark/playtest.
- Keputusan yang memblokir Kondisi pabrik tercatat di [`../keputusan-terbuka.md`](../keputusan-terbuka.md) sebelum threshold atau formula dianggap selesai.

## Kriteria selesai proposal

- Pemain dapat melihat mengapa Machine berhenti.
- Perbaikan requirement mengembalikan Produksi.
- Kondisi Machine memengaruhi output atau biaya jika aturan terkait disetujui.
- automation scripting dapat membaca alarm Kondisi pabrik jika API disetujui.
