#!/usr/bin/env groovy

def call(String imageName) {
    echo "Building the docekr image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t arshashiri/demo-app:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push arshashiri/demo-app:jma-2.0'
    }
}
