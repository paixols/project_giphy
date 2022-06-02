plugins {
    id("com.android.application")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
    id("de.mannodermaus.android-junit5")
    id("org.jlleitschuh.gradle.ktlint") version PluginVersions.ktlint
    id("org.jmailen.kotlinter") version PluginVersions.kotlinter
    id("com.diffplug.spotless") version PluginVersions.spotless
    id("kotlin-kapt")
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildTools

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        applicationId = AppConfig.applicationId
        testInstrumentationRunner = TestConfig.runner
        testInstrumentationRunnerArguments[TestConfig.runnerArgumentsKey] =
            TestConfig.runnerArgumentsValue
        multiDexEnabled = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

}

dependencies {
    AndroidXLibs.implementations.forEach { dependency -> implementation(dependency) }

    KotlinLibs.implementations.forEach { dependency -> implementation(dependency) }

    ThirdPartyLibs.implementations.forEach { dependency -> implementation(dependency) }

    Network.implementations.forEach { dependency -> implementation(dependency) }

    DependencyInjection.apply {
        kaptImplementations.forEach { dependency -> kapt(dependency) }
        implementations.forEach { dependency -> implementation(dependency) }
    }

    TestLibs.run {
        testImplementations.forEach { dependency -> testImplementation(dependency) }
        androidTestImplementations.forEach { dependency -> androidTestImplementation(dependency) }
        androidTestRuntimeOnly.forEach { dependency -> androidTestRuntimeOnly(dependency) }
    }
}