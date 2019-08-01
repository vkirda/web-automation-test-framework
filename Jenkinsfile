pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        git 'https://github.com/vkirda/web-automation-test-framework'
      }
    }
    stage('Test') {
      steps {
        bat 'mvn clean test -Dsurefire.suiteXmlFiles=DemoTestng.xml'
      }
    }
  }
}
