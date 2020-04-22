def triggering = "H/4 * * * *"
pipeline{
    agent any
    parameters{
        string(name:'env' , defaultValue:'simu', description:'')
       }
    triggers{
        cron(triggering)
    }
    stages{        
        stage('test'){
            steps{
                echo "${params.env.toUppperCase()}"
            }
        }
   }
}
