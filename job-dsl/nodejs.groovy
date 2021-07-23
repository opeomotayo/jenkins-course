job('NodeJS example') {
    scm {
        git('git://github.com/wardviaene/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('Node-10.17') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Global Tool Configuration -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}
