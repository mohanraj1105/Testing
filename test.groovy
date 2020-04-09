pipeline{
    agent any
       stages{
            stage("test"){
                steps{
                    bat "python -m  robot.run --outputdir reports --splitlog  C:/Users/mp05/PycharmProjects/mohan/robot_test/ "                    
                    script{
                        def num = env.BUILD_NUMBER
                        println(num)
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
