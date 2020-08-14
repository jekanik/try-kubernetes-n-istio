#!/bin/bash
SERVICE=$1

kubectl delete deployment $SERVICE
kubectl delete service $SERVICE