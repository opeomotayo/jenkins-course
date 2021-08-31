pipelineJob('pipeline-job') {
    definition {
        cps {
//            script(readFileFromWorkspace('project-a-workflow.groovy'))
            sandbox()
        }
    }
}