multibranchPipelineJob('multibranchPipelineJob2') {
    branchSources {
        git {
            id = 'configuration-as-code'
            remote('https://github.com/jenkinsci/configuration-as-code-plugin.git')
        }
    }
}