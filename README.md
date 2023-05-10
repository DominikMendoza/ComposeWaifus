# Guia para desarrollo mobile
## Estructura basica
### data
- **local**
    - AppDatabase
    - FileNameDao
    - FileNameEntity
- **model**
    - FileName.kt
- **remote**
    - FileNameClient
### repository
- FileNameRepository
### ui
- **screens**
    - FileName.kt
    - FileNameViewModel
- **theme**
    - defaultcfg

## Configuracion del proyecto
### Modificar los plugins
```shell
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'kotlin-kapt'
}
```

### Agregar las dependencias de Gradle
```shell
// lifecycle
def lifecycle_version = "2.6.1"
implementation "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version"
implementation "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version"
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"

// networking
def retrofit_version = "2.9.0"
implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"

// compose image
def coil_version = "2.3.0"
implementation "io.coil-kt:coil-compose:$coil_version"

// architecture components
def room_version = "2.5.1"
implementation "androidx.room:room-runtime:$room_version"
kapt "androidx.room:room-compiler:$room_version"
```

### Agregar los permisos en AndroidManifest.xml 
```xml
<uses-permission android:name="android.permission.INTERNET"/> 
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/> 
```