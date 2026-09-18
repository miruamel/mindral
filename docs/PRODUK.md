# Mindral — Simulasi Otomasi Pabrik

> Status: draft. File ini sumber kebenaran scope produk. Detail mekanisme yang belum disetujui tetap proposal atau terbuka.

## Tujuan Produk

Game factory automation solo sandbox untuk Android. Pemain membangun rantai Produksi, Ekonomi, dan Logistik dalam satu planet berisi banyak Sektor besar.

## Scope Terkunci

- Pemain: solo sandbox.
- Target device: Pixel 8.
- Android: API target 35, min SDK 23.
- Tampilan: 2D top-down.
- Dunia: satu planet dengan banyak Sektor besar.
- Engine: custom engine milik proyek di atas libGDX sebagai backend.
- LibGDX: latest stable di-resolve lalu dipin bersama checksum saat build pertama.
- Input: libGDX menyediakan raw platform input; engine proyek mengubahnya menjadi game input.
- Logistik MVP: Conveyor.
- Logistik roadmap: Truk, Kereta, Kapal, Pesawat, Pipa.
- Produksi: automation scripting dipilih sebagai kemampuan produk; bahasa, API, permission, dan sandbox belum diputuskan.
- Ekonomi: ekonomi penuh dipilih sebagai arah jangka panjang; MVP hanya memakai ekonomi lokal minimum, formula, kontrak, kredit, dan parameter masih terbuka.
- Sistem non-politik: daftar lengkap roadmap saat ini terdiri atas Cuaca dan lingkungan, Riset dan teknologi, Populasi dan tenaga kerja, dan Keuangan dan modal; efek dan parameter belum diputuskan.
- Combat: operasional penuh dipilih untuk roadmap setelah Ekonomi-Logistik; detail combat belum diputuskan.
- Simulasi: 30 tick/detik menjadi hipotesis kerja, belum terkunci; batas Sektor, entity, dan performa menunggu Benchmark.

## Loop Produk (Arah)

- Pemain menyusun Resource, Recipe, Machine, dan Buffer menjadi rantai Produksi.
- Pemain menghubungkan rantai Produksi ke interface Logistik.
- Simulation memproses Command, mengubah domain state, lalu menerbitkan Event; pemain membaca diagnosis, bottleneck, dan dampak Ekonomi.
- Pemain menyesuaikan operasi melalui input game atau automation scripting; bahasa, API, permission, dan sandbox masih proposal.
- Urutan implementasi dan bukti selesai ada di [`roadmap-mvp.md`](roadmap-mvp.md).

## Glosarium Kanonis

Glosarium ini menetapkan nama dan alias. Mekanisme tetap proposal atau terbuka sesuai status domain.

- **Sektor** (`sector`): wilayah dunia yang dapat menjadi batas Benchmark dan observabilitas.
- **Resource** (`resource`, `bahan`): material atau data yang diproses, disimpan, atau diperdagangkan.
- **Recipe** (`resep`, `formula produksi`): hubungan input, output, waktu proses, dan Machine.
- **Machine** (`mesin`, `unit produksi`): unit produksi dengan state, Buffer, dan kapasitas proses.
- **Buffer** (`penyangga`): penyangga antara Machine, Node, dan interface aliran.
- **Node** (`titik logistik`): titik dalam model Logistik, misalnya sumber, pabrik, gudang, transfer, atau pasar.
- **Edge** (`hubungan logistik`): hubungan antar-Node dengan kapasitas, biaya, atau status jika model tersebut disetujui.
- **Operator** (`pelaku ekonomi`): entitas ekonomi dengan inventori, modal, aset, utang, dan prioritas.
- **Event** (`kejadian`, `domain event`): catatan hasil perubahan state; bukan mekanisme mutasi state.
- **Command** (`perintah`): input terstruktur dari UI atau script ke Simulation; API dan permission masih proposal.
- **Snapshot** (`query state`, `read model`): baca state pada satu titik untuk UI, diagnosis, atau automation; model query masih proposal.
- **Flow** (`aggregate flow`, `aliran agregat`): representasi volume atau kualitas agregat tanpa identitas per-item jika model Flow dipilih.
- **Pasar** (`market`): titik atau mekanisme pertukaran harga, stok, dan permintaan.
- **Shipment** (`discrete shipment`, `kiriman`): representasi barang dengan identitas, asal, pemilik, lokasi, kualitas, dan waktu tiba jika model Shipment dipilih.
- **Conveyor** (`konveyor`): moda logistik yang disebut dalam scope terkunci.
- **Simulation** (`simulasi`): layer yang memproses Command, mengubah domain state, lalu menghasilkan Event; tick dan urutan Event masih proposal.
- **Presentation** (`UI`, `tampilan`): layer untuk rendering, kamera, layout, dan interaksi visual.
- **Service** (`layanan`): batas layanan yang membaca atau mengubah state melalui Command dan Snapshot.
- **Produksi** (`production`): domain untuk Recipe, Machine, Buffer, dan diagnosis.
- **Logistik** (`logistics`): domain untuk Node, Edge, Conveyor, Flow, Shipment, dan rute.
- **Ekonomi** (`economy`): domain untuk harga, stok, permintaan, Operator, modal, kontrak, dan siklus.
- **Kondisi pabrik** (`factory condition`): domain untuk energi, panas, keausan, kerusakan, kualitas, dan limbah.
- **Sistem non-politik** (`non-political systems`): domain untuk Cuaca dan lingkungan, Riset dan teknologi, Populasi dan tenaga kerja, dan Keuangan dan modal; efek, skenario, dan parameter masih proposal.
- **Simulasi** (`simulation domain`): domain untuk tick, state, Event, Command, Benchmark, dan batas performa; target tick masih hipotesis kerja.
- **Cuaca dan lingkungan** (`weather`): sistem non-politik untuk efek lingkungan.
- **Riset dan teknologi** (`research`): sistem non-politik untuk perubahan kemampuan dan Recipe.
- **Populasi dan tenaga kerja** (`workforce`): sistem non-politik untuk operasi dan biaya tenaga kerja.
- **Keuangan dan modal** (`finance`): sistem non-politik untuk modal, kredit, utang, dan risiko.
- **Strategi dan ancaman** (`threat`): domain untuk recon, gangguan, pertahanan, dan Recovery.
- **Combat** (`ancaman operasional`): roadmap untuk gangguan infrastruktur; bukan bagian MVP.
- **Benchmark**: pengukuran yang menetapkan batas Sektor, entity, tick, queue, dan memori.
- **Headless**: service Simulation tanpa renderer untuk pengujian jika headless disetujui.

