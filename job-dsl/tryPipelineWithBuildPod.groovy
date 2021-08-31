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
                        url('https://gitlab.com/opeomotayo/try-python-app.git')
                        credentials('gitlab-creds')
                    }
                    branch('main')
                }
            }

            scriptPath('Jenkinsfile')
        }
    }
}

