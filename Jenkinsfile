pipeline {
  agent any
  stages {
    stage('testStageName') {
      steps {
        build 'mvn clean test -Dsurefire.suiteXmlFiles=DemoTestng.xml'
      }
    }
  }
}