import com.android.build.gradle.internal.api.BaseVariantOutputImpl

plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.androidHilt)
    id(BuildPlugins.kotlinParcelize)
    id("org.jetbrains.kotlin.android")
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
        buildConfigField("String","SHARE_PREFERENCE_NAME","\"Note_app_share_preference\"")
        buildConfigField("String","DATABASE_NAME","\"note_app_database\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        applicationVariants.all {
            val variant = this
            variant.outputs
                .map { it as BaseVariantOutputImpl }
                .forEach { output ->
                    val outputFileName = variant.name +
                            "_${name}" +
                            "_versionName:${variant.versionName}" +
                            "_${getCurrentDayTime()}.apk"
                    output.outputFileName = outputFileName
                }
        }

    }
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
    implementation(Libraries.retrofit)
    implementation(Libraries.okHttpLoggingInterceptor)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.conflictGuava)
    implementation(Libraries.lifeCycleRuntime)
//    implementation(Libraries.hiltViewModels)
    implementation(Libraries.activityKtx)
    implementation(Libraries.fragmentKtx)
    implementation(Libraries.calligraphy3)
    implementation(Libraries.viewPump)


    kapt(Libraries.hiltCompilerKtx)

    implementation(project(path = SubModule.data))
    implementation(project(path = SubModule.domain))
    implementation(project(path = SubModule.platform))


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
//    debugImplementation(DevLibraries.leakCanary)
}