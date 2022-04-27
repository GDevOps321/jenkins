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

   envinorment {
     Name = "vamsi"
   }
   stages{
    stage{
     steps('one')
     {
        sh "echo ${Name}"
     }
    }
     }
 }

