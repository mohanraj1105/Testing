pipeline{
    agent any{
       stages{
            stage("test"){
                step{
                    bat "C:\Users\mp05\PycharmProjects\mohan"
                    bat "pybot test.robot"                    
                    }
                post{
                    always{
                        archiveArtifacts  artifacts:  "**/*.xml",fingerprint: true
                    }
                }

            }
       }
    }
}
