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
}

tasks.test {
    useJUnitPlatform()
}


tasks.register<Test>("startTest"){
    group = "singleTest";
    println("Task is started!")
    useJUnitPlatform(){
        include("TestMain.class")
    };
}

tasks.register<Test>("endTest"){
    group = "singleTest";
    doLast {
        println("Test run is over");
    }

}

tasks.named("startTest"){
    finalizedBy("endTest")
};
