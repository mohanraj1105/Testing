pipeline{
    agent any
        stages{
            stage("test"){
                steps{
                    script{
                        sh "Testing"
                        sh "pybot test.rpbot"
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
