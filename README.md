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
|  Annotation |  Reason |
|---|---|
| @Entity  | asdf  |
| @Table (name = "whatever")   |  asdfasdf |
| @Data   | adsfasd  |
