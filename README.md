## My Book Library 

This project provides api for books 


#### Database ER ideas

  A book can be published by only one publisher and publisher can able to publish multiple books so many-to-one relationship. (Books will be on Many side where as Publisher will be on one side)
  
  A book can have multiple authors similarly author can able to write multiple books so books and authors can be many-to-many relationship.
  
  Primary contact/head quarters information of Publisher can be stored in Address table. 
  
  Book 
  
  ```java
  
@Entity
@Data
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private Date publicationDate;

	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;


	@ManyToMany(cascade = {CascadeType.PERSIST})
	@JoinTable(
			name="book_author",
			joinColumns={@JoinColumn(name = "book_id")},
			inverseJoinColumns = {@JoinColumn(name = "author_id")}
	)
	private Set<Author> authors = new HashSet<>();
}

  
  ```

  Publisher
  
  ```java

@Entity
@Data
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "publisher")
	private Set<Book> books = new HashSet<>();

}
```

  Author
  
  ```java

@Entity
@Data
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();
}
```  


## Project development

#### Steps
  
  Create entities and their relationships for a project
  
  Application profiles for different environments 
  
  Database configurations 
  

## Schema

```  /api/books```
```json
  {
    "books" : [
        {
          "id" : "XYZ",
          "title" : "Book title",
          "publicationDate" : "7/3/2018",
          "authors" : [
            "Santhosh",
            "Satheesh"
          ],
          "publisher" : "publisher name"
        }
    ]
  }

```
```/api/books/{id}```   
```json
  {
    "id" : "XYZ",
    "title" : "Book title",
    "publicationDate" : "7/3/2018",
    "authors" : [
      "Santhosh",
      "Satheesh"
      ],
    "publisher" : "publisher name"
  }

```  

```/api/books/{id}/authors```
```json
  {
    "id" : "XYZ",
    "authors" : [
      "Satheesh",
      "Santhosh"
    ]
  }
```


  
### Local environment setup

```text
   
    MySQL installation using brew 
    
    brew install mysql
    brew services start mysql
    brew services stop mysql
    brew servise restart mysql
    
   
```
  
    
## Docker build

```dockerfile

FROM openjdk:8
ADD target/mylibrary-api.jar mylibrary-api.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=local", "mylibrary-api.jar"]
```    
    
```dockerfile
version: '3.1' #docker-compose version
services:
  mysql:
    image: mysql:5.5
    ports: ['3306:3306']
    hostname: mysql
    environment:
      - MYSQL_ROOT_PASSWORD=Java@123
      - MYSQL_DATABASE=mylibrary

  web:
    build: .
    image: mylibrary-api
    ports: ["8081:8081"]
    hostname: mylibrary
    tty: true
    environment:
      - MYSQL_USER=root
      - MYSQL_PASSWORD=Java@123


```
    

