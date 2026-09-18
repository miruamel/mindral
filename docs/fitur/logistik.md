# Fitur: Logistik


## Subfitur

### Proposal: Node

- Proposal: penambang, pabrik, gudang, stasiun transfer, dan pasar dapat menjadi Node.
- Proposal: Node memiliki Buffer, kapasitas bongkar, dan status operasional.
- Kapasitas dan biaya handling belum dikunci.

### Proposal: Edge

- Proposal: Edge menghubungkan Node.
- Proposal: Edge memiliki panjang, kapasitas, kecepatan, biaya, dan status.
- Proposal: Edge dapat mengalami kemacetan, kerusakan, atau pemblokiran.
- Nilai numerik belum dikunci.

### Proposal: Kapasitas dan Congestion

- Kapasitas Node dan Edge dapat membatasi throughput jika model capacity disetujui.
- Congestion, delay, loss, dan reliability tetap metrik proposal.
- Angka kapasitas, kecepatan, biaya, dan loss tidak dikunci tanpa Benchmark atau keputusan.

### Proposal: Rute dan Transfer

- Proposal: barang dapat berpindah melalui beberapa Edge.
- Proposal: transfer antar-Node memerlukan Buffer dan kapasitas.
- Proposal: rute ditentukan berdasarkan constraint yang nanti disetujui.
- Algoritma routing final belum dikunci.

### Proposal: Failure dan Recovery

- Edge atau Node dapat diblokir, rusak, atau berhenti jika aturan gangguan disetujui.
- Reroute, Buffer, dan inventori dapat menjadi respons gameplay jika model terkait disetujui.
- Event menjelaskan penyebab gangguan dan perubahan rute.

### Proposal: Hybrid Simulation

- Proposal: Flow mewakili jaringan besar dengan volume/kualitas agregat dan kepemilikan kolektif.
- Proposal: Shipment mewakili keputusan strategis atau barang penting dengan identitas, asal, pemilik, lokasi, kualitas, dan waktu tiba.
- Batas antara Flow dan Shipment belum dikunci.
- Model hybrid dapat diuji tanpa rendering jika Simulasi headless disetujui.

### Proposal: Lintas Sektor

- Koneksi lintas Sektor memerlukan Benchmark entity, tick, dan queue.
- Moda future tetap proposal sampai ada keputusan baru.

### Proposal: Observabilitas

- Proposal: pemain dapat melihat throughput, antrean, delay, congestion, loss, dan reliability jika metrik tersebut disetujui.
- Proposal: Event menjelaskan mengapa Shipment tertunda atau berhenti.
- Proposal: overlay membedakan masalah Produksi dari masalah Logistik.

## Dependensi proposal

### Player-Visible

- Pemain melihat Node, Edge, throughput, queue, delay, loss, reliability, dan bottleneck.
- Pemain membaca rute, kemacetan, kehilangan barang, dan gangguan.

### State dan Data

- Domain memakai Node, Edge, Buffer, Flow, Shipment, Event, Command, dan Snapshot.
- Conveyor tetap moda MVP; Flow dan Shipment masih alternatif model.

### Interaksi Lintas-Domain

- Produksi mengirim Buffer dan output ke Logistik.
- Ekonomi membaca biaya distribusi; Kondisi pabrik dan Strategi dan ancaman dapat menyebabkan gangguan.

### Failure dan Diagnosis

- Node atau Edge yang blocked/damaged dapat menghentikan atau memperlambat aliran.
- Reroute, Buffer, atau inventori menjadi respons hanya jika aturan terkait disetujui.

### Observabilitas

- UI menampilkan throughput, queue, delay, congestion, loss, reliability, dan overlay gangguan.
- metrik Logistik tetap proposal sampai Benchmark dan playtest tersedia.

- Buffer Produksi dan Machine state.
- Node, Edge, dan interface Logistik definitions.
- Routing dan capacity model.
- Event Ekonomi untuk biaya dan dampak distribusi.
- Snapshot dan diagnosis Event.
- Keputusan Flow/Shipment, routing, loss, reliability, dan moda future tercatat di [`../keputusan-terbuka.md`](../keputusan-terbuka.md).

## Aturan

- Proposal: aggregate Flow tidak memakai identitas per-item.
- Proposal: discrete Shipment hanya memakai identitas per-item jika model Shipment disetujui.
- Angka kapasitas, kecepatan, biaya, loss, atau reliability tidak dikunci tanpa keputusan/Benchmark.
- Keputusan yang memblokir Logistik tercatat di [`../keputusan-terbuka.md`](../keputusan-terbuka.md) sebelum model dianggap selesai.

## Kriteria selesai proposal

- Pemain dapat menemukan bottleneck jalur Logistik dari UI.
- Perubahan rute atau kapasitas mengubah throughput dan biaya.
- Jika Simulasi headless disetujui, model Logistik dapat berjalan tanpa renderer.
