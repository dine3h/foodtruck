CREATE TABLE IF NOT EXISTS FoodTrucks(
    LocationId          INTEGER  PRIMARY KEY   NOT NULL,
    Applicant           VARCHAR(128)    NOT NULL,
    FacilityType        VARCHAR(128),
    Cnn                 INTEGER         NOT NULL,
    LocationDescription VARCHAR(128)
);