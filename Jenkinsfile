pipeline {
  agent none
  stages {
    stage('Checkout') {
      steps {
        git 'https://github.com/vkirda/web-automation-test-framework'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn clean test -Dsurefire.suiteXmlFiles=DemoTestng.xml'
      }
    }
  }
}