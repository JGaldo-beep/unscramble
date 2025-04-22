# 🧩 Unscramble Fruits Game 🍍🍓

Un juego interactivo hecho en **Jetpack Compose** donde el usuario debe adivinar frutas desordenadas letra por letra. Desarrollado como práctica de arquitectura limpia, manejo de estado con `ViewModel`, y diseño reactivo con `StateFlow`.

---

## 🎮 Capturas de Pantalla

| Inicio | Juego en curso | Diálogo final |
|-------|----------------|----------------|
| <img src="https://github.com/user-attachments/assets/6d895eed-c47e-417f-9f0f-70615e3058d5" width="200"/> | <img src="https://github.com/user-attachments/assets/9fbc096b-cc94-4321-bf18-8dcbfcb114be" width="200"/> | <img src="https://github.com/user-attachments/assets/57530afb-da8b-4a53-b13d-d4d8b6d45f80" width="200"/> |

---

## 🚀 Características

- 🔠 Palabras desordenadas al azar (shuffle inteligente)
- 💬 Pistas personalizadas para cada fruta
- 🧠 Comparación inteligente de respuesta sin importar mayúsculas
- 🧮 Contador de palabras y puntaje dinámico
- 🎉 Pantalla de finalización con opción para volver a jugar
- 💾 Gestión de estado usando `ViewModel` y `StateFlow`
- 📱 Diseño responsive con `Jetpack Compose`

---

## 🧱 Arquitectura

El proyecto está basado en una arquitectura MVVM simple:

UI (Jetpack Compose) 

│ 

├── GameViewModel (lógica del juego) 

│ 

└── GameUiState (flujo de datos reactivo con StateFlow)

---

## 🛠️ Tecnologías usadas

- 🧩 Jetpack Compose
- 🧠 Android ViewModel + StateFlow
- 🌐 Internationalización (i18n) con `@StringRes`
- 🎨 Material Design 3
- 🧪 Android Studio

---

## 🧑‍💻 Cómo ejecutar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/JGaldo-beep/unscramble.git
   
2. Ábrelo en Android Studio.
   
3. Ejecuta el proyecto en un emulador o dispositivo físico.

---

## 🙌 Créditos

* Inspirado en ejercicios de Compose de Google Codelabs
