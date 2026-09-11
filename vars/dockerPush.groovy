def call (String image_name, String tag) {
    withDockerRegistry([credentialsId: 'dockerhub']) {
        echo "Pushing Docker image to Docker Hub..."
         sh "docker push ${image_name}:${tag}"
    }
}
