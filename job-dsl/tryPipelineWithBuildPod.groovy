pipelineJob('pipeline-job-with-buildpod') {
    description('pipeline-job-with-buildpod')
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

