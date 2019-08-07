pipelineJob('DSL_pipeline') {
    
    def repo = "https://github.com/rannygmx/docker-cicd.git"

    triggers {
        scm('H/5 * * * *')
    }

    description("pipline for $repo")

    definition{
       cpsScm{
           scm{
               git{
                   remote {url(repo)}
                   branches('master', '**/feature*')
                   extensions {}
               }
           }
           scriptPath('./basics/misc/Jenkinsfile.v2')
       }
   }
}
