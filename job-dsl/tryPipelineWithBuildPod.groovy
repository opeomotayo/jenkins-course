pipelineJob('pipeline-job-with-buildpod') {
    description('Pipeline job with buildpod')
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

    definition {
        cpsScm {
            scm {
                git {
                    extensions {
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

