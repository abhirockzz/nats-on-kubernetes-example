## NATS on Kubernetes example

This example uses [minikube](https://github.com/kubernetes/minikube)

- start Kubernetes - `minikube start`
- create NATS CRD - `kubectl apply -f https://raw.githubusercontent.com/nats-io/nats-operator/master/example/deployment.yaml`
- check `kubectl get crd`

![](images/nats-crd.JPG)

- deploy cluster - `kubectl apply -f https://raw.githubusercontent.com/nats-io/nats-operator/master/example/example-nats-cluster.yaml`
- check `kubectl get natsclusters.nats.io`

![](images/nats-cluster.JPG)

- create publisher app deployment - `kubectl create -f nats-pub-deployment.yaml` (will pull image from `https://hub.docker.com/r/abhirockzz/nats-pub/`)

- check `kubectl get deployments -l app=nats-pub`

![](images/nats-pub-deployment.JPG)

- locate the pod - `kubectl get pods -l app=nats-pub` ....

![](images/nats-pub-pod.JPG)

- .. and check logs `kubectl logs <pod>`

![](images/nats-pub-logs.JPG)

- create subscriber app deployment - `kubectl create -f nats-sub-deployment.yaml` (will pull image from `https://hub.docker.com/r/abhirockzz/nats-sub/`)

- check `kubectl get deployments -l app=nats-sub`

![](images/nats-sub-deployment.JPG)

- locate the pod - `kubectl get pods -l app=nats-sub` ....

![](images/nats-sub-pod.JPG)

- .. and check logs `kubectl logs <pod>`

![](images/nats-sub-logs.JPG)
