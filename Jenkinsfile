pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        bat 'mvn clean test -Dsurefire.suiteXmlFiles=DemoTestng.xml'
      }
    }
  }
}