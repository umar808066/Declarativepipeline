pipeline {
    agent {
        label 'dummy' // mention the label of your webserver node provided in Jenkins
    }
    stages {
        stage('Pull') {
            steps {
                echo "Pulling from GitHub"
                git url: 'https://github.com/umar808066/EMPLOYEE-DECLARITIVE-', branch: 'main' // specify branch if needed
            }
        }
        stage('Build') {
            steps {
                script {
                    // Update and install Node.js and npm if not already installed
                    sh '''                   
                    sudo apt update
                    sudo apt install -y nodejs npm
                    sudo npm install -g n
                    sudo n 14.17.0
                    sudo apt-get install git-all -y
                    '''
                }
            }
        }
        stage('Test') {
            steps {
                echo "Running tests"
                // Add your actual testing commands here
                sh '''
                echo "Tests completed"
                '''
            }
        }
        stage('Deploy') {
            steps {
                dir('EMPLOYEE-DECLARITIVE-/frontend/') {
                    sh '''
                    sudo apt install npm
                    npm install
                    npm start &
                    echo "we are deploying"
                    '''
                }
            }
        }
    }
}
