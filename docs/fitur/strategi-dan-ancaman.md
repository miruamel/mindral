# Fitur: Strategi dan ancaman


## Subfitur

### Proposal: Ancaman Infrastruktur

- Musuh dapat menargetkan infrastruktur atau sistem terkait.
- Target memakai nilai strategis dan kelemahan pertahanan.
- Aturan targeting belum dikunci.

### Proposal: Detection dan Response

- Recon, alarm, dan informasi tidak lengkap dapat memberi pemain waktu untuk merespons jika fitur tersebut disetujui.
- response dapat memakai rute cadangan, inventori, pertahanan, atau Command lain yang nanti disetujui.
- Fog of war dan kontrol serangan tetap terbuka.

### Recon dan Informasi

- Pemain dapat melihat sebagian status ancaman.
- Informasi dapat tidak lengkap sesuai desain gameplay yang nanti disetujui.
- Fog of war belum dikunci.

### Blokade dan Gangguan Rute

- Ancaman dapat memutus atau memperlambat distribusi.
- Rute cadangan dan inventori menjadi respons gameplay.
- Mekanisme blokade belum dikunci.

### Proposal: Recovery

- Gangguan harus meninggalkan state yang dapat dipulihkan; Event hanya mencatat hasil jika aturan recovery disetujui.
- Pemulihan mengubah state domain; dampak ke Ekonomi dan Logistik dicatat melalui Event jika aturan terkait disetujui.
- Skala, frekuensi, dan target serangan tidak dikunci tanpa keputusan gameplay.

### Konvoi dan Pertahanan

- Pemain dapat melindungi pengiriman atau infrastruktur.
- Pertahanan dapat menggunakan unit, turret, atau sistem lain yang nanti disetujui.
- Jenis unit dan kontrol belum dikunci.

### Sabotase dan Serangan

- Sabotase dapat merusak fasilitas atau mengganggu operasi.
- Serangan dapat menargetkan infrastruktur atau sistem terkait.
- Skala dan frekuensi serangan belum dikunci.

## Dependensi proposal

### Player-Visible

- Pemain melihat recon, alarm, blockade, defense, dan recovery.
- Pemain membaca ancaman pada infrastruktur, rute, dan Ekonomi.

### State dan Data

- Domain memakai state ancaman, target, rute, inventori, Event, Command, dan Snapshot.
- Snapshot digunakan untuk UI dan automation scripting; API automation masih proposal.

### Interaksi Lintas-Domain

- Infrastruktur dan Logistik menyediakan target serta rute.
- Ekonomi membaca dampak gangguan; recovery dapat memulihkan kapasitas jika aturan terkait disetujui.

### Failure dan Diagnosis

- Gangguan dapat memblokir infrastruktur atau rute dan memengaruhi inventori.
- Diagnosis menunjukkan sumber ancaman, dampak, dan opsi recovery jika disetujui.

### Observabilitas

- UI menampilkan recon, alarm, dan overlay gangguan.
- metrik Strategi dan ancaman tetap proposal sampai skenario dan playtest tersedia.

- Ekonomi-Logistik stabil.
- State infrastruktur dan diagnosis Event.
- Hook gangguan Logistik.
- UI untuk recon, alarm, dan pemulihan.
- Keputusan combat dan ancaman tercatat di [`../keputusan-terbuka.md`](../keputusan-terbuka.md).

## Aturan

- Tidak ada detail unit tempur sebelum Ekonomi-Logistik selesai.
- Keputusan yang memblokir combat tercatat di [`../keputusan-terbuka.md`](../keputusan-terbuka.md) sebelum detail unit atau target dianggap selesai.

## Kriteria selesai proposal

- Ancaman memilih target infrastruktur secara dapat dijelaskan.
- Pemain dapat mendeteksi, mencegah, dan memulihkan gangguan.
- Rute cadangan dan inventori mengurangi risiko.
- Ancaman tetap terhubung ke Ekonomi dan Logistik.
