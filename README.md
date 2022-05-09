# qrservice
QR Code API Service

## Environment 

    Java 1.8

    mysql 5.7

    apache-maven-3.6.3

    Docker

## Run Commands

build : mvn clean install

  Run : 

          Spring Boot Run: java -jar qrservice-0.0.1-SNAPSHOT.jar
 
          
 ## Deployment 
 
    
    Docker : 
  
          docker build -t qrservice/v-api:latest .
          
          docker push mahenmsd/qrservice-api:latest
          
          docker run -p 8070:8070 -d --name qrservice-api mahenmsd/qrservice-api:latest
          
    Live : 
    
          http://34.124.176.53:8070/api/swagger-ui.html
    
    Login :
          
          1. admin user
          
              username : admin
          
              password : admin
          
          2.  user
          
              username : user
          
              password : user
              
      ### Assumptions

      1.  Two user role added manually in Database for manage User Role.
      2.	When we upload the QR code file, qrType is mandatory.
      3.	API Support below qrTypes only.
            Text
            URL
            vCard
       4.	 API Login username is unique.

        

