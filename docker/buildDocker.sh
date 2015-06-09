#!/bin/bash
rm -f cloud-foundry-poc.jar
gradle -b ../build.gradle clean build
cp ../build/libs/cloud-foundry-poc.jar .
docker-compose build
docker-compose up
