import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    checkstyle
    findbugs
    id("com.vanniktech.android.junit.jacoco") version "0.13.0"
}

android {
    compileSdkVersion(28)

    defaultConfig {
        applicationId = "com.example.felipe.catchthatbus"
        minSdkVersion(22)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "0.0.9"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        setProperty("archivesBaseName", "catch-that-bus-$versionName")
    }

    sourceSets["debug"].java.srcDir("build/generated/not_namespaced_r_class_sources/debug")

    buildTypes {
        this["release"].apply {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        this["debug"].apply {
            isTestCoverageEnabled = true
        }
    }
}

dependencies {
    val androidVersion = "28.0.0"
    val junitVersion = "5.3.2"

    implementation(fileTree(
        mapOf("dir" to "libs",
              "include" to listOf("*.jar"))
    ))
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.1")
    implementation("com.android.support:appcompat-v7:$androidVersion")
    implementation("com.android.support:recyclerview-v7:$androidVersion")
    implementation("com.android.support:design:$androidVersion")
    implementation("com.android.support.constraint:constraint-layout:1.1.3")
    implementation("com.android.support:support-annotations:$androidVersion")
    implementation("org.yaml:snakeyaml:1.23")
    implementation("org.greenrobot:eventbus:3.1.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("io.mockk:mockk:1.9")
    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
}

junitJacoco {
    jacocoVersion = "0.8.2" // type String
    includeNoLocationClasses = false
    includeInstrumentationCoverageInMergedReport = false
}

tasks {
    withType<Test> {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}