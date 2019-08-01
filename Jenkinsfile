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
        def mvnHome = tool name: 'apache-maven-3.6.1', type: 'maven'
        sh '${mvnHome}/bin/mvn clean test -Dsurefire.suiteXmlFiles=DemoTestng.xml'
      }
    }
  }
}
