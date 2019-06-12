# kubernetes-pipeline-example

This Jenkins pipeline builds a Spring Boot application using Maven, then builds a Docker image using Kaniko, uploads the image to Docker Hub and finally simulates a Deployment via Helm.

## Requirement

* Install the [Pipeline Utility Steps plugin](https://plugins.jenkins.io/pipeline-utility-steps) for Jenkins.

* Create a Kubernetes secret to store the Docker Hub credentials:
```
kubectl create secret docker-registry docker-credentials \ (1)
    --docker-username=<username>  \
    --docker-password=<password> \
    --docker-email=<email-address>
```
(1) The name of the Kubernetes secret containing the Docker Hub credentials.

* Update the pipeline to use your own Docker Hub repository.
