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
                        println(currentBuild.previousBuild.result)
                        println(currentBuild.previousBuild.duration)
                        if(currentBuild.previousBuild){
                            println(currentBuild.previousBuild())
                        }
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
                    }
                }
            }
       
}
