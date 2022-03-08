plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.androidHilt)
    id(BuildPlugins.kotlinParcelize)
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
        applicationVariants.all {
            val variant = this
            variant.outputs
                .map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
                .forEach { output ->
                    val outputFileName = variant.name +
                    "_${name}" +
                    "_versionName:${variant.versionName}" +
                    "_${getCurrentDayTime()}.apk"
                    output.outputFileName = outputFileName
                }
        }
//
//
//        productFlavors {
//            create("staging") {
//                dimension = "feature-dimension"
//                applicationId =AndroidClient.appId
//                // This is field and configs staging environment
//            }
//
//            create("feature-dimension") {
//                dimension = "type"
//                applicationId =AndroidClient.appId
//                // This is field and configs dev environment
//            }
//
//            create("product") {
//                dimension = "feature-dimension"
//                applicationId =AndroidClient.appId
//                // This is field and configs product environment
//            }
//        }

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

    kapt(Libraries.hiltCompilerKtx)

    implementation(project(path = SubModule.data))
    implementation(project(path = SubModule.domain))


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