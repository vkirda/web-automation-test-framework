pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        tool(name: 'apache-maven-3.6.1', type: 'maven')
        sh 'mvn clean test -Dsurefire.suiteXmlFiles=DemoTestng.xml'
      }
    }
  }
}