pipeline{
    agent any
       stages{
            stage("test"){
                steps{
                    bat "python -m  robot.run --outputdir reports  C:/Users/mp05/PycharmProjects/mohan/robot_test/ "                    
                    }
                post{
                    always{
                        robot "reports"
                    }
                }
            }
       }
}
