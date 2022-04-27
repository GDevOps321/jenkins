/*
pipeline
 {
  */
/* agent any *//*

   agent {
     node {

        label 'JAVA'
      }
   }

     stages{

        stage('Demo') {

           steps {

              echo "Akkala vamsi krishna"

            }
         }
     }

 } */

 pipeline {

   agent any
   options {
                  disableConcurrentBuilds()
             }
             environment {
                                 PROJECT_NAME ="Todoapp"
                                 UBUNTU_SSH_CRED = credentials('UBUNTU-SSH')
                       }


   stages {
     stage ('one'){
       steps
        {
           sh "echo ${PROJECT_NAME}"
           sh "env"
        }
     }
   }
 }

