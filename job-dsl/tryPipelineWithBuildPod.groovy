pipeline {
  agent {
      kubernetes {
        defaultContainer 'docker'
        yamlFile 'BuildPod.yaml'
      }
  }
}
