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

    buildFeatures {
        viewBinding = true
    }
    defaultConfig{
        buildConfigField("String","SHARE_PREFERENCE_NAME","\"Note_app_share_preference\"")
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
    api(Libraries.hilt)
    kapt(Libraries.hiltCompilerKtx)
    api(Libraries.calligraphy3)
    api(Libraries.viewPump)

}