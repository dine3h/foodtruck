INSERT INTO FoodTrucks (LocationId,Applicant,FacilityType,Cnn,LocationDescription)
SELECT CONVERT( "locationId",INT ), "Applicant", "FacilityType", CONVERT( "cnn", INT), "LocationDescription"
FROM CSVREAD( '/Users/damodardas/IdeaProjects/mobiletruckapp/src/main/resources/Mobile_Food_Facility_Permit.csv', 'locationId,Applicant,FacilityType,cnn,LocationDescription', NULL);