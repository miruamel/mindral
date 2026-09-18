# Fitur: Produksi


## Subfitur

### Proposal: Recipe dan Grafik Produksi

- Recipe menghubungkan input, output, waktu proses, dan Machine.
- Kualitas, by-product, dan limbah tetap proposal.
- Parameter waktu, rasio, kualitas, dan peluang belum dikunci.

### Proposal: Machine

- State minimum: idle, bekerja, menunggu input, dan menunggu output.
- State tanpa energi, maintenance, dan rusak tetap proposal.
- Machine memiliki Buffer input/output dan kapasitas proses.
- Parameter kapasitas, kecepatan, dan failure rate belum dikunci.

### Proposal: Buffer dan Aliran

- Buffer menghubungkan Machine dan interface Logistik.
- Buffer penuh dapat menghentikan Machine hulu.
- Buffer kosong dapat menghentikan Machine hilir.
- Kapasitas Buffer belum dikunci.

### Proposal: Automation Scripting

- Proposal: pemain membaca state dan memberi Command.
- Proposal: script menargetkan Machine, Buffer, Recipe, sistem terkait, dan alarm.
- Proposal: script memakai view state yang sama dengan UI.
- Bahasa, permission model, sandbox, dan API final belum dikunci.

### Proposal: Observabilitas dan Recovery

- Perubahan state dan blocker Produksi menghasilkan Event yang dapat dibaca pemain.
- Penyebab berhenti, bottleneck, dan jalur pemulihan terlihat melalui UI jika diagnosis disetujui.
- automation scripting hanya boleh memicu recovery melalui Command dan permission yang disetujui.

### Proposal: Diagnosis Produksi

- Perubahan state penting menghasilkan Event.
- Pemain melihat penyebab Machine berhenti.
- Overlay membedakan kurang input, output penuh, kurang energi, maintenance, dan kerusakan jika fitur terkait disetujui.


## Dependensi proposal

### Player-Visible

- Pemain melihat Resource, Recipe, Machine, Buffer, dan interface Logistik.
- Pemain membaca status rantai, bottleneck, dan diagnosis.

### State dan Data

- Domain memakai Resource, Recipe, Machine, Buffer, Event, Command, dan Snapshot.
- Snapshot digunakan untuk UI dan automation scripting; API automation masih proposal.

### Interaksi Lintas-Domain

- Produksi mengirim output dan Event ke Logistik, Ekonomi, Kondisi pabrik, dan Sistem non-politik.
- automation scripting membaca Snapshot dan mengirim Command jika API/permission disetujui.

### Failure dan Diagnosis

- Requirement yang tidak terpenuhi dapat menghentikan rantai.
- Event menjelaskan penyebab dan recovery jika aturan terkait disetujui.

### Observabilitas

- UI menampilkan bottleneck, status Machine, dan diagnosis Event.
- metrik Produksi tetap proposal sampai Benchmark atau playtest.

- Resource dan Recipe definition.
- Machine state dan Buffer.
- Output dan bottleneck interface.
- Event diagnosis dan Snapshot.
- automation API jika scripting disetujui.
- Keputusan scripting, API, dan permission tercatat di [`../keputusan-terbuka.md`](../keputusan-terbuka.md).

## Aturan

- Tidak ada bahasa scripting universal sebelum keputusan.
- Tidak ada parameter kapasitas, kecepatan, atau failure rate tanpa keputusan/playtest.
- Keputusan yang memblokir Produksi tercatat di [`../keputusan-terbuka.md`](../keputusan-terbuka.md) sebelum parameter dianggap selesai.

## Kriteria selesai proposal

- Rantai Produksi menerima input, memproses minimal satu Recipe, dan mengirim output melalui interface Logistik.
- Rantai berhenti saat requirement tidak terpenuhi dan pulih setelah penyebab diperbaiki.
- Bottleneck terlihat dari UI dan Event.
- Script dasar dapat mengubah operasi Machine atau interface Logistik jika automation API disetujui.
- Perubahan script dapat dihentikan atau dibatasi sesuai permission model yang nanti disetujui.
