folder('CI-Pipelines') {
    displayName('CI Pipelines')
    description('CI Pipelines')
}
    pipelineJob("CI-Pipelines/frontend-ci") {
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
pipelineJob("CI-Pipelines/catalogue-ci") {
    configure { flowdefinition ->
        flowdefinition << delegate.'definition'(class: 'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition', plugin: 'workflow-cps') {
            'scm'(class: 'hudson.plugins.git.GitSCM', plugin: 'git') {
                'userRemoteConfigs' {
                    'hudson.plugins.git.UserRemoteConfig' {
                        'url'('https://github.com/GDevOps321/catalogue.git')
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
pipelineJob("CI-Pipelines/user-ci") {
    configure { flowdefinition ->
        flowdefinition << delegate.'definition'(class: 'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition', plugin: 'workflow-cps') {
            'scm'(class: 'hudson.plugins.git.GitSCM', plugin: 'git') {
                'userRemoteConfigs' {
                    'hudson.plugins.git.UserRemoteConfig' {
                        'url'('https://github.com/GDevOps321/user.git')
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
pipelineJob("CI-Pipelines/cart-ci") {
    configure { flowdefinition ->
        flowdefinition << delegate.'definition'(class: 'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition', plugin: 'workflow-cps') {
            'scm'(class: 'hudson.plugins.git.GitSCM', plugin: 'git') {
                'userRemoteConfigs' {
                    'hudson.plugins.git.UserRemoteConfig' {
                        'url'('https://github.com/GDevOps321/cart.git')
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

pipelineJob("CI-Pipelines/shipping-ci") {
    configure { flowdefinition ->
        flowdefinition << delegate.'definition'(class: 'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition', plugin: 'workflow-cps') {
            'scm'(class: 'hudson.plugins.git.GitSCM', plugin: 'git') {
                'userRemoteConfigs' {
                    'hudson.plugins.git.UserRemoteConfig' {
                        'url'('https://github.com/GDevOps321/shipping.git')
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
pipelineJob("CI-Pipelines/payment-ci") {
    configure { flowdefinition ->
        flowdefinition << delegate.'definition'(class: 'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition', plugin: 'workflow-cps') {
            'scm'(class: 'hudson.plugins.git.GitSCM', plugin: 'git') {
                'userRemoteConfigs' {
                    'hudson.plugins.git.UserRemoteConfig' {
                        'url'('https://github.com/GDevOps321/payment.git')
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