pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build App (Maven inside Docker)') {
            steps {
                sh '''
                docker run --rm \
                -v $(pwd):/app \
                -w /app \
                maven:3.9.9-eclipse-temurin-17 \
                mvn clean package
                '''
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t cicd-app:${BUILD_NUMBER} .'
            }
        }

        stage('Run Container') {
            steps {
                sh '''
                docker rm -f cicd-app-container || true
                docker run -d -p 8080:8080 --name cicd-app-container cicd-app:${BUILD_NUMBER}
                '''
            }
        }
    }
}