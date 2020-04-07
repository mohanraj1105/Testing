pipeline{
    agent any
        stages{
            stage("test"){
                steps{
                    sh "../../PycharmProjects/mohan"
                    script{
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
