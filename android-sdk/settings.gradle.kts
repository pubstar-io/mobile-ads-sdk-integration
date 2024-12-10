pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }

        maven { url = uri("https://jitpack.io") }
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
        flatDir {
            dirs("libs")
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        flatDir {
            dirs("libs")
        }
        google()
        mavenLocal()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}


rootProject.name = "Android Mobile SDK"
include(":app")
