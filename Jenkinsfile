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
        // and inside that config file it is configured that iam authenticator needs to be used in order to authenticate with the linode account
        // and when aws iam authenticator command get triggered in the background as a result it needs credentials to connect with the linode account
        // so those two will be used (access key and secret access key) to authenticate that are set in env variable(Jenkinsfile10).
        // kubeconfig.yaml file provided inside the jenkins container so that kubectl knows that where to connect the server, on which url it find the cluster.
        // then it deploy the image on the k8s lke cluster that are defined inside the kubeconfig file. 
        stage('deploy') {
            steps {
                script {
                   echo 'deploying docker image...'
                   withKubeConfig([credentialsId: 'lke-credentials', serverUrl: 'https://79fa9228-1d11-47ec-870b-33106d53122b.eu-central-2.linodelke.net']) {
                       sh 'kubectl create deployment nginx-deployment --image=nginx'
                   }
                }
            }
        }
    }
}
