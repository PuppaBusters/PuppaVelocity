
plugins {
    `java-library`
}

subprojects {
    apply<JavaLibraryPlugin>()
    //apply(plugin = "velocity-checkstyle")
    //apply<VelocityCheckstylePlugin>()
    //apply<VelocityPublishPlugin>()

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(25))
        }
    }

    //repositories {
        //mavenCentral()
        //maven("https://s01.oss.sonatype.org/content/repositories/snapshots/") // adventure
        //maven("https://repo.papermc.io/repository/maven-public/")
    //}

    dependencies {
        testImplementation(rootProject.libs.junit)
    }

    testing.suites.named<JvmTestSuite>("test") {
        useJUnitJupiter()
        targets.all {
            testTask.configure {
                reports.junitXml.required = true
            }
        }
    }
}
