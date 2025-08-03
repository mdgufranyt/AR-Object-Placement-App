# AR Object Placement App

An Android application built with Kotlin that enables users to place and interact with 3D objects in augmented reality using ARCore technology.

## 📱 Overview

This AR Object Placement App allows users to:
- Place virtual 3D objects in real-world environments
- Interact with placed objects through touch gestures
- Experience immersive augmented reality functionality
- Utilize device camera for real-time AR rendering

## 🚀 Features

- **Real-time AR Object Placement**: Place 3D models in your physical environment
- **Touch Interactions**: Tap to place, move, and manipulate objects
- **ARCore Integration**: Leverages Google's ARCore for robust AR tracking
- **3D Model Support**: Support for various 3D model formats
- **Intuitive UI**: User-friendly interface for seamless AR experience

## 🛠️ Tech Stack

- **Language**: Kotlin
- **Platform**: Android
- **AR Framework**: Google ARCore
- **3D Rendering**: OpenGL ES / Sceneform (likely)
- **Build System**: Gradle

## 📋 Prerequisites

Before running this application, ensure you have:

- Android Studio Arctic Fox (2020.3.1) or later
- Android SDK with minimum API level 24 (Android 7.0)
- ARCore supported device ([Check device compatibility](https://developers.google.com/ar/devices))
- Kotlin 1.5+ support
- OpenGL ES 3.0 support on target device

## 🔧 Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/mdgufranyt/AR-Object-Placement-App.git
cd AR-Object-Placement-App
```

### 2. Open in Android Studio
1. Launch Android Studio
2. Select "Open an existing Android Studio project"
3. Navigate to the cloned repository folder
4. Click "OK" to open the project

### 3. Configure Dependencies
```bash
# Sync project with Gradle files
# Android Studio should automatically prompt for this
```

### 4. ARCore Setup
Ensure your `app/build.gradle` includes:
```kotlin
dependencies {
    implementation 'com.google.ar:core:1.34.0'
    implementation 'com.google.ar.sceneform:core:1.17.1'
    // Other dependencies...
}
```

### 5. Add Permissions
Verify `AndroidManifest.xml` contains:
```xml
<uses-permission android:name="android.permission.CAMERA" />
<uses-feature android:name="android.hardware.camera.ar" android:required="true"/>
```

## 🏃‍♂️ How to Run

### Method 1: Using Android Studio
1. Connect your ARCore-compatible Android device via USB
2. Enable "Developer Options" and "USB Debugging" on your device
3. In Android Studio, select your device from the device dropdown
4. Click the "Run" button (green play icon) or press `Shift + F10`
5. Grant camera permissions when prompted on the device

### Method 2: Using Command Line
```bash
# Navigate to project directory
cd AR-Object-Placement-App

# Build the project
./gradlew assembleDebug

# Install on connected device
./gradlew installDebug

# Or build and install in one command
./gradlew build installDebug
```

### Method 3: Generate APK
```bash
# Generate debug APK
./gradlew assembleDebug

# APK will be generated at:
# app/build/outputs/apk/debug/app-debug.apk
```

## 📱 Usage Instructions

1. **Launch the App**: Open the AR Object Placement App on your device
2. **Grant Permissions**: Allow camera access when prompted
3. **Initialize AR**: Point your camera at a flat surface and move slowly to help ARCore detect the environment
4. **Place Objects**: Tap on detected surfaces to place 3D objects
5. **Interact**: Use touch gestures to move, rotate, or scale placed objects
6. **Explore**: Move around to view objects from different angles

## 🔍 Troubleshooting

### Common Issues:

**ARCore not detecting surfaces:**
- Ensure good lighting conditions
- Point camera at textured, flat surfaces
- Move device slowly to help with tracking

**App crashes on startup:**
- Verify device supports ARCore
- Check camera permissions are granted
- Ensure minimum Android version (API 24+)

**Performance issues:**
- Close other apps to free memory
- Ensure device meets OpenGL ES 3.0 requirements
- Restart the app if tracking becomes unstable

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is open source. Please check the repository for license details.

## 🙋‍♂️ Support

If you encounter any issues or have questions:
- Open an issue on GitHub
- Check ARCore documentation: [developers.google.com/ar](https://developers.google.com/ar)
- Verify device compatibility with ARCore

## 🔗 Useful Links

- [ARCore Developer Guide](https://developers.google.com/ar)
- [Sceneform Documentation](https://developers.google.com/sceneform)
- [Android AR Samples](https://github.com/google-ar/arcore-android-sdk)
- [Kotlin Documentation](https://kotlinlang.org/docs/)

---

**Repository**: [mdgufranyt/AR-Object-Placement-App](https://github.com/mdgufranyt/AR-Object-Placement-App)  
**Created**: August 2, 2025  
**Language**: Kotlin  
**Platform**: Android
