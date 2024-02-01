Robot Apocalypse API (How To RUN GUIDE)

Phase 1: Database configuration
- You will need to have postgreSQL installed on your machine
- In postgreSQL create a database you can call it "apocalypsedb"
- In application.properties you will need to make modifications represented by the code snippet below
  
spring.datasource.url=jdbc:postgresql://localhost:5432/addYourDatabaseNameHere
spring.datasource.username=addYourUsernameHere
spring.datasource.password=addYourPasswordHere

- Run the ApocalypseApplication main class
- Your database configuration should be well setup and ready to test the API enpoints

Phase 2: API Testing

01) Add survivor to the database. In postman use the following code in the body to add these survivors
- http://localhost:8080/api/survivors (use this endpoint)
  ___________________________________________________________________
{
  "name": "Mary",
  "age": 24,
  "gender": "Female",
  "latitude": 16.1165,
  "longitude": -70.2364,
  "resources": [
  {
  "type": "Water",
  "quantity": 5
  },
  {
  "type": "Medication",
  "quantity": 2
  }
  ]
}
_______________________________________________________________________
{
"name": "Edith",
"age": 50,
"gender": "Female",
"latitude": 12.1144,
"longitude": -50.4874,
"resources": [
{
"type": "First Aid Supplies",
"quantity": 3
},
{
"type": "Food",
"quantity": 4
}
]
}
_______________________________________________________________________
{
"name": "Hope",
"age": 37,
"gender": "Male",
"latitude": 12.1555,
"longitude": -80.2224,
"resources": [
{
"type": "Clothing",
"quantity": 7
},
{
"type": "Blankets",
"quantity": 21
}
]
}
_______________________________________________________________________
{
"name": "Kagiso",
"age": 27,
"gender": "Male",
"latitude": 14.1335,
"longitude": -90.1111,
"resources": [
{
"type": "Fuel",
"quantity": 90
},
{
"type": "Sanitation Supplies",
"quantity": 4
}
]
}
_______________________________________________________________________
{
"name": "Bongani",
"age": 33,
"gender": "Male",
"latitude": 33.11445,
"longitude": -40.1164,
"resources": [
{
"type": "Ropes",
"quantity": 6
},
{
"type": "Medication",
"quantity": 2
}
]
}
_______________________________________________________________________

02) Update Survivor location
- http://localhost:8080/api/survivors/{id}/location  (use this endpoint)
- replace {id} with the desired ID you would like to update
- In postman click on params tab enter these values to update the location
Key: latitude    Value: 22.72345
Key: longitude   Value: -98.5678


03) Flag Survivor as infected (you do this by reporting)
- http://localhost:8080/api/reports/reportInfection (use this endpoint)
- In postman click on params tab and enter these values to for a reporter(reporterId) to report a survivor(reportedId)
  Key: reporterId    Value: 3
  Key: reportedId    Value: 1

By default the infection status is false but When an id of a survivor is reported 3 times or more their infected status will be true

04) Connect to the robot CPU system
- http://localhost:8080/api/robots/fetchAndSort (use this endpoint)
- Send a GET request to the above endpoint and the data will be fetched and stored inside a table in your database called Robots and they will be sorted

05) Reports/Analytics ( Make the following GET Requests)
- http://localhost:8080/api/survivors/infected-percentage (percentage of infected survivors)
- http://localhost:8080/api/survivors/non-infected-percentage (percentage of non survivors )
- http://localhost:8080/api/survivors/non-infected-list (list of non infected survivors)
- http://localhost:8080/api/survivors/infected-list (list of infected survivors)