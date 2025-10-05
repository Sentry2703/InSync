# 🎛️ InSync Looper
**Android / Kotlin / Jetpack Compose / AudioRecord / AudioTrack**

A minimal **local audio looper** built as the foundation for InSync — a real-time collaborative loop layering app.  
This version focuses on clean local recording, layering, and playback of up to **20-second loops**, using **Kotlin coroutines** and **Jetpack Compose** for a modern, reactive experience.

---

## 🚀 Features

🎙️ **Record Loops**
- Capture up to **20 seconds** of microphone audio
- Smooth fade-in/out trimming to eliminate pops

🔁 **Layer Multiple Tracks**
- Stack up to **4 loop layers**
- Mix PCM buffers using Kotlin coroutines in real time

🎨 **Reactive UI**
- Built with **Jetpack Compose** + **Material 3**
- Pads display recording, playing, or idle state dynamically

🧠 **MVVM Architecture**
- `LoopViewModel` drives loop state and playback
- Flows and coroutines power continuous mixing and UI updates

🧩 **Future-Ready**
- Structured to expand toward **WebRTC sync** and **multi-user jamming**
- Ideal prototype for collaborative audio streaming projects

---

## 🧱 Theoretical Project Structure

```bash
InSyncLooper/
├── app/
│   ├── data/
│   │   ├── AudioRecorder.kt      # Handles mic input and PCM capture
│   │   ├── AudioPlayer.kt        # Manages AudioTrack playback
│   │   ├── LoopMixer.kt          # Combines multiple active loops
│   │   └── models/
│   │       └── LoopTrack.kt      # Loop data model (buffer, duration, state)
│   ├── ui/
│   │   ├── LooperScreen.kt       # Compose grid of loop pads
│   │   └── components/
│   │       └── LoopPad.kt        # Individual loop pad composable
│   ├── viewmodel/
│   │   └── LoopViewModel.kt      # MVVM layer for recording/playback state
│   ├── utils/
│   │   └── AudioUtils.kt         # Helpers (fade, normalization, etc.)
│   └── MainActivity.kt
├── README.md
└── build.gradle
```

---

## 🧩 Tech Stack

| Layer | Technology | Purpose |
|-------|-------------|----------|
| UI | Jetpack Compose + Material 3 | Modern, reactive UI |
| Logic | Kotlin Coroutines + Flow | Async audio mixing and timing |
| Audio | AudioRecord / AudioTrack | Low-latency local capture & playback |
| Architecture | MVVM | Separation of concerns |
| Build | Gradle + Android Studio | Project setup |

---

## 🗓 Roadmap

| Phase | Goal | Status |
|-------|------|--------|
| 🎧 1 | Record and play single 20s loop | 🟢 Planned |
| 🔁 2 | Add multiple loop layers | 🟢 Planned |
| 🧠 3 | Refactor into MVVM + Flows | 🟢 Planned |
| 🎨 4 | Compose UI polish + animations | 🟢 Planned |
| 🌐 5 | WebRTC sync for multi-user | 🔵 Future milestone |

---

## 🧠 Concepts to Explore
- **PCM Audio Mixing** in Kotlin  
- **Coroutines for continuous streaming**
- **Jetpack Compose Canvas** for waveform visualization  
- **Realtime scheduling** and buffer alignment in Android  

---

## 🧰 Setup

```bash
git clone https://github.com/yourusername/insync-looper.git
cd insync-looper
```

Then open in **Android Studio Hedgehog+**, and run on a device (microphone access required).

**Permissions:**
```xml
<uses-permission android:name="android.permission.RECORD_AUDIO"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```

---

## 🧑‍💻 Author

**Tunji Adewoye**  
Mobile Engineer | Audio + Real-Time Systems | Kotlin Enthusiast  

> “A simple loop can start a whole jam.”

---

## 🌟 Next Step: InSync (Full Version)
This looper will evolve into **InSync**, a multi-user WebRTC-powered jam platform that synchronizes live audio layers across peers with sub-50ms latency.

Stay tuned for that next phase. 🎶
