pipeline{
    agent any
    parameters{
        string(name:'env' , defaultValue:'simu', description:'')
    }
    stages{        
        stage('test'){
            steps{
                echo "${params.name}"
            }
        }
   }
}
