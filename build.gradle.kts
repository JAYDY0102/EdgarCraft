plugins {
    kotlin("jvm") version "1.9.21"
    id("io.github.goooler.shadow") version "8.1.7"
}

group = "org.jaydy0102"
version = "1.3.0"

allprojects {
    apply(plugin = "java")
    apply(plugin = "kotlin")
    apply(plugin = "maven-publish")
    apply(plugin = "io.github.goooler.shadow")

    repositories {
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://repo.dmulloy2.net/nexus/repository/public/")
        maven("https://repo.codemc.io/repository/maven-snapshots/")
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
        maven("https://repo.codemc.io/repository/maven-snapshots/"){
        }
    }
    dependencies {
        compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
        implementation("com.comphenix.protocol:ProtocolLib:5.3.0")
        implementation("net.wesjd:anvilgui:1.10.4-SNAPSHOT")
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    }

    tasks {
        shadowJar {
            relocate("io.github.jaydy0102", "io.github.jaydy0102")
        }

        compileKotlin {
            kotlinOptions {
                jvmTarget = "21"
            }
        }
        compileJava {
            options.isDeprecation = true
            options.encoding = "UTF-8"

            dependsOn(clean)
        }
        processResources {
            filesMatching(listOf("**plugin.yml", "**eco.yml")) {
                expand(
                    "version" to project.version,
                    "pluginName" to rootProject.name
                )
            }
        }
        build {
            dependsOn(shadowJar)
        }
    }
}
