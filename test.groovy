pipeline{
    agent any
        stages{
            stage("test"){
                steps{
                    script{
                        cd  "/Users/mp05/PycharmProjects/mohan"
                        python3 -m robot.run --outputdir results   /test.robot
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
