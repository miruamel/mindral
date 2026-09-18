# Arsitektur Sistem

> Status: draft. Keputusan teknis yang dikunci dipisah dari komponen kandidat dan proposal.

## Keputusan teknis yang dikunci

- Platform target: Android.
- Device acuan: Pixel 8.
- API target: 35.
- Min SDK: 23.
- Render dan UX: 2D top-down.
- Pondasi: custom engine milik proyek di atas libGDX sebagai backend.
- LibGDX tidak difork dan source-nya tidak dimodifikasi.
- LibGDX menangani renderer 2D, raw platform input, audio, file access, dan Android lifecycle.
- Engine proyek memiliki adapter untuk mengubah raw platform input menjadi game input dan menormalisasi lifecycle.

- Modul Java: `core` untuk domain/engine, `android` untuk launcher dan packaging.
- Package source/namespace: `com.mindral.game`; `applicationId` tetap `com.mindustrial.game` agar upgrade dan data instalasi lama tidak putus.
- libGDX dipin ke `1.14.2`; native `arm64-v8a` berasal dari dependency `gdx-platform:1.14.2:natives-arm64-v8a`, bukan salinan manual di `jniLibs`.
- Toolchain build: Gradle `8.9`, Android Gradle Plugin `8.7.3`, `compileSdk`/`targetSdk` 35, `minSdk` 23.
- Checksum artifact dipin via `gradle/verification-metadata.xml`.
- Native `libgdx.so` dihasilkan dari artifact `gdx-platform` lewat task `copyArm64Natives` ke `build/generated/jniLibs/arm64-v8a` dan ikut masuk APK.
- Host `arm64` memakai wrapper `gradle/aapt2` berbasis `qemu-x86_64`; paket pendukung: `qemu-user`, `libc6-amd64-cross`, `libgcc-s1-amd64-cross`.

## Hipotesis kerja

- Target Simulasi: 30 tick/detik; belum terkunci dan menunggu Benchmark.
- Batas entity, ukuran Sektor, dan hasil Benchmark: belum dikunci.

## Batas tanggung jawab



### Engine Proyek

- game loop;
- semantic game input dan Command;
- Command dan query dari UI;
- kamera, scene, dan presentasi;
- adapter input dan lifecycle;
- candidate save/load dan replay orchestration.

### Backend libGDX

- renderer 2D;
- raw platform input;
- audio;
- file access;
- Android lifecycle;
- integrasi Android yang memang dibutuhkan.

### Kebijakan Versi libGDX

- resolve latest stable saat build pertama;
- pin versi dan checksum hasil resolve;
- jangan menganggap latest stable sebagai versi tetap;
- adapter proyek hanya memakai API publik; source libGDX tidak dimodifikasi.

### Domain Simulation

- Resource;
- Recipe;
- Machine;
- Pasar;
- Operator;
- Logistik;
- Cuaca dan lingkungan;
- Riset dan teknologi;
- Populasi dan tenaga kerja;
- Keuangan dan modal;
- Strategi dan ancaman.

Domain Simulation tidak bergantung pada renderer, UI, atau raw platform input.

## Alur Data Kandidat

1. Engine proyek menerima raw platform input dari libGDX, lalu menerbitkan game input atau Command.
2. UI atau automation script mengirim Command ke Simulation melalui batas Command/query.
3. Simulation memproses Command, mengubah domain state, lalu menerbitkan Event penting.
4. Service membaca atau mengubah state melalui batas service; service tidak membaca objek UI.
5. Snapshot mengirim state ke Presentation untuk UI, overlay, grafik, dan diagnosis.
6. Save/load dan replay hanya aktif jika keputusan Simulasi menyetujuinya.

## Kandidat: Kepemilikan State dan Failure

- Domain Simulation memiliki state gameplay dan aturan transisi.
- Presentation memiliki rendering, kamera, layout, dan interaksi visual.
- Engine proyek memiliki semantic input, Command, lifecycle adapter, dan orchestration.
- libGDX memiliki raw platform input, renderer, audio, file access, dan Android lifecycle.
- Kandidat: kegagalan yang memengaruhi gameplay menjadi state atau Event yang dapat dibaca; failure tidak disembunyikan di layer Presentation.
- Recovery tetap proposal sampai aturan maintenance, kerusakan, dan Command disetujui.


## Komponen Kandidat

- `simulation`: tick, Event queue, Snapshot, dan kemungkinan replay.
- `domain`: model bisnis dan aturan gameplay.
- `services`: Produksi, Ekonomi, Logistik, Kondisi pabrik, Riset dan teknologi, Cuaca dan lingkungan, Populasi dan tenaga kerja, Keuangan dan modal, Strategi dan ancaman.
- `data`: definisi Resource, Recipe, Machine, Conveyor, Sektor, dan skenario.
- `presentation`: UI, overlay, grafik, alert, inspeksi entity.
- `tools`: headless test, debug visualization, metrics, scenario runner.

## Aturan Antarmuka Kandidat

1. UI mengirim Command ke Simulation.
2. Simulation memproses Command dan mengubah domain state; Event mencatat atau menyiarkan hasil, bukan menjadi mekanisme mutasi tanpa keputusan.
3. Service tidak membaca objek UI.
4. Domain model tidak menyimpan referensi renderer.
5. Save menyimpan state domain dan versi schema jika save/load disetujui.
6. headless test menjadi proposal sampai keputusan Simulasi dikunci.
7. Event penting dapat mendukung diagnosis dan replay jika fitur tersebut disetujui.

## Kandidat: Observabilitas dan Pengujian

- Kandidat: Event penting menjadi sumber diagnosis untuk Produksi, Logistik, Kondisi pabrik, Ekonomi, dan Strategi dan ancaman.
- Kandidat: Snapshot menjadi sumber UI dan automation; satu state tidak memiliki salinan yang saling bertentangan.
- Kandidat: Benchmark mengukur tick, entity, Sektor, queue, Buffer, dan memori pada Pixel 8 sebelum batas performa dianggap selesai.
- headless test, replay, metrics, dan scenario runner tetap alat kandidat sampai keputusan Simulasi disetujui.
- Multiplayer tetap terbuka; semua batas service memakai asumsi lokal sampai keputusan baru mengubah scope.

## Level Detail

- Hybrid Flow/Shipment menjadi proposal; batas implementasinya masih terbuka.
- Proposal: aggregate Flow memakai volume/kualitas agregat dan kepemilikan kolektif.
- Proposal: discrete Shipment memakai identitas, asal, pemilik, lokasi, kualitas, dan waktu tiba per Shipment.
- Conveyor tetap satu-satunya moda awal.
- Moda future tidak boleh masuk versi awal tanpa keputusan scope baru.

## Kinerja

Target 30 tick/detik di Pixel 8 menjadi hipotesis kerja, bukan klaim selesai. Benchmark harus menentukan:

- jumlah Sektor maksimum;
- entity per Sektor;
- total entity;
- ukuran Buffer dan Event queue;
- batas update service per tick;
- strategi level of detail.
