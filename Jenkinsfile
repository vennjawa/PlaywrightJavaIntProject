pipeline {

agent any

stages {

stage('Checkout') {
steps {
checkout scm
}
}

stage('Check Docker') {
steps {
bat 'docker --version'
bat 'docker info'
}
}

stage('Build Docker Image') {
steps {
bat 'docker build -t playwright-java:latest .'
}
}

stage('Run Tests in Docker') {
steps {
bat 'docker run --rm playwright-java:latest'
}
}
}

post {
always {

junit allowEmptyResults: true,
testResults: 'target/surefire-reports/*.xml'

archiveArtifacts artifacts: 'target/screenshots/**/*,target/videos/**/*,target/traces/**/*',
allowEmptyArchive: true
}
}
}
