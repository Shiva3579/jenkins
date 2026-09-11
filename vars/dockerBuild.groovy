def call (String imageName, String tag) {
    echo "Build Docker image..."
    sh "docker build -t ${imageName}:${tag} ."
}
