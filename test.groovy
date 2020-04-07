pipeline{
    agent any
        stages{
            stage("test"){
                steps{
                    script{
                        cd  "/Users/mp05/PycharmProjects/mohan"
                        pybot "test.robot"
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
