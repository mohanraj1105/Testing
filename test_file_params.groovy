pipeline{
    agent any
    parameters{
        string(name:'env' , defaultValue:'simu', description:'')
    }
    stages{        
        stage('test'){
            step{
                echo "${params.name}"
            }
        }
   }
}
