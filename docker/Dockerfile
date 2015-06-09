FROM dockerfile/java:oracle-java8
MAINTAINER pglebow@gmail.com
EXPOSE 8080
CMD java -Dspring.profiles.active="docker" -jar cloud-foundry-poc.jar
ADD cloud-foundry-poc.jar /data/cloud-foundry-poc.jar