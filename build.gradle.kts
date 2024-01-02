plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.24.2")
    implementation("com.codeborne:selenide:6.19.1")
    implementation("io.rest-assured:rest-assured:4.5.1")
    implementation("io.github.bonigarcia:webdrivermanager:5.5.3")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.12.5")

}

tasks.test {
    useJUnitPlatform()
}