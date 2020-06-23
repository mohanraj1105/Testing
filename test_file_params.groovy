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
                echo "${params.env.toUpperCase()}"
                script{
                    def docker_image = docker.build("image_id:${env.BUILD_ID}")
                    docker_image.inside('C:/Program Files/Docker Toolbox'){
                        sh 'ls -la'
                    }
                }
                }
        }
   }
}
