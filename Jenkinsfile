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


   stages {
     stage {
       steps ('one')
        {
           sh "echo ${Name}"
        }
     }
   }
 }

