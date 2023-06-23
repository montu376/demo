pipeline{
    agent any
    
    stages{
        stage('Building Image and dockerzing it'){
            agent {
                label 'docker-ubuntu'
            }
            steps {
                sh 'mvn package'
                sh 'docker build -t montud/demo:latest .'
            }

            post{
                success{
                    archiveArtifacts artifacts: 'target/*.jar'
                    
                }        
            }
        } 

        stage('docker push'){
            agent {
                label 'docker-ubuntu'
            }
            steps {
                sh 'docker push montud/demo:latest'
            }
        }


        stage('Kubernates deploy'){
            steps {
                bat 'C:\\Users\\coolm\\kubectl.exe apply -f deploy.ydml'
            }
        }
    }
    


}