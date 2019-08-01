pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        tool 'apache-maven-3.6.1'
        sh 'mvn clean test -Dsurefire.suiteXmlFiles=DemoTestng.xml'
      }
    }
  }
}