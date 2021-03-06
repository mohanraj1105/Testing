pipeline{
    agent any
       stages{  
            stage("test"){
                steps{
                    script{
                        env.RERUN = 'TRUE'
                        catchError(buildResult:'SUCCESS',stageResult:'FAILURE'){
                        bat "python -m  robot.run  -d reports --splitlog --output output_1.xml --log log_1.html --report report_1.html C:/Users/mp05/PycharmProjects/mohan/robot_test/"
                         }
                        def file = readFile './hello.txt'
                        println(file)
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
                        robot outputPath : 'reports',
                              logFileName : 'log_1.html',
                              outputFileName : 'output_1.xml',
                              reportFileName : 'report_1.html'
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
                   bat "python -m robot.run --rerunfailed reports/output_1.xml --output output_2.xml --log log_2.html --report report_2.html -d reports C:/Users/mp05/PycharmProjects/mohan/robot_test/"
                   bat "python -m robot.rebot --merge reports/output_1.xml reports/output_2.xml"
                    }
               post{
                  always{
                      robot outputPath : 'reports',
                            logFileName : 'log_2.html',
                            outputFileName : 'output_2.xml',
                            reportFileName : 'report_2.html'
                  }
               }
           }
       }
}
