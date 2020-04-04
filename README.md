This project is a 7 microservice application consisting of a Spring REST API asset-service, a Sprint REST API configuration server,
a Spring Cloud Config Server confsvr, a Spring Eureka service and a postgresql database.
The Asset Service in this project supports all basic CRUD operations for Asset objects using Spring Data JPA to persist 
to the database microservice. The database is initialized with the schema.sql file. This service uses Hystrix to create circuit-breakers
accounting for slow Database queries/responses.
The Organization Service in this project supports all basic CRUD operations for Asset objects using Spring Data JPA to persist 
to the database microservice. The database is initialize with the schema.sql file.
The orgservice-new service is a clone of the Organization Service, set up to demonstrate service routing with Zuul and specialroutes-service.
The specialroutes-service provides an A/B testing functionality that randomly splits organizationservice requests to the old and new organization services.
The database is a basic postgresql database image deployed with Docker.
The confsvr microservice sets up configuration settings allowing the microservices to communicate and configuring 
multiple user profiles for use with the application (dev, prod, and default). The configuration files for asset-service and organization-service
profiles are hosted in a GitHub repository, with credentials provided in the config application.yml file.
The eurekasvr service enables service discovery for coordination between the services, particularly the organization
and asset services.
The zuulsvr microservice provides service routing for the application.

The application is deployed with Docker.

To run:
Build with "mvn clean package docker:build" from the root directory
Run with "docker-compose -f docker/common/docker-compose.yml up" from the root directory.

To shutdown:
Ctrl+c from terminal