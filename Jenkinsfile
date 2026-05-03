pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build App') {
            steps {
                sh '''
                chmod +x mvnw
                ./mvnw clean package
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