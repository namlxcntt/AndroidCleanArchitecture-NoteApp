plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroidJB)
    id(BuildPlugins.kotlinKapt)
}

android {
    compileSdk = AndroidSdk.compile

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(Libraries.kotlinStdLib)
    api(Libraries.kotlinCoroutines)
    api(Libraries.kotlinCoroutinesAndroid)
    api(Libraries.ktxCore)
    api(Libraries.material)
    api(Libraries.lifecycleExtensions)
    api(Libraries.cardView)
    api(Libraries.recyclerView)
    api(Libraries.androidAnnotations)
    api(Libraries.glide)
    api(Libraries.constraintLayout)
    api(Libraries.appCompat)
}