#!/bin/bash
kubectl apply -f nik-gateway.yaml
/bin/bash ./deploy-service.sh service-one 1 service-one:0.0.1-SNAPSHOT
/bin/bash ./deploy-service.sh service-two 1 service-two:0.0.1-SNAPSHOT
