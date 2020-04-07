pipeline{
    agent any
        stages{
            stage("test"){
                steps{
                    script{
                        def val=pwd()
                        println(val)
                     }
                post{
                    always{
                         robot "results"
                    }
                }

            }
       }
    }
