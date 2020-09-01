#!/bin/bash
kubectl apply -f nik-gateway.yaml
kubectl apply -f virtual-services.yaml
/bin/bash ./deploy-service.sh service-one 1 service-one:0.0.1-SNAPSHOT
/bin/bash ./deploy-service.sh service-two 1 service-two:0.0.1-SNAPSHOT