## Katalog Fitur dan Status

| Domain | Status | Cakupan |
|---|---|---|
| Produksi | Disetujui sebagian | Recipe, Machine, Buffer, diagnosis, automation scripting; parameter dan API script terbuka |
| Logistik | Disetujui sebagian | Conveyor untuk MVP; routing, loss, reliability, hybrid Flow/Shipment, dan moda future terbuka |
| Ekonomi | Disetujui sebagai arah | Harga, stok, permintaan, Operator, modal, kontrak, dan siklus; formula serta kontrak terbuka |
| Kondisi pabrik | Disetujui sebagian | Energi dipilih; panas, keausan, kerusakan, kualitas, dan limbah terbuka |
| Sistem non-politik | Disetujui sebagian | Daftar lengkap roadmap saat ini: Cuaca dan lingkungan, Riset dan teknologi, Populasi dan tenaga kerja, Keuangan dan modal; efek, skenario, dan parameter terbuka |
| Strategi dan ancaman | Roadmap disetujui | Combat operasional masuk roadmap; mekanisme combat terbuka |
| Simulasi | Disetujui sebagian | Device dan backend terkunci; target tick berupa hipotesis kerja, belum terkunci; headless, determinisme, pause, replay, save/load, multiplayer terbuka |

## Batas Produk

- Bukan game politik.
- Tidak ada diplomasi, pemilu, ideologi, hukum, atau voting warga.
- Tidak ada planet atau galaksi berganda.
- Combat bukan bagian MVP.
- LibGDX tidak difork dan source-nya tidak dimodifikasi.

## Metrik dan Bukti Produk

- **Playable**: pemain dapat menyelesaikan core loop Produksi, Logistik, dan Ekonomi minimum yang tertulis di roadmap.
- **Explainable**: kegagalan Produksi, Logistik, atau Kondisi pabrik dapat dilacak melalui Event dan UI diagnosis.
- **Bounded**: batas Sektor, entity, tick, queue, dan memori didukung Benchmark Pixel 8.
- **Extendable**: proposal baru tetap conditional sampai keputusan terbuka dan dependency terpenuhi.

## Dependensi Produk Proposal

- Produksi membutuhkan definisi Resource, Recipe, Machine, Buffer, dan Conveyor.
- Logistik membutuhkan Node, Edge, Buffer, dan state Produksi.
- Ekonomi membutuhkan Event Produksi, stok, distribusi, dan keputusan Operator.
- Sistem non-politik membutuhkan Event domain dan cara menampilkan sebab-akibat kepada pemain.
- Combat Roadmap membutuhkan Ekonomi-Logistik stabil serta state infrastruktur yang dapat diganggu dan dipulihkan; Event hanya mencatat hasil.

## Kontrak Dokumen

- [`PRODUK.md`](PRODUK.md): scope, batas produk, status fitur, dan dependensi produk.
- [`fitur/README.md`](fitur/README.md): indeks domain dan status.
- Dokumen domain hanya memakai empat bagian: `Subfitur`, `Dependensi proposal`, `Aturan`, dan `Kriteria selesai proposal`; tidak mendefinisikan scope atau MVP.
- [`roadmap-mvp.md`](roadmap-mvp.md): satu-satunya sumber urutan fase dan kriteria selesai MVP.
- [`keputusan-terbuka.md`](keputusan-terbuka.md): pertanyaan yang belum boleh diisi asumsi; boleh mereferensi scope tanpa mendefinisikannya.

## Aturan Status

- `Disetujui`: pilihan produk sudah eksplisit.
- `Disetujui sebagai arah`: arah produk dipilih; mekanisme dan parameter masih terbuka.
- `Disetujui sebagian`: arah atau subset dipilih; detail masih terbuka.
- `Roadmap disetujui`: masuk urutan roadmap; belum berarti masuk MVP atau sudah selesai.
- `Proposal`: rancangan belum menjadi scope.
- `Terbuka`: belum ada keputusan; jangan mengarang mekanisme.
