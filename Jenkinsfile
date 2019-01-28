pipeline {
  agent {
    kubernetes {
      label 'mypod'
      defaultContainer 'jnlp'
      yaml """
apiVersion: v1
kind: Pod
metadata:
  labels:
    some-label: some-label-value
spec:
  containers:
  - name: maven
    image: maven:3.6-jdk-8-alpine
    command:
    - cat
    tty: true
  - name: docker
    image: docker:stable
    command:
    - cat
    tty: true
    volumeMounts:
    - name: dockersock
      mountPath: /var/run/docker.sock
  - name: helm
    image: lachlanevenson/k8s-helm:v2.12.3
    command:
    - cat
    tty: true

  volumes:
  - name: dockersock
    hostPath:
      path: /var/run/docker.sock
"""
    }
  }

  environment {
    //Use Pipeline Utility Steps plugin to read information from pom.xml into env variables
    IMAGE = readMavenPom().getArtifactId()
    VERSION = readMavenPom().getVersion()
  }

  stages {
    stage('Build') {
      steps {
        container('maven') {
          sh 'mvn clean package'
        }
      }
    }
    stage('Docker image') {
      steps {
        container('docker') {
          sh 'docker build -t ${IMAGE}:${VERSION} .'
          sh ' echo "docker login" '
          sh ' echo "docker push ${IMAGE}:${VERSION}" '
        }
      }
    }
    stage('Deplopy to K8s') {
      steps {
        container('helm') {
          sh 'helm version'
          sh ' echo "helm xxxxxxx" '
        }
      }
    }
  }
}