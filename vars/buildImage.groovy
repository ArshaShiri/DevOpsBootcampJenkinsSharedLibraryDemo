#!/usr/bin/env groovy

import com.example.Docker

def call(String imageName) {
    new Dokcer(this).buildDockerImage(imageName)
}
