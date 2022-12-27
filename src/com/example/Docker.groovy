#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

    def script

    // Script holds all the infomration for all the environemnt variables and pipeline methods and commands.
    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "Building the docekr image..."
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        }
    }

    def dockerPuhs(String imageName) {
        script.sh "docker push $imageName"
    }
}
