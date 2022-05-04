def call(Map params  = [:]) {
    def args = [
            NEXUS_IP  = '172.31.20.130'
    ]

    pipeline
            {
                agent {
                    label "${args.SLAVE_LABEL}"
                }
                enviroment {
                    COMPONENT   = "${args.COMPONENT}"
                    NEXUS_IP    = "${args.NEXUS_IP}"
                    PROJECT_NAME= "${args.PROJECT_NAME}"
                    SLAVE_LABEL = "${args.SLAVE_LABEL}"
                }
                stages {
                    stage('prepare artifact') {
                        when {
                            enviroment name: 'APP_TYPE' , value: 'NGINX'
                        }
                        sh '''
                            cd static
                            zip -r ../${COMPONENT}.zip *

                         '''
                    }
                }
                stage('Download dependencies') {
                    when {
                        enviroment name: 'APP_TYPE' , value: 'NODEJS'
                    }
                    steps {
                        sh '''
                          npm install
                        '''
                    }
                }

                stage('prepare artifact') {
                    steps {
                        sh '''
                           zip -r ${COMPONENT}.zip node_modules server.js
                        '''
                    }
                }
                stage('upload artifacts to nexus') {
                    steps {
                        script {
                            nexus
                        }
                    }
                }

            }
    }