folder('CI-Pipelines') {
    displayName('CI Pipelines')
    description('CI Pipelines')
}
    pipelineJob("CI Pipelines/frontend-ci") {
        configure { flowdefinition ->
            flowdefinition << delegate.'definition'(class: 'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition', plugin: 'workflow-cps') {
                'scm'(class: 'hudson.plugins.git.GitSCM', plugin: 'git') {
                    'userRemoteConfigs' {
                        'hudson.plugins.git.UserRemoteConfig' {
                            'url'('https://github.com/GDevOps321/frontend-1.git')
                        }
                    }

                    'branches' {
                        'hudson.plugins.git.BranchSpec' {
                            'name'('*/main')
                            //'name'('*/tags/*')
                        }
                    }
                }
                'scriptPath'('Jenkinsfile')
                'lightweight'(true)
            }
        }
    }