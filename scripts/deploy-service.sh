#!/bin/bash
DEPLOYMENT=$1
REPLICAS=$2
IMAGE=$3

vars=(DEPLOYMENT REPLICAS IMAGE)

# replaces placeholders in yaml file. Name of variable must be equal to placeholder.
replaceVars() {
  local result=""
  for var in ${vars[*]}; do
    result+="s/{{${var}}}/${!var}/g; "
  done

  echo "$result"
}

sed "$(replaceVars)" service.yaml | kubectl apply -f -

READY=""
while [ "$READY" != "${REPLICAS}/${REPLICAS}" ]; do
  READY=$(kubectl get deployments | awk /${DEPLOYMENT}'/{print $2}')
  echo "Ready: $READY"
  sleep 3s
done
echo "Deploy is done"

printf "Verification request: $(curl -sS "http://localhost:80/${DEPLOYMENT}")\n\n"