pipelineJob('job-dsl-plugin') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/jenkinsci/job-dsl-plugin.git')
                    }
                    branch('*/master')
                }
            }
            lightweight()
        }
    }
}
//pipelineJob('pipeline-job-with-buildpod') {
//    description('Pipeline job with buildpod')
//    logRotator {
//        numToKeep(10)
//        daysToKeep(5)
//    }
//    properties {
//        gitLabConnection {
//            gitLabConnection('gitlab-creds')
//        }
//    }
//    parameters {
//        stringParam('BRANCH', 'master', 'Branch')
//    }
//
//    definition {
//        cpsScm {
//            git {
//                extensions {
//                    wipeOutWorkspace()
//                }
//                remote {
//                    url('ssh://git@gitlab.com:opeomotayo/helloworld-app.git')
//                    credentials('jenkins')
//                }
//                branch("$BRANCH")
//            }
//            scriptPath('Jenkinsfile')
//        }
//    }
//}
//
