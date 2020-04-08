pipeline{
    agent any
       stages{
            stage("test"){
                steps{
                    bat "python3 -m robot.run C:/Users/mp05/PycharmProjects/mohan/test.robot "                    
                    }
                post{
                    always{
                        robot "results"
                    }
                }
            }
       }
}
