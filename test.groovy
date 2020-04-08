pipeline{
    agent any
       stages{
            stage("test"){
                steps{
                    bat "python -m  --outputdir results/*.xml robot.run C:/Users/mp05/PycharmProjects/mohan/robot_test/test.robot "                    
                    }
                post{
                    always{
                        robot "results"
                    }
                }
            }
       }
}
