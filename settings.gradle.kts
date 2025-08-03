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

val mod_name: String by settings

rootProject.name = mod_name
rootProject.buildFileName = "root.gradle.kts"

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