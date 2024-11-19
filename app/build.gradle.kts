
plugins {
    id("com.android.application")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "bo.hlva.glotask"
    compileSdk = 33
    
    defaultConfig {
        applicationId = "bo.hlva.glotask"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        
        vectorDrawables { 
            useSupportLibrary = true
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
        
    }
    
}

dependencies {

    // Android Components
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:2.0.0")

    
    // Dagger Hilt
    implementation ("com.google.dagger:hilt-android:2.46.1")
    annotationProcessor ("com.google.dagger:hilt-compiler:2.46.1")

    // Room Database
    implementation ("androidx.room:room-runtime:2.5.0")
    annotationProcessor ("androidx.room:room-compiler:2.5.0"){
    // exclude the sqlite-jdbc dependency from the room-compiler
        exclude (group = "org.xerial", module = "sqlite-jdbc")
    }

    // redefine the sqlite-jdbc dependency with the newest version
    annotationProcessor ("org.xerial:sqlite-jdbc:3.40.1.0")
    
    // Gson
    implementation ("com.google.code.gson:gson:2.10")
    
    // Rxjava
    implementation ("io.reactivex.rxjava3:rxandroid:3.0.2")
    implementation ("io.reactivex.rxjava3:rxjava:3.1.5")
    implementation ("androidx.room:room-rxjava3:2.4.0")

}
