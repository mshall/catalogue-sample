
# Retail demo app!

  

This is a skeleton RESTful application relying mainly on **SpringBoot**.

Our application is doing the following

- Fetching catalogue products from API
-           [API URL](https://run.mocky.io/v3/b755c334-9627-4b09-84f2-548cb1918184)

- Saving these products to the database currently (Mongo DB) with Database name: 
	   

>     spring.data.mongodb.uri=mongodb://localhost:27017/cataloguedb
>     mydatabase.name=cataloguedb

- Allowing the user to call the API with full capability to filter products based on any attribute of the catalogue item

- *For example: following item:*


> {
		"id": 25846,
		"brand": "Apple",
		"phone": "Apple iPad Pro 12.9 (2018)",
		"picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-129-2018.jpg",
		"release": {
			"announceDate": "2018 October",
			"priceEur": 1100
		},
		"sim": "Nano-SIM eSIM",
		"resolution": "2048 x 2732 pixels",
		"hardware": {
			"audioJack": "No",
			"gps": "Yes with A-GPS",
			"battery": "Li-Po 9720 mAh battery (36.71 Wh)"
		}
	}

We can search using any attribute in the above mentioned sample item

  
  

# Technology stack used

  

- Spring boot

- Spring data

- No SQL Database (**Mongo DB**)
   - We used MongoDB because its a very power No SQL database and it falls into (CP) according to CPA theorem
   - Its very efficient when it comes to performance especially with high level of reads with eCommerce and catalogue
   - Mongo DB scalability is good too

- Lombok

- Testing:

- JUnit

- Mockito

- Maven

  

## Project layers

  

-  ### Controller layer

This layer contains the RESTful endpoints, through which our configured endpoint can be consumed (**CatalogueController**)

  

-  ### Service layer

This layer processed whats coming from the controller layer and then apply our business logic including calling the repository (database) layer.

  

-  ### Repository layer

This is the database layer dealing with database operations

- ICatalogueRepository

- CatalogueRepositoryImpl

## How to run project

  

Project is using maven. so, you can download the project, run the following command to generate the jar file which will be the executable one for us to run the project but make sure you have maven installed on your machine:

  

### Steps

  

1- Run the following command:

  

mvn clean install package

  

This command shall run the maven to delete the target directory and start building the project to be packaged in the form of jar as configured in *pom.xml* file

  

2- Navigate to **target** generated after running the above maven command, then you shall find a file named **retail-demo-1.0-SNAPSHOT.jar**

  

3- While you're inside the target directory, run the following command

  

java -jar retail-demo-1.0-SNAPSHOT.jar

  

4- Theres another way other than the above third command, by navigating to your project directory and run:

```

mvn spring-boot:run

```

  

5- If you want to run the test cases you can execute the following command:

  

     mvn test

6- To test the APIs you can use the postman collection in the same directory hierarchy              
           **Postman Collection**

  

## Further enhancement which could be done more

  

### 1- Add test coverage through the following:

       Add the following plugin to your pom.xml

  

       <reporting>

       <plugins>

       <plugin>

       <groupId>org.apache.maven.plugins</groupId>

       <artifactId>maven-surefire-report-plugin</artifactId>

       </plugin>

       <plugin>

       <groupId>org.apache.maven.plugins</groupId>

       <artifactId>maven-jxr-plugin</artifactId>

       </plugin>

       </plugins>

       </reporting>

  
  

  Then Run the following command:

  

     mvn site


### 2- Adding embeded MongoDB (In-Memory one)


### 3- Dockerizing the application