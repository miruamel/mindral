# Keputusan Terbuka

Dokumen ini menyimpan pertanyaan yang belum boleh diisi asumsi.

## Aturan Resolusi

- Jawaban harus memisahkan fakta, proposal, dan asumsi.
- Keputusan yang mengubah scope hanya sah setelah dicatat di [`PRODUK.md`](PRODUK.md).
- Keputusan yang mengubah urutan atau kriteria MVP hanya sah setelah dicatat di [`roadmap-mvp.md`](roadmap-mvp.md).
- Detail teknis mengikuti [`arsitektur.md`](arsitektur.md); detail domain mengikuti dokumen di [`fitur/`](fitur/README.md).
- Pertanyaan tanpa bukti tetap terbuka; jangan mengisi angka, formula, atau mekanisme dari tebakan.

## Format Keputusan

Setiap keputusan yang sudah disetujui harus menyimpan:

- **Pertanyaan:** keputusan apa yang diambil.
- **Dampak:** scope, roadmap, arsitektur, atau domain mana yang berubah.
- **Bukti:** Benchmark, playtest, constraint, atau sumber yang mendukung.
- **Keputusan:** pilihan final dalam kalimat tunggal.
- **Konsekuensi:** yang menjadi lebih mudah, lebih sulit, atau dilarang.
- **Status:** `proposed`, `accepted`, `deprecated`, atau `superseded`.
- **Tanggal keputusan:** tanggal keputusan dicatat dalam format ISO.

## Prioritas Keputusan

- **Blocker fondasi:** libGDX pin/checksum, input ownership, Benchmark, dan batas Simulasi.
- **Blocker MVP:** automation API/permission, Ekonomi minimum, dan prioritas Kondisi pabrik.
- **Blocker roadmap:** masa depan moda Logistik, Combat, multiplayer, replay, dan save/load.
- **Non-blocker:** detail yang dapat ditunda sampai playtest tanpa mengubah urutan fase.


## Engine dan Backend

- [x] LibGDX latest stable `1.14.2` sudah di-resolve dan dipin.
- [x] Checksum artifact dipin via `gradle/verification-metadata.xml` untuk `gdx`, `gdx-backend-android`, dan `gdx-platform:natives-arm64-v8a`.
- [x] Native `libgdx.so` dipackaging dari artifact `gdx-platform` lewat task `copyArm64Natives`.
- Adapter proyek menormalisasi raw platform input dan lifecycle seperti apa?
- Apakah audio, file access, dan Android lifecycle seluruhnya memakai API publik libGDX?
- Apakah ada constraint lisensi atau distribusi khusus?

## Input Ownership

- Raw platform input mana yang perlu dipertahankan sebagai game input atau Command?
- Format game input dan Command seperti apa?
- Siapa yang memiliki mapping tombol, gesture, dan accessibility action?

## Performa

- Berapa jumlah Sektor maksimum per sesi?
- Berapa entity per Sektor?
- Berapa total entity?
- Berapa ukuran Buffer dan Event queue?
- Berapa batas update service per tick?
- Berapa target memori dan batas thermal Pixel 8?

## Cakupan Sistem non-politik

- Daftar lengkap roadmap saat ini: Cuaca dan lingkungan, Riset dan teknologi, Populasi dan tenaga kerja, dan Keuangan dan modal.
- Sistem tambahan belum termasuk; keputusan scope baru diperlukan untuk menambah Sistem non-politik.

## Ekonomi

- Formula harga lokal seperti apa?
- Jenis kontrak apa yang masuk MVP?
- Bagaimana kredit, bunga, kebangkrutan, dan restrukturisasi bekerja?
- Berapa banyak Operator minimum untuk MVP?
- Apa arti “ekonomi penuh” dalam ukuran sesi pertama?

## Produksi dan Scripting

- Bahasa atau format automation scripting apa?
- API baca state dan Command apa yang tersedia?
- Permission dan sandbox seperti apa?
- Apakah script dapat menjadwalkan maintenance, Recipe, dan routing?
- Parameter energi, panas, keausan, kerusakan, kualitas, by-product, limbah, dan cacat seperti apa?

## Logistik

- Kapan Truk, Kereta, Kapal, Pesawat, dan Pipa masuk roadmap?
- Apa syarat sebuah moda future dianggap siap masuk MVP berikutnya?
- Bagaimana batas aggregate Flow dan discrete Shipment?
- Apakah discrete Shipment memerlukan identitas, pemilik, lokasi, kualitas, dan waktu tiba per Shipment?
- Apakah aggregate Flow memakai volume/kualitas agregat dan kepemilikan kolektif?
- Apakah routing, loss, reliability, congestion, dan delay masuk scope final?

## Simulasi

- Apakah Simulasi wajib deterministik?
- Apakah pause dan speed control wajib?
- Apakah replay dan diagnosis Event wajib?
- Apakah multiplayer masuk scope?
- Format save dan migrasi schema seperti apa?

## Combat Roadmap

- Apakah Combat memakai unit, turret, atau sistem lain?
- Siapa yang mengendalikan serangan dan pertahanan?
- Apakah ada fog of war?
- Bagaimana target infrastruktur dipilih?
- Bagaimana combat terhubung ke Ekonomi dan Logistik?

## UX dan Aksesibilitas

- Kontrol touch seperti apa?
- Orientasi layar portrait, landscape, atau keduanya?
- Skala UI dan readable text seperti apa?
- Tutorial dan onboarding seperti apa?
- Requirement aksesibilitas apa yang wajib?

## Deliverable

- Dokumentasi ini menjadi product context awal; capability contract terpisah belum diputuskan.
- Apakah capability contract terpisah diperlukan? Jika ya, sumber kanonis dan formatnya harus diputuskan sebelum dibuat.
- Rencana implementasi task-by-task dibuat setelah keputusan blocker selesai.
