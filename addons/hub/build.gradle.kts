repositories {
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        name = "bungeecord-repo"
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

dependencies {
    compileOnly(libs.velocity)
    compileOnly(libs.bungeecord)
}