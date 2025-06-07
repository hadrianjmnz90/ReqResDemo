pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                    git branch: 'main',
                        url: 'https://github.com/hadrianjmnz90/ReqResDemo'
                }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}