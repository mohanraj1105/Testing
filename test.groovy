pipeline{
    agent any
       stages{  
            stage("test"){
                steps{
                    bat "python -m  robot.run --outputdir reports --splitlog  C:/Users/mp05/PycharmProjects/mohan/robot_test/ "                    
                    script{
                        def num = BUILD_NUMBER
                        def job = JOB_NAME
                        println(num)
                        println(job)
                    }
                }
                post{
                    always{
                        robot "reports"
                        copyArtifacts   projectName:"${JOB_NAME}",
                                        target: "test_1",
                                        selector:lastSuccessful(),
                                        flatten:true,
                                        filter:"results/*.xml"
                         }
                    failure{
                        archiveArtifacts "**/*.png"
                        }
                    }
                }
            }
       
}
