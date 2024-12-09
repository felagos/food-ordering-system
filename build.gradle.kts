plugins {
    id("org.springframework.boot") version "3.4.0" apply false
    id("io.spring.dependency-management") version "1.1.6" apply false
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    group = "com.flagos"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    dependencies {
        configurations["implementation"]("org.springframework.boot:spring-boot-starter-web")
        configurations["compileOnly"]("org.projectlombok:lombok")
        configurations["annotationProcessor"]("org.projectlombok:lombok")
        configurations["testImplementation"]("org.springframework.boot:spring-boot-starter-test")
        configurations["testRuntimeOnly"]("org.junit.platform:junit-platform-launcher")
    }

    configure<JavaPluginExtension> {
        toolchain {
            languageVersion = JavaLanguageVersion.of(22)
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
