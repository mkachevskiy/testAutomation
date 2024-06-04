plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:4.21.0")
    implementation("commons-io:commons-io:2.16.1")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.2")
    testImplementation("io.qameta.allure:allure-junit5:2.27.0")

    testRuntimeOnly("org.slf4j:slf4j-simple:2.0.13")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}