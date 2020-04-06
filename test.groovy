pipeline{
    agent any
        stages{
            stage("test"){
                steps{
                        echo "hello world"
                     }
                post{
                    always{
                        robot 'results'
                    }
                }

            }
       }
    }
