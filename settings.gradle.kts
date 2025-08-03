pluginManagement {
    repositories {
        maven("https://repo.essential.gg/repository/maven-public")
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        mavenCentral {
            content {
                includeGroup("net.jodah")
            }
        }
        maven("https://maven.minecraftforge.net") {
            content {
                excludeGroup("net.jodah")
            }
        }
        maven("https://maven.fabricmc.net")
        maven("https://maven.parchmentmc.org")
        maven("https://maven.quiltmc.org/repository/release")
        maven("https://maven.architectury.dev/")
        maven("https://repo.essential.gg/repository/maven-public")
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