pipeline{
    agent any
       stages{  
            stage("test"){
                steps{                   
                    script{
                        catchError(buildResult:'SUCCESS',stageResult:'FAILURE'){
                        bat "python -m  robot.run  -d reports --splitlog  C:/Users/mp05/PycharmProjects/mohan/robot_test/"
                        env.RERUN = 'TRUE'
                        }
                        def num = BUILD_URL
                        def job = JOB_NAME
                        println(num)
                        println(currentBuild.previousBuild.result)
                        println(currentBuild.previousBuild.duration)
                        println(job)
                        if(currentBuild.previousBuild){
                            println(currentBuild.getPreviousBuild())                         
                        }
                         
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
                        steps{
                            env.RERUN = 'FALSE'
                            }
                         }
                    }
                }
           stage("rerun"){
               when {environment name:env.RERUN,value:'TRUE'}
               steps{
                    bat "python -m robot.run --rerunfailed output.xml -d results C:/Users/mp05/PycharmProjects/mohan/robot_test/"
                    }
           }
       }
}
