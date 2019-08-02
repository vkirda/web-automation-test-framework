pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        withMaven(publisherStrategy: 'EXPLICIT') {
          bat 'mvn clean test -Dsurefire.suiteXmlFiles=DemoTestng.xml'
        }

      }
    }
  }
}