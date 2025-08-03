rootProject.name = "Animation Overhaul"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.essential.gg/repository/maven-public")
        maven("https://maven.fabricmc.net")
        maven("https://maven.architectury.dev/")
        maven("https://maven.minecraftforge.net")
        mavenCentral()
    }
    plugins {
        id("gg.essential.multi-version.root")   version "0.2.2"
        id("gg.essential.multi-version")        version "0.2.2"
        id("org.jetbrains.kotlin.jvm")         version "1.9.24"
        id("com.github.johnrengelman.shadow")  version "8.1.1"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        maven("https://repo.essential.gg/repository/maven-public")
        maven("https://maven.fabricmc.net")
        maven("https://maven.architectury.dev/")
        maven("https://maven.minecraftforge.net")
        maven("https://api.modrinth.com/maven")
        mavenCentral()
    }
}

listOf(
    "1.20.1-fabric",
    "1.20.1-forge",
    "1.19.2-forge",
    "1.19.2-fabric"
).forEach { version ->
    include(":$version")
    project(":$version").apply {
        projectDir = file("versions/$version")
        buildFileName = "../../build.gradle.kts"
    }
}