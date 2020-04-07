pipeline{
    agent any
        stages{
            stage("test"){
                steps{
                    script{
                        sh "../../PycharmProjects/mohan"
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
