# Dokumentasi Mindral

> Status: draft. `PRODUK.md` menjadi sumber kebenaran scope; dokumen lain mengikuti kontrak di sana.

## Peta Dokumen

- [`PRODUK.md`](PRODUK.md): tujuan, scope terkunci, batas produk, status fitur, dependensi, dan kontrak dokumen.
- [`arsitektur.md`](arsitektur.md): keputusan teknis dan batas ownership engine/libGDX.
- [`fitur/README.md`](fitur/README.md): indeks domain dan status.
- [`roadmap-mvp.md`](roadmap-mvp.md): satu-satunya sumber urutan fase dan kriteria selesai MVP.
- [`keputusan-terbuka.md`](keputusan-terbuka.md): pertanyaan yang belum boleh diisi asumsi.

## Cara Memakai

1. Baca [`PRODUK.md`](PRODUK.md) untuk scope, batas, status, dan glosarium.
2. Baca [`roadmap-mvp.md`](roadmap-mvp.md) untuk urutan fase, prerequisite, dan bukti selesai.
3. Baca [`keputusan-terbuka.md`](keputusan-terbuka.md) untuk pertanyaan yang masih memblokir keputusan.
4. Baca [`arsitektur.md`](arsitektur.md) untuk ownership engine, domain, Presentation, dan libGDX.
5. Baca domain di [`fitur/`](fitur/README.md) untuk proposal subfitur, dependency, aturan, dan kriteria selesai.

## Peran Dokumen

- **Konstitusi:** [`PRODUK.md`](PRODUK.md) menentukan scope, batas, status, dan kontrak dokumen.
- **Peta:** dokumen ini dan [`arsitektur.md`](arsitektur.md) menunjuk sumber detail.
- **Status:** katalog di [`PRODUK.md`](PRODUK.md) dan fase di [`roadmap-mvp.md`](roadmap-mvp.md) menunjukkan arah serta urutan.
- **Riwayat:** bagian di bawah menyimpan koreksi material dan perubahan kontrak.


## Aturan Pembaruan

- Scope hanya berubah di [`PRODUK.md`](PRODUK.md).
- Domain docs hanya memakai `Subfitur`, `Dependensi proposal`, `Aturan`, dan `Kriteria selesai proposal`.
- Urutan fase dan kriteria selesai MVP hanya ditulis di [`roadmap-mvp.md`](roadmap-mvp.md); [`PRODUK.md`](PRODUK.md), indeks, dan open decisions boleh mereferensi scope.
- Detail belum disetujui masuk [`keputusan-terbuka.md`](keputusan-terbuka.md) atau diberi label proposal.
- Gunakan Markdown link untuk semua referensi dokumen.

## Riwayat Perubahan

- 2026-09-17: `PRODUK.md` ditetapkan sebagai sumber scope; `roadmap-mvp.md` menjadi sumber urutan fase dan kriteria selesai; domain docs distandarkan ke empat bagian exact.
- 2026-09-17: glosarium, loop produk, metrik bukti, alur data kandidat, gate roadmap, dan format keputusan ditambahkan tanpa mengubah scope.
