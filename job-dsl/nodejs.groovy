job('dsl example1') {
    scm {
        git('git://github.com/opeomotayo/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in
                         // Manage Jenkins -> Global Tool Configuration -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}
