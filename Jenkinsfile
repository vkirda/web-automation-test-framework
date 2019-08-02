pipeline {
  agent {
    node {
      label 'Windows'
    }

  }
  stages {
    stage('Test') {
      steps {
        tool(name: 'apache-maven-3.6.1', type: 'maven')
        bat 'clean test -Dsurefire.suiteXmlFiles=DemoTestng.xml'
        withMaven(publisherStrategy: 'EXPLICIT') {
          bat 'mvn clean test -Dsurefire.suiteXmlFiles=DemoTestng.xml'
        }

      }
    }
  }
}