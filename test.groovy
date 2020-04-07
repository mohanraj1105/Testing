pipeline{
    agent any
        stages{
            stage("test"){
                steps{
                    script{
                        sh "C:\Users\mp05\PycharmProjects\mohan"
                        def val=pwd()
                        println(val)
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
