pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.fabricmc.net")
        maven("https://maven.architectury.dev/")
        maven("https://maven.minecraftforge.net")
        maven("https://repo.essential.gg/repository/maven-public")
    }
    val egtVersion = "0.2.2"
    plugins {
        id("gg.essential.multi-version.root") version egtVersion
        id("gg.essential.multi-version") version egtVersion
        id("org.jetbrains.kotlin.jvm") version "1.9.24"
        id("com.github.johnrengelman.shadow") version "8.1.1"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        mavenCentral()
        maven("https://maven.fabricmc.net")
        maven("https://maven.architectury.dev/")
        maven("https://maven.minecraftforge.net")
        maven("https://repo.essential.gg/repository/maven-public")
        maven("https://api.modrinth.com/maven")
    }
    versionCatalogs {
        create("libs")
        create("egt") {
            plugin("multiversion", "gg.essential.multi-version").version(egtVersion)
            plugin("multiversionRoot", "gg.essential.multi-version.root").version(egtVersion)
            plugin("defaults", "gg.essential.defaults").version(egtVersion)
        }
    }
}

val mod_name: String by settings

rootProject.name = mod_name
rootProject.buildFileName = "root.gradle.kts"

listOf(
    "1.20.1-fabric",
    "1.20.1-forge"
).forEach { version ->
    include(":$version")
    project(":$version").apply {
        projectDir = file("versions/$version")
        buildFileName = "../../build.gradle.kts"
    }
}