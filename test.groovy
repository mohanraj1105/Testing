pipeline{
    agent any
        stages{
            stage("test"){
                steps{
                    script{
                       sh "python3 -m robot.run --outputdir results   ../../pycharmprojects/mohan/test.robot"
                        }
                     }
                post{
                    always{
                         robot "results"
                    }
                }

            }
       }
    }
