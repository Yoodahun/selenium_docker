pipeline {
    agent any

    stages {
        stage('Building') {
            steps {
                echo 'Building the dev project'
            }
        }
        stage('Testing') {
            steps {
                checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Yoodahun/selenium_docker.git']]]
                sh 'mvn clean test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying the code on Staging server'
            }
        }

    }
}
