pipeline{
    agent any
       stages{  
            stage("test"){
                steps{                   
                    script{
                        env.RERUN = 'TRUE'
                        catchError(buildResult:'SUCCESS',stageResult:'FAILURE'){
                        bat "python -m  robot.run  -d reports --splitlog  C:/Users/mp05/PycharmProjects/mohan/robot_test/"
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
                        script{
                            env.RERUN = 'FALSE'
                            }
                         }
                    }
                }
           stage("rerun"){
               when {environment name:'RERUN',value:'TRUE'}
               steps{
                    bat "python -m robot.run --rerunfailed output.xml -d results C:/Users/mp05/PycharmProjects/mohan/robot_test/"
                    }
           }
       }
}
