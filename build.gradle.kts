import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("maven-publish")
	id("eclipse")
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
}

group = "io.fynarfin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	maven {
		url = uri("https://repo.maven.apache.org/maven2")
	}
	maven {
		url = uri("https://fynarfin.jfrog.io/artifactory/fyn-libs-snapshot-local/")
	}
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation ("org.springframework.boot:spring-boot-starter-web:2.6.2")
	implementation ("org.springframework.boot:spring-boot-starter-actuator:2.6.2")
	implementation ("org.apache.camel:camel-endpointdsl:3.12.0")
	implementation ("org.apache.camel:camel-jetty:3.12.0")
	implementation ("org.apache.camel:camel-undertow:3.12.0")
	implementation ("org.apache.camel:camel-http:3.12.0")
	implementation ("org.apache.camel.springboot:camel-jackson-starter:3.12.0")
	implementation ("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.1")
	implementation ("org.json:json:20211205")
	implementation ("io.camunda:zeebe-client-java:1.3.1")
	implementation ("com.auth0:java-jwt:3.18.3")
	implementation ("org.mifos:ph-ee-connector-common:1.0.0-SNAPSHOT")
	testImplementation ("org.springframework.boot:spring-boot-starter-test")
	testImplementation ("io.projectreactor:reactor-test")
	testImplementation ("org.springframework.boot:spring-boot-starter-test:2.6.2")
	testImplementation ("org.junit.jupiter:junit-jupiter-api:5.8.2")
	testImplementation ("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
