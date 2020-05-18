pipeline{
    agent any
       stages{  
            stage("test"){
                steps{
                    bat "python -m  robot.run  -d reports --splitlog  C:/Users/mp05/PycharmProjects/mohan/robot_test/ "                    
                    script{
                        def num = BUILD_URL
                        def job = JOB_NAME
                        println(num)
                        println(currentBuild.previousBuild)
                        println(job)
                         
                    }
                }
                post{
                    always{
                        robot "reports"  
                        }
                    failure{
                        archiveArtifacts "**/*.png"
                        }
                    success{
                        archiveArtifacts "*.tar.gz"
                       }
                   
                    }
                }
            }
       
}
