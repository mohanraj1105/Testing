pipeline{
    agent any
       stages{
            stage("test"){
                steps{
                    bat "C:/Users/mp05/PycharmProjects/mohan"
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
