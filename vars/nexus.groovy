def nexus()
{
    command = "curl -f -v -u admin:admin --upload-file frontend.zip http://${NEXUS_IP}:8081/repository/frontend/frontend.zip"
     def execute_state=sh(returnStdout: true, script: command)
}
def make_artifacts(APP_TYPE, COMPONENT) {

    if(APP_TYPE == "NGINX") {
        command = "cd static && zip -r ../${COMPONENT} *"
        def execute_com=sh(returnStdout: true, script: command)
        print execute_com
    } else if(APP_TYPE == "NODEJS") {
        command = "zip -r ${COMPONENT} node_modules server.js"
        def execute_com=sh(returnStdout: true, script: command)
        print execute_com
    } else if(APP_TYPE == "JAVA") {
        command = "cp target/*.jar ${COMPONENT}.jar && zip -r ${COMPONENT} ${COMPONENT}.jar"
        def execute_com=sh(returnStdout: true, script: command)
        print execute_com
    } else if(APP_TYPE == "PYTHON") {
        command = "zip -r ${COMPONENT} payment.ini payment.py rabbitmq.py requirements.txt"
        def execute_com=sh(returnStdout: true, script: command)
        print execute_com
    }
}

def code_build(APP_TYPE, COMPONENT) {
    if(APP_TYPE == "NODEJS") {
        command = "npm install"
        def execute_com=sh(returnStdout: true, script: command)
        print execute_com
    } else if(APP_TYPE == "JAVA") {
        command = "mvn compile package"
        def execute_com=sh(returnStdout: true, script: command)
        print execute_com
    }
}