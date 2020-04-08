pipeline{
    agent any
       stages{
            stage("test"){
                steps{
                    bat "python -m  robot.run --outputdir results/test/  C:/Users/mp05/PycharmProjects/mohan/robot_test/test.robot "                    
                    }
                post{
                    always{
                        robot "results"
                    }
                }
            }
       }
}
