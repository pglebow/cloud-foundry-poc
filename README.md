# cloud-foundry-poc
A very simple Cloud Foundry application that explores some of the basic features of the environment

# Running the application

## Gradle & Spring Boot
1. Setup a MongoDB instance on your local machine - it must use authentication for this to work
1. Create `${user.home}/spring-cloud.properties` so Spring Cloud can connect to MongoDB (you can change the path to this file in `application.properties`).  See `spring-cloud.properties` at the root of the project for details on what needs to go in.
1. `gradle clean build bootRun`
1. http://localhost:8080

## Docker
1. Change to the directory `cloud-foundry-poc/docker`
1. If you're running on a Mac, make sure to do a `boot2docker up` before proceeding.  
1. If you're running on a Mac, note the IP address returned from `boot2docker ip` - this will be the host that your browser should use
1. `./buildDocker.sh`
1. http://192.168.59.103:8080 (if not using a Mac, substitute your machine's IP or hostname)
