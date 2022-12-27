#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

    def script

    // Script holds all the infomration for all the environemnt variables and pipeline methods and commands.
    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "building the docker image..."
        script.sh "docker build -t $imageName ."

    script.echo "Building the docekr image..."
    script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        script.sh "docker build -t $imageName ."
        script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        script.sh "docker push $imageName"
    }
    }
}
