#!/bin/bash
kubectl delete deployment nik-deployment
kubectl delete service nik-svc
kubectl delete ingress nik-ingress