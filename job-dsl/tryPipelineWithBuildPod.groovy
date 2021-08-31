pipelineJob('pipeline-job-with-build-pod') {
    definition {
        cps {
            script('''
        pipeline {
              agent {
                  kubernetes {
                    defaultContainer 'docker'
                    yamlFile 'BuildPod.yaml'
                  }
              }
                stages {
                    stage('Stage 1') {
                        steps {
                            echo 'logic'
                        }
                    }
                    stage('Stage 2') {
                        steps {
                            echo 'logic'
                        }
                    }
                }
            }
        }
      '''.stripIndent())
            sandbox()
        }
    }
}

