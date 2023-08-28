#!/usr/bin/env groovy

pipeline {
    agent any
    stages {
        stage('build app') {
            steps {
               script {
                   echo "building the application..."
               }
            }
        }
        stage('build image') {
            steps {
                script {
                    echo "building the docker image..."
                }
            }
        }

        // kubectl command executes which will use the config file that we created at default location, i.e. kubeconfig.yaml file. 
        // and inside that config file it is configured that iam authenticator needs to be used in order to authenticate with the AWS account
        // and when aws iam authenticator command get triggered in the background as a result it needs credentials to connect with the AWS account
        // so those two will be used (access key and secret access key) to authenticate that are set in env variable(Jenkinsfile10).
        // kubeconfig.yaml file provided inside the jenkins container so that kubectl knows that where to connect the server, on which url it find the cluster.
        // then it deploy the image on the k8s eks cluster that are defined inside the kubeconfig file. 
        stage('deploy') {
            environment {
               AWS_ACCESS_KEY_ID = credentials('jenkins_aws_access_key_id')
               AWS_SECRET_ACCESS_KEY = credentials('jenkins_aws_secret_access_key')
            }
            steps {
                script {
                   echo 'deploying docker image...'
                   sh 'kubectl create deployment nginx-deployment --image=nginx'
                }
            }
        }
    }
}
