freeStyleJob('freeStyleJob0') {
    scm {
        git{
            branch('master')
            remote{
                credentials('github_e_token')
                url('https://github.com/jenkins_bootstrap.git')
            }
        }
    }
    triggers {
        githubPush()
    }
    steps {
        dsl {
            external('seedJob.groovy')
            removeAction('DELETE')
        }
    }
}
