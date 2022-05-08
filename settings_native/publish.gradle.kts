apply(plugin = "maven-publish")
apply(plugin = "signing")

group = "io.pressf.settings-native"
version = "1.6.0"

afterEvaluate {
    configure<PublishingExtension> {
        publications {
            forEach {
                (it as? MavenPublication)?.pom {
                    name.set("settings-native")
                    description.set("KMM implementation of user settings API")
                    url.set("https://github.com/pressfio/settings-native")
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    developers {
                        developer {
                            id.set(findProperty("NEXUS_USERNAME") as? String)
                            name.set("Petr Grigorev")
                            email.set("grigoryev.pete@gmail.com")
                        }
                    }
                    scm {
                        connection.set("https://github.com/pressfio/settings-native.git")
                        developerConnection.set("git@github.com:pressfio/settings-native.git")
                        url.set("https://github.com/pressfio/settings-native")
                    }
                }
            }
        }

        repositories {
            maven {
                url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
                credentials {
                    username = findProperty("NEXUS_USERNAME") as? String
                    password = findProperty("NEXUS_PASSWORD") as? String
                }
            }
        }
    }

    configure<org.gradle.plugins.signing.SigningExtension> {
        configure<PublishingExtension> {
            sign(this.publications)
        }
    }
}