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
                        bat "7z -ttar a dummy reports -so | 7z -si -tgzip a x.tgz"
                         }
                    failure{
                        archiveArtifacts "**/*.png"
                        }
                    success{
                        archieveArtifacts "**/*.tar"
                        }
                    }
                }
            }
       
}
