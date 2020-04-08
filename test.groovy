pipeline{
    agent any
       stages{
            stage("test"){
                steps{
                    bat "cd C:/Users/mp05/PycharmProjects/mohan"
                    bat "pybot test.robot"                    
                    }
                post{
                    always{
                        robot "results"
                    }
                }
            }
       }
}
