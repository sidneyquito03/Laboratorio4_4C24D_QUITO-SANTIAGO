plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.quitosantiago.sidney.laboratorio4calificado"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.quitosantiago.sidney.laboratorio4calificado"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures{
        viewBinding=true
    }
    //Es para que haya una mejor relación entre las vistas y sus identificadores, simplificando el acceso a los elementos de la interfaz.
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.crashlytics.buildtools)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
// Dependencias relacionadas con CameraX
    val cameraxVersion = "1.0.1"

    // CameraX core library usando la implementación de Camera2
    implementation("androidx.camera:camera-camera2:$cameraxVersion")

    // CameraX Lifecycle Library para integración con el ciclo de vida de los componentes de la app
    implementation("androidx.camera:camera-lifecycle:$cameraxVersion")

    // CameraX View para mostrar el contenido de la cámara en la interfaz de usuario
    implementation("androidx.camera:camera-view:1.0.0-alpha27")

    // Dependencia para cargar imágenes de manera eficiente con Glide
    implementation("com.github.bumptech.glide:glide:4.12.0")
}

//En las dependencias he agregado todo lo necesario para que la cámara pueda funcionar bien, ya que si
//no hay dependencias agregadas, no es posible que lo puse en el android manifest funcionen