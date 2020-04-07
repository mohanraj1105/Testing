pipeline{
    agent any
        stages{
            stage("test"){
                steps{
                    script{
                        cd "C:\Users\mp05\PycharmProjects\mohan"
                        sh "pybot test.robot"
                     }
                post{
                    always{
                         robot "results"
                    }
                }

            }
       }
    }
