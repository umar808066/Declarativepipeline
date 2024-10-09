pipeline {
      agent{
        label 'dummy'    //mention the label of your webserver node provided in jenkins
    }
    stages {
          stage('Pull') {
            steps {
                 sh '
                 git clone https://github.com/umar808066/EMPLOYEE-DECLARITIVE-.git'
                 echo "we are pulling from github"
                
            }
        }
        stage('Build') {
            steps {
                sh '''
                cd EMPLOYEE-DECLARITIVE-/frontend/
                sudo apt update
                sudo apt install -y nodejs npm
                sudo npm install -g n
                sudo n 14.17.0 node -v0
                sudo apt-get install git-all -y'''
            }
        }
        stage('Test') {
            steps {
                sh '''echo "we are testing"
                '''
            }
        }
        stage('Deploy') {
            steps {
                sh '''
                npm install
                npm start 
                echo "we are deploying"
                '''
            }
        }
    }
}
