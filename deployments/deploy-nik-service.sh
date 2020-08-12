#!/bin/bash
DEPLOYMENT="nik-deployment"

kubectl apply -f $DEPLOYMENT.yaml

READY=""
while [ "$READY" != "1/1" ]; do
  READY=$(kubectl get deployments | grep $DEPLOYMENT | awk '{print $2}')
  echo "Ready: $READY"
  sleep 3s
done
echo "Deploy is done"
