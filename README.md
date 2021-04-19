# Retail demo app!

This is a skeleton RESTful application relying mainly on **SpringBoot**.
Our application is applying different discounts
-  If the user is an employee of the store, he gets a 30% discount
-  If the user is an affiliate of the store, he gets a 10% discount
-  If the user has been a customer for over 2 years, he gets a 5% discount.
- For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
as a discount).
- The percentage based discounts do not apply on groceries.
- A user can get only one of the percentage based discounts on a bill.


# Technology stack used

- Spring boot
- Spring data
- In memory database (**H2 DB**)
- Lombok
- Testing: 
  - JUnit
  - Mockito
- Maven

## Project layers

- ### Controller layer
This layer contains the RESTful endpoints, through which our configured endpoint can be consumed (**OrderController**)

- ### Service layer
 This layer processed whats coming from the controller layer and then apply our business logic including calling the repository (database) layer.

- ### Repository layer
This is the database layer dealing with database operations 
  - CustomerRepository
  - ItemRepository
  - CustomerTypeRepository
  
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


## Adding reports to your test results

1- Add the following plugin to your pom.xml 

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


2- Run the following command: 

    ```mvn site


