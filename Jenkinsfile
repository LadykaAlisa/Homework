pipeline {
    agent any

    tools {
        maven 'maven3911'
        jdk 'jdk-17'
    }

    environment {
        DRIVER_NAME = 'chrome'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/LadykaAlisa/Homework.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat '''
                    mvn clean test ^
                    -Ddriver.name=%DRIVER_NAME%
                '''
            }
        }
    }

    post {
        always {
            script {
                echo 'Publishing Allure report...'
                allure([
                    includeProperties: false,
                    tool: 'allure2531',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }

        success {
            echo 'BUILD SUCCESS 🎉'
        }

        failure {
            echo 'BUILD FAILED ❌'
        }
    }
}
