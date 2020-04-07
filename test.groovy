pipeline{
    agent any
        stages{
            stage("test"){
                steps{
                    script{
                       sh "python3 -m --outputdir results  Testing/"
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
