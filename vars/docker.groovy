def call(Map params = [:]) {

    def args = [

            SLAVE_LABEL: "DOCKER"
    ]
    args << params


    pipeline {
        agent {
            node {
                label "${args.SLAVE_LABEL}"
            }
        }

        triggers {
            pollSCM('* * * * 1-5')
        }

        environment {
            COMPONENT = "${args.COMPONENT}"
            PROJECT_NAME = "${args.PROJECT_NAME}"
            SLAVE_LABEL = "${args.SLAVE_LABEL}"
            APP_TYPE = "${args.APP_TYPE}"
        }

        stages {

            stage('Docker build') {

                steps {
                    script {
                        get_branch = "env | grep GIT_BRANCH | awk -F / '{print \$NF}' | xargs echo -n"
                        env.get_branch_exec = sh(returnStdout: true, script: get_branch)
                    }

                    sh '''
                         env
                         aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 191059510084.dkr.ecr.us-east-1.amazonaws.com
                         docker build -t 191059510084.dkr.ecr.us-east-1.amazonaws.com/${COMPONENT}:${get_branch_exec} .
                       '''
                }

            }


            stage('Docker push') {

                steps {
                    script {
                        get_branch = "env | grep GIT_BRANCH | awk -F / '{print \$NF}' | xargs echo -n"
                        env.get_branch_exec = sh(returnStdout: true, script: get_branch)
                    }
                    sh '''
            
                      docker push 191059510084.dkr.ecr.us-east-1.amazonaws.com/${COMPONENT}:${get_branch_exec}
    
                      '''
                }
            }

        }
    }
}