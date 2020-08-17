#!/bin/bash
kubectl delete gateway nik-gwy
/bin/bash ./delete-deploy.sh service-one
/bin/bash ./delete-deploy.sh service-two
