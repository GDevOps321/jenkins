def call(Map params  = [:]) {
    def args = [
            NEXUS_IP = '172.31.20.130'
    ]
    args << params

    pipeline
            {
                agent {
                    label "${args.SLAVE_LABEL}"
                }
                environment {
                    COMPONENT = "${args.COMPONENT}"
                    NEXUS_IP = "${args.NEXUS_IP}"
                    PROJECT_NAME = "${args.PROJECT_NAME}"
                    SLAVE_LABEL = "${args.SLAVE_LABEL}"
                    APP_TYPE = "${args.APP_TYPE}"
                }
                stages {
                    stage('prepares artifact') {
                        when {
                            environment name: 'APP_TYPE', value: 'NGINX'
                        }
                        steps {
                            sh '''
                             cd static
                             zip -r ../${COMPONENT}.zip *
                           '''
                        }
                    }

                    stage('Downloading dependencies') {
                        when {
                            environment name: 'APP_TYPE', value: 'NODEJS'
                        }
                        steps {
                            sh '''
                          npm install
                        '''
                        }
                    }

                    stage('prepared artifact') {
                        when {
                            environment name: 'APP_TYPE', value: 'JAVA'
                        }
                        steps {
                            sh '''
                             zip -r ${COMPONENT}.zip node_modules server.js
                           '''
                        }
                    }
                    stage('Download dependencies') {
                        steps {
                            sh '''
                                   mvn compile
                                '''
                        }
                    }
                    stage('Make package') {
                        steps {
                            sh '''
                              mvn package
                            '''
                        }
                    }

                    stage('preparing artifact') {
                        steps {
                            sh '''
                               cp target/*.jar ${COMPONENT}.jar
                                zip -r ${COMPONENT}.zip ${COMPONENT}.jar
                            '''
                        }
                    }
                    stage('prepare artifact') {
                        when {
                            environment name: 'APP_TYPE', value: 'PYTHON'
                        }
                        steps {
                                  sh '''
                                     zip -r ${COMPONENT}.zip *
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
    }