#!/usr/bin/env groovy
@Library('jenkins-shared-library')

def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script3.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    // gv.buildJar()
                    buildJar()
                }
            }
        }
        stage("build and push image") {
            steps {
                script {
                    echo "building and pushing image"
                    // gv.buildImage()
                    // buildImage()
                    buildImage 'piyush168713/demo-app:jma-2.7'
                    dockerLogin()
                    dockerPush 'piyush168713/demo-app:jma-2.7'
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying"
                    gv.deployApp()
                }
            }
        }
    }   
}
