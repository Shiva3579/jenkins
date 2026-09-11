def call () {
    echo "Building the Maven project..."
    sh 'mvn clean install'
}