# How to build a Java Spring API

## Overview
This checklist will help you build a basic Spring API

## Index

## Steps
1. Go to [start.spring.io](https://start.spring.io/), set your metadata, and download a project with the following
 dependencies:
  * **Spring Boot DevTools**
  * **Lombok**
  * **Spring Web**
  * **Spring Data JPA**
  * **The driver for whichever database you're using, i.e. PostgreSQL Driver, MySQL Driver, etc.**
  
2. It downloads a .zip file, so you will need to unzip it and put the contained folder wherever you store your
 projects on your hard drive, then open the folder with your code editor of choice.

3. Within the main package, create a package for each entity that you will be using, i.e. contacts, todos, etc.

4. Within each package that you create, it should have these 4 things:
    * **Model Class** (Contact, Todo, etc.)
    * **Controller Class** (ContactsController, TodosController, etc.)
    * **Repository Interface** (ContactsRepository, TodosRepository, etc.)
    * **Service Class** (ContactsService, TodosService, etc.)

5. Within the [Model class](https://github.com/johnazre/java-spring-api-checklist/blob/master/src/main/java/com/galvanize/contactsapibasic/contacts/Contact.java), you should have the following things:
    * The following annotations go above the class declaration
        * `@Entity` - To indicate that this an entity in the database
        * `@Table (name = "whatever")` - To indicate that a table should be created with the name of "whatever"
        * `@Data` - To add Lombok functionality. Lombok will automatically generate getters and setters for each property.
    * An empty constructor - We will talk about that later, but it has to do with serializing/deserializing JSON.
    * A private id field of type "long". Should have the following annotations:
        * `@Id` - To indicate that it is an "id" field
        * `@GeneratedValue (strategy = GenerationType.IDENTITY)` - To indicate that ids should be generated for new data
    * Private properties for the rest of the fields that this entity will have. These properties should have the
     following annotations:
        * `@Column` - To indicate that this should be a column in the table.
        
6. Within the [Repository interface](https://github.com/johnazre/java-spring-api-checklist/blob/master/src/main/java/com/galvanize/contactsapibasic/contacts/ContactsRepository.java), you should add that your repository extends "JpaRepository" and add a generic to
 the right of it that looks like `<TheModelName, TheDataTypeOfTheIdField>`.
 
7. Within the [Service class](https://github.com/johnazre/java-spring-api-checklist/blob/master/src/main/java/com/galvanize/contactsapibasic/contacts/ContactsService.java)
    * The following annotations go above the class declaration:
        * `@Service` - To indicate that this class is a service
    * At the top of the controller class, [add the `@Autowired` annotation](https://github.com/johnazre/java-spring-api-checklist/blob/5a91585eb212b111e6c0ca5261af80a507566980/src/main/java/com/galvanize/contactsapibasic/contacts/ContactsService.java#L11) 
    and [declare an instance of your repository interface](https://github.com/johnazre/java-spring-api-checklist/blob/5a91585eb212b111e6c0ca5261af80a507566980/src/main/java/com/galvanize/contactsapibasic/contacts/ContactsService.java#L12).
    * [Create a constructor that instantiates the injected repository interface.](https://github.com/johnazre/java-spring-api-checklist/blob/5a91585eb212b111e6c0ca5261af80a507566980/src/main/java/com/galvanize/contactsapibasic/contacts/ContactsService.java#L14)
    * Create all the methods you need to manage your data, i.e. getAll, getOne, addOne, updateOne, removeOne, etc.
    * Things to keep in mind:
        * Repository methods return a List, not an ArrayList.
        * In the case where you are using a method to look for something, but don't know if it exists or not, you can
         use the `Optional` type. Example: `Optional<Contact>`
 
8. Within the [Controller class](https://github.com/johnazre/java-spring-api-checklist/blob/master/src/main/java/com/galvanize/contactsapibasic/contacts/ContactsController.java):
    * The following annotations go above the class declaration
        * `@RestController` - Indicates that this will be a controller file
        * `@RequestMapping("/contacts")` - Maps this controller to a route prefix, such as "/contacts", in this case.
    * At the top of the controller class, [add the `@Autowired` annotation](https://github.com/johnazre/java-spring-api-checklist/blob/64f53a7b1b78eb44de772ad9730a05057fde87f5/src/main/java/com/galvanize/contactsapibasic/contacts/ContactsController.java#L14) 
    and [declare an instance of your service class](https://github.com/johnazre/java-spring-api-checklist/blob/64f53a7b1b78eb44de772ad9730a05057fde87f5/src/main/java/com/galvanize/contactsapibasic/contacts/ContactsController.java#L15).
    * [Create a constructor that instantiates the injected service class.](https://github.com/johnazre/java-spring-api-checklist/blob/64f53a7b1b78eb44de772ad9730a05057fde87f5/src/main/java/com/galvanize/contactsapibasic/contacts/ContactsController.java#L17)
    * Create all the route handler methods you need to manage your data, i.e. getAll, getOne, addOne, updateOne, removeOne, etc.
    * To indicate which HTTP method this route will look for, use one of the following annotations above the method
     declaration:
        * `@GetMapping`
        * `@PostMapping`
        * `@PatchMapping`
        * `@PutMapping`
        * `@DeleteMapping`
        * URL prefixes can be added to these methods like this: `@GetMapping("/something")`
        * If no prefix is added, it will default to a route on the root prefix of the controller