# Novi

Open-source music player for Android.

**Repository:** https://github.com/tn3w/novi  
**Tags:** music, audio, player, android, kotlin, jetpack-compose, media3

## Requirements

- Android 8.0+ (API 26)
- Android Studio or Gradle 9.4+

## Build

```bash
./gradlew assembleDebug
```

## Stack

| Layer    | Library                     |
| -------- | --------------------------- |
| UI       | Jetpack Compose + Material3 |
| Playback | Media3 ExoPlayer            |
| Language | Kotlin 2.1                  |

## Project Structure

```
novi/
├── app/
│   ├── src/main/
│   │   ├── java/com/tn3w/novi/MainActivity.kt
│   │   ├── res/
│   │   │   ├── drawable/      # adaptive icon assets (dark bg + play triangle)
│   │   │   ├── mipmap-anydpi-v26/  # ic_launcher + ic_launcher_round
│   │   │   └── values/        # strings.xml, themes.xml
│   │   └── AndroidManifest.xml
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── gradle/
│   ├── libs.versions.toml     # version catalog
│   └── wrapper/
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── local.properties           # sdk.dir=/home/user/Android/Sdk
└── README.md
```

Package: `com.tn3w.novi`, minSdk 26 (Android 8.0)
AGP 8.10.0 + Kotlin 2.1.20 + Compose BOM 2025.04.01
Media3 (ExoPlayer + Session) in version catalog, ready to add when needed
`org.gradle.java.home` set to Java 17 in gradle.properties — AGP 8.x is incompatible with Java 26
Gradle 9.4.0 wrapper, configuration cache + parallel builds enabled
Permissions pre-declared: `READ_MEDIA_AUDIO, FOREGROUND_SERVICE_MEDIA_PLAYBACK`
