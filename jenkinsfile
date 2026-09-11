pipeline {
    agent {
        node {
            label 'Java-project'
        }
    }
    tools {
        maven "mymaven"
    }

    stages {
        stage('Code') {
            steps {
                git branch: 'main', credentialsId: 'GitHub-creds', url: 'https://github.com/Shiva3579/jenkins.git'
            }
        }
        stage('Build and Test') {
            steps {
               sh ("mvn clean install") 
            }
        }
        stage('Artifacts') {
            steps {
              nexusArtifactUploader artifacts: [[artifactId: 'myweb', classifier: '', file: 'target/myweb.war', type: 'war']], credentialsId: 'Nexus', groupId: 'in.javahome', nexusUrl: '54.86.77.96:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'java-project', version: '8.8.5'  
            }
        }
        stage('Deploy') {
            steps {
                deploy adapters: [tomcat9(alternativeDeploymentContext: '', credentialsId: 'tomcat-deploy', path: '', url: 'http://32.198.9.173:8080/')], contextPath: 'e-comm', war: 'target/*.war'
            }
        }
    }
}
