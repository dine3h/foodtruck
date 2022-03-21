**FoodTruck**

FoodTruck is an API allowing consumers to locate their favourite food trucks in their locality.

**Description**

FoodTruck is a simple API which includes the following functionality:
- Location of all food trucks.
- Location of food trucks by name.
- Food trucks by location id
- Food trucks by location description

**Installation**

FoodTruck is a standard Spring Boot application using maven as a build tool and H2 as a built-in memory database.

Installation steps:
1. Clone project to local git repo.
2. Import into your favourite IDE.

You should be nearly good to go! Just one small caveat. In the scheme population file - *data.sql* - the csv location is hardcoded for the database import. Please replace this hardcoding with the absolute address of this data.sql file on your local machine.

````INSERT INTO FoodTrucks (LocationId,Applicant,FacilityType,Cnn,LocationDescription)
SELECT CONVERT( "locationId",INT ), "Applicant", "FacilityType", CONVERT( "cnn", INT), "LocationDescription"
FROM CSVREAD( '/Users/dineshk/IdeaProjects/mobiletruckapp/src/main/resources/Mobile_Food_Facility_Permit.csv', 'locationId,Applicant,FacilityType,cnn,LocationDescription', NULL);
````
There is probably a more elegant solution for this but due to the time constraints exploration of this was not possible.

3. Run the project given your IDE setup is correct.

If you would like to run the project from the command line, please use the following command by navigating to the root of the project:

`mvn spring-boot:run`

**Usage**

FoodTruck API request takes the following form:

`GET /api/food-trucks`

Example:

`curl -X GET http://localhost:8080/api/food-trucks`

Optional parameters

*name* - name of company (applicant)
*location* - a specific location

Example:

`curl -X GET -F 'name=abc' -F 'location=New York' http://localhost:8080/api/food-trucks`

The search criteria for optional parameters is based upon seeking a substring of the field values if the whole values are not provided.

If an API consumer is searching via a QR code, etc. Then an API to search by id is provided:

`GET /api/food-trucks/{id}`

Example:

`curl -X GET http://localhost:8080/api/food-trucks/1`

In the above example id is equal to 1.
