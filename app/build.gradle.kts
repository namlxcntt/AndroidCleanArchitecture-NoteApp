plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    defaultConfig {
        compileSdk = AndroidSdk.compile
        applicationId = AndroidClient.appId
        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target
        versionCode = AndroidClient.versionCode
        multiDexEnabled = AndroidClient.multidexEnabled
        versionName = AndroidClient.versionName
        testInstrumentationRunner = AndroidClient.testRunner
        vectorDrawables.useSupportLibrary = AndroidClient.useSupportLibrary

    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
    implementation(Libraries.ktxCore)
    implementation(Libraries.appCompat)
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.kotlinCoroutines)
    implementation(Libraries.kotlinCoroutinesAndroid)
    implementation(Libraries.material)
    implementation(Libraries.lifecycleCompiler)
    implementation(Libraries.viewModel)
    implementation(Libraries.liveData)
    implementation(Libraries.lifecycleExtensions)
    implementation(Libraries.cardView)
    implementation(Libraries.recyclerView)
    implementation(Libraries.androidAnnotations)
    implementation(Libraries.glide)
    implementation(Libraries.hilt)
//    implementation(Libraries.hiltCompiler)
    implementation(Libraries.retrofit)
    implementation(Libraries.okHttpLoggingInterceptor)
    implementation(Libraries.constraintLayout)

    // Unit/Android tests dependencies
    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.mockk)
    testImplementation(TestLibraries.kluent)
    testImplementation(TestLibraries.robolectric)

    // Acceptance tests dependencies
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espressoCore)
    androidTestImplementation(TestLibraries.testExtJunit)
    androidTestImplementation(TestLibraries.testRules)
    androidTestImplementation(TestLibraries.espressoIntents)
    androidTestImplementation(TestLibraries.hiltTesting)

    // Development dependencies
    debugImplementation(DevLibraries.leakCanary)
}