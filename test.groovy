pipeline{
    agent any
        stages{
            stage("test"){
                steps{
                        echo "hello world"
                     }
                post{
                    always{
                         archiveArtifacts artifacts: 'results/**/*.jar', fingerprint: true
                    }
                }

            }
       }
    }
