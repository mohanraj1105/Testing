pipeline{
    agent any
    environment{
        artifactory_link = "https://artifactory.rd.konenet.com/"
        credential = credentials(Artifactory_ID)
    }
    stages{
        stage('artifactory download'){
            steps{
                script{
                    def server = Artifactory.newServer url:${artifactory_link} credentialsId=${credential}
                }
            }
        }
    }
}
