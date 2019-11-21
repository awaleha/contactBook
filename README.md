# contactBook
Simple Spring Java RESTful Contact Book. Uses Java Hashmap as Storage. 

Uses Gradle to Build, to build the JAR file run this command in terminal:

  gradle build
  java -jar build/libs/gs-rest-service-0.1.0.jar 
  
  
 The application takes simple GET requests to create, return, update and delete contacts. 
 
 To create a contact
   http://localhost:8080/contacts/create/firstname/lastname/phonenum/cellnum/address
 Once a contact is created, they can be refrenced by their first and last name.
 
 To get a contact
  http://localhost:8080/contacts/firstname.lastname
 
 To update a contact
  http://localhost:8080/contacts/update/firstname/lastname/phonenum/cellnum/address
 
 To delete a contact
  http://localhost:8080/contacts/delete/firstname.lastname
 
 To get all contacts
  http://localhost:8080/contacts/all
  
