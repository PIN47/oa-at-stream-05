import org.gradle.api.tasks.testing.Test


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
    // Source: https://mvnrepository.com/artifact/org.assertj/assertj-core
    testImplementation("org.assertj:assertj-core:3.27.7")
}

tasks.test {
    useJUnitPlatform()
}


tasks.register<Test>("startTest_Task_1"){
    group = "MyTasks"
    println("Task is started!")
    useJUnitPlatform {
        include("TestMain.class")
    }
}

tasks.register<Test>("endTest_Task_1"){
    group = "MyTasks"
    doLast {
        println("Test run is over")
    }

}

tasks.named("startTest_Task_1"){
    finalizedBy("endTest_Task_1")
}


tasks.register<Test>("startTest_Task_2"){
    group = "MyTasks"
    println("Task is started!")
    useJUnitPlatform {
        include("AllTests.class")
    }
}

tasks.register<Test>("startTest_Task_TAG_TestThree"){
    group = "MyTasks"
    println("Task is started!")
    useJUnitPlatform {
        includeTags("Smoke")
    }
}