pipeline{
    agent any
        stages{
            stage("test"){
                steps{
                    scripts{
                        echo "hello world"
                     }
                }
                post{
                    always{
                        archiveArtifacts  artifacts: "**/*.xml",fingerprint: true
                    }
                }

            }
       }
    }
