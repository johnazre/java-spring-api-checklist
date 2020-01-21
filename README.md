# How to build a Java Spring API

## Overview
This checklist will help you build a basic Spring API

## Index

## Steps
1. Go to [start.spring.io](start.spring.io), set your metadata, and download a project with the following
 dependencies:
  * Spring Boot DevTools
  * Lombok
  * Spring Web
  * Spring Data JPA
  * The driver for whichever database you're using, i.e. PostgreSQL Driver, MySQL Driver, etc.
  
2. It downloads a .zip file, so you will need to unzip it and put the contained folder wherever you store your
 projects on your hard drive, then open the folder with your code editor of choice.

3. Within the main package, create a package for each entity that you will be using, i.e. contacts, todos, etc.

4. Within each package that you create, it should have these 4 things:
    * **Model Class** (Contact, Todo, etc.)
    * **Controller Class** (ContactsController, TodosController, etc.)
    * **Repository Interface** (ContactsRepository, TodosRepository, etc.)
    * **Service Class** (ContactsServer, TodosService, etc.)

5. Within the Model class, you should have the following things:
    * The following annotations go above the class declaration
        * @Entity - To indicate that this an entity in the database
        * @Table (name = "whatever") - To indicate that a table should be created with the name of "whatever"
        * @Data - To add Lombok functionality. Lombok will automatically generate getters and setters for each property.
    * An empty constructor - We will talk about that later, but it has to do with serializing/deserializing JSON.
    * A private id field of type "long". Should have the following annotations:
        * @Id - To indicate that it is an "id" field
        * @GeneratedValue (strategy = GenerationType.IDENTITY) - To indicate that ids should be generated for new data
    * Private properties for the rest of the fields that this entity will have. These properties should have the
     following annotations:
        * @Column - To indicate that this should be a column in the table.