#!/bin/bash

buildImage() {
  mvn spring-boot:build-image -Dmaven.test.skip=true -f $1/pom.xml
}

cd ../
buildImage service-one
buildImage service-two
