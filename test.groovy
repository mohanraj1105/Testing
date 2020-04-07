pipeline{
    agent any
        stages{
            stage("test"){
                steps{
                    script{
                        sh "pybot test.robot"
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
