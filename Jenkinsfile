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
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t cicd-app:${BUILD_NUMBER} .'
            }
        }

        stage('Run Container (replace old)') {
            steps {
                sh '''
                docker rm -f cicd-app-container || true
                docker run -d --name cicd-app-container -p 8080:8080 cicd-app:${BUILD_NUMBER}
                '''
            }
        }
    }
}
