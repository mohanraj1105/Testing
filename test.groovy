pipeline{
    agent any
        stages{
            stage("test"){
                steps{
                    script{
                        pybot test.robot
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
