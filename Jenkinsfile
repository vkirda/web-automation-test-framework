pipeline {
  agent any
  stages {
    stage('testStageName') {
      steps {
        build 'testJob'
      }
    }
  }
  environment {
    testName = 'testValue'
  }
}