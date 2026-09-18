# Fitur: Ekonomi


## Subfitur

### Proposal: Pasar Lokal

- Proposal: setiap Sektor atau lokasi dapat memiliki pasar sendiri.
- Proposal: harga merespons stok, permintaan, transaksi, dan biaya distribusi.
- Proposal: harga tidak harus sama antar-Sektor.
- Formula harga, spread, dan interval update belum dikunci.

### Proposal: Stok dan Permintaan

- Stok berubah karena Produksi, distribusi, kontrak, dan keputusan Operator jika aturan terkait disetujui.
- Permintaan dapat berasal dari skenario atau keputusan Operator; sumbernya belum dikunci.
- Tidak ada formula harga atau interval update sebelum playtest.

### Proposal: Resource dan Valuasi

- Proposal: Resource memiliki nilai dasar, kualitas, dan kemungkinan rusak atau kadaluarsa jika disetujui.
- Proposal: nilai Resource dapat berubah berdasarkan lokasi dan konteks.
- Parameter valuasi belum dikunci.

### Proposal: Operator

- Proposal: Operator memiliki inventori, modal, aset, utang, dan prioritas.
- Proposal: Operator dapat membeli, menjual, menimbun, memproduksi, dan berinvestasi.
- Proposal: Operator dapat gagal memenuhi kewajiban sesuai aturan Keuangan dan modal yang nanti disetujui.
- Jumlah Operator belum dikunci.

### Proposal: Kontrak dan Perdagangan

- Proposal: kontrak dapat mengikat jumlah, harga, waktu, dan lokasi.
- Proposal: kegagalan kontrak dapat memiliki konsekuensi ekonomi.
- Jenis kontrak, penalti, dan mekanisme clearing belum dikunci.

### Proposal: Laba/Rugi dan Risiko

- Biaya, pendapatan, modal, utang, dan likuiditas dapat menjadi sumber risiko Operator jika sistem Keuangan dan modal disetujui.
- Kegagalan kontrak atau kewajiban dapat memengaruhi Ekonomi sesuai aturan yang nanti disetujui.
- Tidak ada formula bunga, penalti, kebangkrutan, atau restrukturisasi sebelum keputusan.

### Proposal: Modal dan Siklus Ekonomi

- Proposal: investasi menambah kapasitas atau efisiensi.
- Proposal: kredit dan utang memengaruhi likuiditas dan risiko.
- Proposal: kebangkrutan, restrukturisasi, dan siklus pasar dapat memengaruhi siklus Ekonomi.
- Aturan kredit, bunga, kebangkrutan, dan siklus belum dikunci.

### Proposal: Hubungan dengan Logistik

- Proposal: biaya pengiriman dapat memengaruhi harga sampai.
- Proposal: keterlambatan dan kehilangan barang dapat memengaruhi stok dan kontrak.
- Proposal: rute cadangan dapat mengurangi risiko dengan biaya tambahan.

### Proposal: Observabilitas

- Pemain dapat melihat harga, stok, biaya, pendapatan, dan risiko Operator jika metrik tersebut disetujui.
- Dampak gangguan Produksi atau Logistik terlihat melalui Event dan UI Ekonomi.

## Dependensi proposal

### Player-Visible

- Pemain melihat harga, stok, biaya, pendapatan, dan risiko.
- Pemain membaca dampak pasokan, permintaan, Produksi, dan Logistik.

### State dan Data

- Domain memakai Operator, inventori, modal, kontrak, Event, Command, dan Snapshot.
- Snapshot digunakan untuk UI dan automation scripting; API automation masih proposal.

### Interaksi Lintas-Domain

- Command mengubah stok, biaya, dan risiko; game input atau Command masuk melalui batas input.
- Keuangan dan modal dapat memengaruhi investasi serta kontinuitas jika sistem tersebut disetujui.

### Failure dan Diagnosis

- Kegagalan kontrak, pasokan, Produksi, atau Logistik terlihat pada Ekonomi.
- Diagnosis menunjukkan sebab dan efek pada harga, stok, biaya, atau risiko.

### Observabilitas

- UI menampilkan harga, stok, biaya, pendapatan, dan risiko.
- metrik Ekonomi tetap proposal sampai formula dan playtest tersedia.

- Event Produksi dan stok.
- Logistik untuk biaya, delay, loss, dan rute.
- Operator state dan keputusan.
- UI untuk harga, biaya, pendapatan, dan risiko.
- Keuangan dan modal jika kredit atau kebangkrutan disetujui.
- Keputusan formula, kontrak, kredit, dan Operator minimum tercatat di [`../keputusan-terbuka.md`](../keputusan-terbuka.md).

## Aturan

- Tidak ada formula harga, kontrak, bunga, atau kebangkrutan final sebelum playtest.
- Tidak ada asumsi warga per orang sebagai requirement utama.
- Keputusan yang memblokir Ekonomi tercatat di [`../keputusan-terbuka.md`](../keputusan-terbuka.md) sebelum formula dianggap selesai.

## Kriteria selesai proposal

- Perubahan pasokan atau permintaan menghasilkan perubahan harga yang dapat dijelaskan.
- Pemain dapat melihat biaya, pendapatan, stok, dan risiko Operator.
- Kegagalan Logistik terlihat dampaknya pada Ekonomi.
- Semua aturan ekonomi yang belum disetujui tercatat di [`../keputusan-terbuka.md`](../keputusan-terbuka.md).
