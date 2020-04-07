pipeline{
    agent any
        stages{
            stage("test"){
                steps{
                    script{
                        cd  "/Users/mp05/PycharmProjects/mohan"
                        python3 -m robot --outputdir results
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
