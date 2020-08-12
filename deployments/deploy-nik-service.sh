#!/bin/bash
DEPLOYMENT="nik-deployment"
REPLICAS=1
IMAGE=nik:0.0.1-SNAPSHOT

vars=(REPLICAS IMAGE)

# replaces placeholders in yaml file. Name of variable must be equal to placeholder.
replaceVars() {
  local result=""
  for var in ${vars[*]}; do
    result+="s/{{${var}}}/${!var}/g; "
  done

  echo $result
}

sed "$(replaceVars)" $DEPLOYMENT.yaml | kubectl apply -f -

READY=""
while [ "$READY" != "${REPLICAS}/${REPLICAS}" ]; do
  READY=$(kubectl get deployments | awk /${DEPLOYMENT}'/{print $2}')
  echo "Ready: $READY"
  sleep 3s
done
echo "Deploy is done"
