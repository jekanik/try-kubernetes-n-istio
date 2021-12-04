### Preconditions
_mvn_ and _kubectl_ must be available on your machine.

### How to run
Run _scripts/build-images.sh_ to create images for two services.\
Run _scripts/run.sh_ to deploy services.\
Run _scripts/delete.sh_ to delete services.

### Tested on env
macOs **Big Sur 11.6** MacBook Pro\
Docker Desktop v.3.5.1 (3.5.1.7)\
Istio 1.12.0

Don't forget to: 
* Install Istio from https://istio.io/latest/docs/setup/getting-started
* Add istioctl to /etc/paths
* Add more memory for docker desktop (5G is enough)
