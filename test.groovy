pipeline{
    agent any
       stages{
            stage("test"){
                steps{
                    bat "python -m  robot.run --outputdir reports --splitlog  C:/Users/mp05/PycharmProjects/mohan/robot_test/ "                    
                    }
                post{
                    always{
                        copyArtifact "**/*.js"
                        robot "reports"
                         }
                    failue{
                        archiveArtifacts "**/*.png"
                        }
                    }
                }
            }
       }
}
