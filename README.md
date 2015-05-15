# cloud-foundry-poc
A very simple Cloud Foundry application that explores some of the basic features of the environment

# Running the application
1. Setup a MongoDB instance on your local machine - it must use authentication for this to work
1. Create ${user.home}/spring-cloud.properties so Spring Cloud can connect to MongoDB (you can change the path to this file in application.properties).  See the example here for details on what needs to go in.
1. gradle clean build bootRun
1. http://localhost:8080
1. http://localhost:8080/data/findAll
