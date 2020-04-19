pipeline{
    agent any
    parameters{
        string(name:'env' , defaultValue='simu', description='')
    }
    stages('test'){
        echo "${params.name}"
    }
}