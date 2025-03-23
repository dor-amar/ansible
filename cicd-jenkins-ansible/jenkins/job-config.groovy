pipelineJob('my-app-pipeline') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/your-org/your-repo.git')
                        credentials('github-credentials')
                    }
                    branches('*/main', '*/master')
                    scriptPath('Jenkinsfile')
                }
            }
        }
    }
    
    // Configure GitHub trigger
    triggers {
        githubPush()
    }
    
    // Configure GitHub project URL
    properties {
        githubProjectUrl('https://github.com/your-org/your-repo')
    }
} 