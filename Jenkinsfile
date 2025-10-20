pipeline {
    agent any // Utilise n'importe quel agent disponible pour exécuter le pipeline

    // Déclenchement automatique
    triggers {
        cron('H 10 * * *') // Exemple : exécuter chaque jour à 16h (H = random hash)
    }

    environment {
        // Définir le JAVA_HOME si besoin
        JAVA_HOME = 'C:\Program Files\Java\jdk-17'
        // Définir le MAVEN_HOME si tu utilises Maven
        MAVEN_HOME = 'C:\Users\user\Desktop\FormationSelenuim\apache-maven-3.9.11-bin\apache-maven-3.9.11'
PATH = "${JAVA_HOME}\\bin;${MAVEN_HOME}\\bin;${env.PATH}"
    }

    stages {
        // Étape 1 : Récupérer le code depuis GitHub
        stage('Checkout') {
            steps {
                git branch: 'master', 
                    url: 'https://github.com/rahma-louati/projet-saucelabs.git', 
                    credentialsId: 'github-token' // ID du credential créé dans Jenkins
            }
        }

        // Étape 2 : Compiler / construire le projet
        stage('Build') {
            steps {
                echo 'Building the project...'
                bat 'mvn clean compile' // ou 'mvn clean install' selon ton besoin
            }
        }

        // Étape 3 : Lancer les tests automatisés
        stage('Run Tests') {
            steps {
                echo 'Running tests...'
                bat 'mvn test'
            }
        }

        // Étape 4 : Publier les rapports (exemple pour Cucumber)
        stage('Publish Reports') {
            steps {
                echo 'Publishing Cucumber report...'
                // Si tu utilises le plugin cucumber-reporting
                cucumber buildStatus: 'UNSTABLE', fileIncludePattern: 'target/report/cucumber.json'
            }
        }
    }

    post {
        always {
            echo 'Cleaning workspace...' // Toujours nettoyer après exécution
        }
        success {
            echo 'Tests passed!' // Message si tout réussit
        }
        failure {
            echo 'Tests failed!' // Message si échec
        }
    }
}