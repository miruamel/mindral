plugins {
    id("com.android.application")
}

val arm64Natives by configurations.creating {
    isCanBeResolved = true
}

android {
    namespace = "com.mindral.game"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.mindustrial.game"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "0.1.11"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    androidComponents {
        onVariants { variant ->
            variant.sources.jniLibs?.addStaticSourceDirectory(
                layout.buildDirectory.dir("generated/jniLibs").get().asFile.absolutePath
            )
        }
    }
}

dependencies {
    implementation(project(":core"))
    implementation("com.badlogicgames.gdx:gdx-backend-android:1.14.2") {
        exclude(group = "androidx.core", module = "core")
    }
    implementation("com.badlogicgames.gdx:gdx-platform:1.14.2:natives-arm64-v8a")
    add(arm64Natives.name, "com.badlogicgames.gdx:gdx-platform:1.14.2:natives-arm64-v8a")
    implementation("androidx.core:core:1.19.0")
}

val copyArm64Natives by tasks.registering(Copy::class) {
    from(zipTree(arm64Natives.singleFile))
    into(layout.buildDirectory.dir("generated/jniLibs/arm64-v8a"))
    include("libgdx.so")
}

tasks.named("preBuild") {
    dependsOn(copyArm64Natives)
}
