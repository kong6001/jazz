/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

plugins {
	java
	`java-library`
	`maven-publish`
	id("com.github.ben-manes.versions") version "0.39.0"
	idea
}

group = "com.elex-project"
version = "2.15.0"
description = "Jazz is a GUI Library for Swing!"

repositories {
	maven {
		url = uri("https://repository.elex-project.com/repository/maven")
	}
}

java {
	withSourcesJar()
	withJavadocJar()
	sourceCompatibility = org.gradle.api.JavaVersion.VERSION_11
	targetCompatibility = org.gradle.api.JavaVersion.VERSION_11
}

configurations {
	compileOnly {
		extendsFrom(annotationProcessor.get())
	}
	testCompileOnly {
		extendsFrom(testAnnotationProcessor.get())
	}
}

tasks.jar {
	manifest {
		attributes(mapOf(
				"Implementation-Title" to project.name,
				"Implementation-Version" to project.version,
				"Implementation-Vendor" to "ELEX co.,pte.",
				"Automatic-Module-Name" to "com.elex_project.jazz"
		))
	}
}

tasks.compileJava {
	options.encoding = "UTF-8"
}

tasks.compileTestJava {
	options.encoding = "UTF-8"
}

tasks.test {
	useJUnitPlatform()
}

tasks.javadoc {
	if (JavaVersion.current().isJava9Compatible) {
		(options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
	}
	(options as StandardJavadocDocletOptions).encoding = "UTF-8"
	(options as StandardJavadocDocletOptions).charSet = "UTF-8"
	(options as StandardJavadocDocletOptions).docEncoding = "UTF-8"

}

publishing {
	publications {
		create<MavenPublication>("mavenJava") {
			from(components["java"])
			pom {
				name.set("Jazz!")
				description.set(project.description)
				url.set("https://github.com/elex-project/jazz")
				inceptionYear.set("2021")
				organization {
					name.set("Elex co.,Pte.")
					url.set("https://www.elex-project.com/")
				}
				licenses {
					license {
						name.set("Apache-2.0 License")
						url.set("https://github.com/elex-project/jazz/blob/main/LICENSE")
					}
				}
				developers {
					developer {
						id.set("elex-project")
						name.set("Elex")
						url.set("https://www.elex.pe.kr/")
						email.set("developer@elex-project.com")
						organization.set("Elex Co.,Pte.")
						organizationUrl.set("https://www.elex-project.com/")
						roles.set(arrayListOf("Developer", "CEO"))
						timezone.set("Asia/Seoul")
					}
				}
				scm {
					connection.set("scm:git:https://github.com/elex-project/jazz.git")
					developerConnection.set("scm:git:https://github.com/elex-project/jazz.git")
					url.set("https://github.com/elex-project/sphinx")
				}
			}
		}
	}

	repositories {
		maven {
			name = "mavenElex"
			val urlRelease = uri("https://repository.elex-project.com/repository/maven-releases")
			val urlSnapshot = uri("https://repository.elex-project.com/repository/maven-snapshots")
			url = if (version.toString().endsWith("SNAPSHOT")) urlSnapshot else urlRelease
			// Repository credential, Must be defined in ~/.gradle/gradle.properties
			credentials {
				username = project.findProperty("repo.username") as String
				password = project.findProperty("repo.password") as String
			}
		}
		maven {
			name = "mavenGithub"
			url = uri("https://maven.pkg.github.com/elex-project/jazz")
			credentials {
				username = project.findProperty("github.username") as String
				password = project.findProperty("github.token") as String
			}
		}
	}
}

dependencies {
	implementation("org.slf4j:slf4j-api:1.7.32")
	implementation("org.jetbrains:annotations:22.0.0")

	implementation("com.elex-project:abraxas:4.8.2")
	implementation("com.elex-project:dwarf:2.1.0")

	compileOnly("org.projectlombok:lombok:1.18.20")
	annotationProcessor("org.projectlombok:lombok:1.18.20")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.20")

	implementation("com.fasterxml.jackson.core:jackson-databind:2.12.4")
	implementation("com.fasterxml.jackson.core:jackson-annotations:2.12.4")

	// https://mvnrepository.com/artifact/com.fifesoft/rsyntaxtextarea
	testImplementation("com.fifesoft:rsyntaxtextarea:3.1.3")

	testImplementation("ch.qos.logback:logback-classic:1.2.5")
	testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
}
