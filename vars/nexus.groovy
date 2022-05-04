def nexus() {
    command = "curl -f -v -u admin:admin --upload-file frontend.zip http://${NEXUS_IP}:8081/repository/frontend/frontend.zip"
     def execute_state=sh(returnStdout: true, script: command)
}