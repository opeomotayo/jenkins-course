pipelineJob('pipeline-job-with-build-pod') {
    definition {
        description('')
        logRotator {
            numToKeep(10)
            daysToKeep(5)
        }
        properties {
            gitLabConnection {
                gitLabConnection('gitlab-creds')
            }
        }
        parameters {
            stringParam('BRANCH', 'master', 'Branch')
        }

        definitions {
            cpsScm {
                git {
                    extension {
                        wipeOutWorkspace()
                    }
                    remote {
                        url('ssh://git@gitlab.com:opeomotayo/helloworld-app.git')
                        credentials('jenkins')
                    }
                    branch("$BRANCH")
                }
            }
            scriptPath('Jenkinsfile')
        }
    }
}

