#!/usr/bin/env groovy

import com.example.Docker

def call(String imageName) {
    new Docker(this).buildDockerImage(imageName)
}
