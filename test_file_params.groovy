def triggering = "H/4 * * * *"
pipeline{
    agent any
    parameters{
        string(name:'env' , defaultValue:'simu', description:'')
       }
    environment{
        path = "C:/Program Files/Docker Toolbox"
    triggers{
        cron(triggering)
    }
    stages{        
        stage('test'){
            steps{
                echo "${params.env.toUpperCase()}"
                script{
                    def docker_image = docker.build("image_id:${env.BUILD_ID}")
                    docker_image.inside('-v ${path}:/image_id'){
                        sh 'ls -la'
                    }
                }
                }
        }
   }
}
