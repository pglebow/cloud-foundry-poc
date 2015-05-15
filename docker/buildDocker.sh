#!/bin/bash
rm -rfr build
mkdir build
cp ../build/libs/cloud-foundry-poc.jar build
docker build -t cloud-foundry-poc .
