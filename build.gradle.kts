// build.gradle.kts
plugins {
    application // For runnable JVM applications
    kotlin("jvm") version "1.9.0" // Use your desired Kotlin version
}

group = "com"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral() // Where Gradle finds dependencies
}

dependencies {
    // Use the Kotlin test library.
    testImplementation(kotlin("test"))

    // Use the JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.0-M1")

    // Use the JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.0-M1")
}

// Define the main class for the application
application {
    mainClass.set("com.isp.MainKt") // Important: This needs to point to your main function
}

tasks.test {
    useJUnitPlatform()
}