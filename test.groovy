pipeline{
    agent any
        stages{
            stage("test"){
                step{
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
}
