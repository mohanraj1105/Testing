pipeline{
    agent any
       stages{  
            stage("test"){
                steps{
                    bat "python -m  robot.run  -d reports --splitlog  C:/Users/mp05/PycharmProjects/mohan/robot_test/ "                    
                    script{
                        def num = CurrentBuild
                        def job = JOB_NAME
                        println(num)
                        println(CurrentBuild.PreviousBuild)
                        println(job)
                         
                    }
                }
                post{
                    always{
                        robot "reports"
                        bat "7z a -ttar -so dwt.tar reports/ | 7z a -si dwt.tar.gz"
           
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
