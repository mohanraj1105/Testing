pipeline{
    agent any
        stages{
            stage("test"){
                steps{
                    pybot "test.robot"
                     }
                post{
                    always{
                         robot "results"
                    }
                }

            }
       }
    }
