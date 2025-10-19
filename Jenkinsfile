pipeline {
    agent any

    tools {
        maven 'Maven3' // Nom configuré dans Jenkins -> Global Tool Configuration
        jdk 'JDK17'    // Idem pour le JDK
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Récupération du code source...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Compilation du projet...'
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Test') {
            steps {
                echo 'Exécution des tests automatisés...'
                sh 'mvn test'
            }
        }

        stage('Report') {
            steps {
                echo 'Génération du rapport de test...'
                sh 'mvn surefire-report:report'
            }
        }
    }

    post {
        always {
            echo 'Pipeline terminé.'
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
