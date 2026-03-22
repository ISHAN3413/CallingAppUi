# 📱 Calling App (Android)

This is a simple calling app UI built using Kotlin and Jetpack Compose. The goal of this project was to understand how call flows work and how to manage UI states properly in Android.

---

## 🚀 What this app does

The app simulates a basic phone calling experience:

* You can enter a number using a dial pad
* Start a call and see a “Calling…” screen
* Simulate an incoming call
* Accept/reject calls
* See an active call screen with a running timer
* Toggle mute and speaker (UI only)
* End the call anytime

---

## 🔁 Call Flow

The whole app is driven by a simple state flow:

Idle → Calling → Ringing → Active → Ended

This was the main focus of the project — making sure transitions between these states are clean and predictable.

---

## 🛠️ Tech Used

* Kotlin
* Jetpack Compose
* Navigation Compose
* ViewModel (MVVM)
* Coroutines

---

## 🧠 How it’s structured

I kept things simple:

* A single ViewModel manages the call state and data
* UI is stateless and reacts to state changes
* Navigation switches screens based on the current call state

---

## 🔊 Extra stuff

To make it feel a bit more real:

* Added ringtone for incoming calls
* Added dialing sound for outgoing calls
* Added vibration for incoming calls

---

## ❗ Note

This app does **not** make real phone calls.
It’s just a simulation focused on UI and state management.
Real calling requires system-level APIs which are outside the scope of this project.

---

## ▶️ How to run

1. Clone the repo
2. Open in Android Studio
3. Run on emulator or device

---

## 📌 What I learned

* Managing UI with state (very important in Compose)
* Handling navigation properly
* Structuring a small app using MVVM
* Avoiding unnecessary complexity

---

## 🔮 Can be improved

* Add contacts integration
* Improve UI design
* Add animations between screens
* Add call history

---

## 👨‍💻 Author

Ishan

---
