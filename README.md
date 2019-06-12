# kubernetes-pipeline-example

## Requirement

* Install the [Pipeline Utility Steps plugin](https://plugins.jenkins.io/pipeline-utility-steps) for Jenkins.

* Create a Kubernetes secret to store the Docker Hub credentials:
```
kubectl create secret docker-registry docker-credentials \ (1)
    --docker-username=<username>  \
    --docker-password=<password> \
    --docker-email=<email-address>
```
(1) The name of the new Kubernetes secret.
