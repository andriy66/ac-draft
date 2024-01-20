plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.testng:testng:7.5.1")
    testImplementation("org.assertj:assertj-core:3.24.2")
    implementation("com.codeborne:selenide:6.13.1")
    implementation("io.rest-assured:rest-assured:4.5.1")
    implementation("io.github.bonigarcia:webdrivermanager:5.5.3")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.12.5")

}

tasks.test {
    useTestNG() {
        if(project.properties.contains("suite")) {
            var param: String = "";
            val suiteName = project.properties.get("suite")
            if(suiteName=="merge") {
                param += "src/test/resources/suites/merge_suite.xml";
            }
            suites(param)
        }

        useDefaultListeners = true
    }
}