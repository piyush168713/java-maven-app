// 2nd jenkinsfile --Jenkinsfile2

def buildApp(){
    echo "building the app..."
}

def testApp(){
    echo "testing the app..."
}

def deployApp(){
    echo "deploying the app..."
    echo "Deploying version ${params.VERSION}"
}

return this