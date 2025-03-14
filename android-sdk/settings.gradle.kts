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
        gradlePluginPortal()
        mavenLocal()
        maven { url = uri("https://artifactory.appodeal.com/appodeal") }
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
        mavenCentral()
        mavenLocal()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://artifactory.appodeal.com/appodeal") }
    }
}


rootProject.name = "Android Mobile SDK"
include(":app")
