pipeline{
    agent any
       stages{  
            stage("test"){
                steps{                   
                    script{
                        def num = BUILD_URL
                        def job = JOB_NAME
                        println(num)
                        println(currentBuild.previousBuild.result)
                        println(currentBuild.previousBuild.duration)
                        if(currentBuild.previousBuild){
                            println(currentBuild.getPreviousBuild())                         
                        }
                        catchError(buildResult:'SUCCESS',stageResult:'FAILURE')
                        bat "python -m  robot.run  -d reports --splitlog  C:/Users/mp05/PycharmProjects/mohan/robot_test/"
                        env.RERUN = 'N/A'
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
           stage("rerun"){
                    when{
                        expression{env.RERUN == 'True'}
                    }
               steps{
                    bat "python -m robot.run --rerunfailed output.xml -d results C:/Users/mp05/PycharmProjects/mohan/robot_test/"
                    }
           }
       }
}
