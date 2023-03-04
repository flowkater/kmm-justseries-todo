buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    val sqlDelightVersion = "1.5.5"

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.22")
        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
        classpath("com.android.tools.build:gradle:7.4.2")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
