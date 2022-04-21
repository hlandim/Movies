pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("de.fayard.refreshVersions") version "0.40.1"
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    // See https://jmfayard.github.io/refreshVersions
    id("de.fayard.refreshVersions")
}

refreshVersions {
    enableBuildSrcLibs()
}

rootProject.name = "Movies"
include(
    ":app", ":central",
    ":features:movies-list",
    ":common:view",
    ":common:ui",
    ":common:test-view",
)
