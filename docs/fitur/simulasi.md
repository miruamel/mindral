# Fitur: Simulasi


## Subfitur

### Proposal: Tick dan Event

- Simulation memproses Command pada setiap tick; Event hanya mencatat hasil yang terjadi.
- Event penting dapat mendukung diagnosis dan replay jika fitur tersebut disetujui.

### Proposal: State dan Waktu

- Domain state terpisah dari Presentation dan raw platform input.
- Urutan tick, Event, dan Command belum dikunci.
- Determinisme tidak boleh diasumsikan sebelum keputusan Simulasi.

### Proposal: Pause dan Speed Control

- Pemain dapat menghentikan atau mengubah kecepatan Simulasi jika fitur tersebut disetujui.

### Proposal: Replay dan Diagnosis

- Event dapat direkam untuk diagnosis dan replay jika determinisme serta replay disetujui.

### Proposal: Kinerja dan Batas

- Benchmark Pixel 8 menentukan batas Sektor, entity, tick, queue, Buffer, dan memori.
- Target 30 tick/detik tetap hipotesis kerja, bukan klaim selesai.
- Tidak ada angka performa final sebelum bukti Benchmark.

### Proposal: Save/Load

- State domain dan versi schema dapat disimpan serta dimuat jika save/load disetujui.

### Proposal: Headless dan Multiplayer

- headless test menjalankan Service tanpa renderer jika disetujui.
- Multiplayer tetap terbuka dan tidak dianggap ada.

### Proposal: Error dan Recovery

- Failure gameplay harus terlihat melalui state atau Event, bukan hanya log internal.
- recovery Command dan retry policy tetap proposal sampai aturan terkait disetujui.
- Tidak ada silent fallback yang mengubah domain state tanpa keputusan.

### Proposal: Arsitektur

- Domain state terpisah dari Presentation.
- Service membaca dan mengubah state melalui batas yang jelas.
- UI mengirim Command dan membaca Snapshot.

## Dependensi proposal

### Player-Visible

- Pemain melihat tick, speed, pause, state, dan Event.
- Replay, save/load, dan headless tetap conditional sampai keputusan Simulasi.

### State dan Data

- Domain memakai domain state, Event queue, Command, Snapshot, dan schema.
- Simulation memproses Command dan mengubah state; Event mencatat atau menyiarkan hasil.

### Interaksi Lintas-Domain

- Service membaca atau mengubah state melalui batas Command dan Snapshot.
- UI, automation scripting, dan headless test memakai batas yang sama jika disetujui.

### Failure dan Diagnosis

- Failure gameplay menjadi state atau Event yang dapat dibaca; tidak ada silent fallback.
- Recovery, replay, dan diagnosis tetap proposal sampai keputusan Simulasi.

### Observabilitas

- Benchmark, metrics, Event, dan UI menjadi sumber pemeriksaan.

- Domain state dan Event model.
- Command/Snapshot boundary.
- Benchmark performa.
- UI diagnosis dan overlay.
- Save/replay infrastructure jika disetujui.
- Keputusan headless, determinisme, pause, replay, save/load, dan multiplayer tercatat di [`../keputusan-terbuka.md`](../keputusan-terbuka.md).

## Aturan

- Headless, determinisme, pause, replay, save/load, dan multiplayer tidak boleh dianggap ada.
- Benchmark menentukan batas Sektor, entity, Event queue, dan memori.
- Keputusan yang memblokir Simulasi tercatat di [`../keputusan-terbuka.md`](../keputusan-terbuka.md) sebelum batas performa dianggap selesai.

## Kriteria selesai proposal

- Simulation dapat berjalan tanpa UI jika Headless disetujui.
- Tick dapat dihentikan untuk pengujian jika pause disetujui.
- State dapat disimpan dan dimuat jika save/load disetujui.
- Event penting tercatat untuk diagnosis jika Event/replay disetujui.
- Benchmark menentukan batas konkret sebelum performa dianggap selesai.
