pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        maven(url = "https://jitpack.io") // JitPack repository'si buraya ekleniyor
        mavenCentral()
    }
}

rootProject.name = "WeatherApp"
include(":app")
 