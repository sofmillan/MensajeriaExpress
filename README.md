# Messenger service
This repository contains the final project for MAKAIA's Backend Development Bootcamp and its main purpose is to evidence all of the syllabus that was taught throguh the last few months. This service provides a company a structure to manage data such as client's and employee's information, retrieved from a database, and create and track deliveries that clients made.
This project was made with:
- Java 
- MySQL

And here are some of the tools that Spring Framework allow us to use:
- JUnit (for unit tests)
- Swagger (for API documentation)
- Spring Security ( for a basic authentication)
- Spring Data (to store information in a database)

It also implements Git for version management and continuous integration and Railways for deployment.
## Diagrams

### Client diagram

<img src="https://user-images.githubusercontent.com/98916125/233485325-c38403b7-4559-441f-aad7-0101fa0083a5.jpg"  width="700" />

### Employee diagram
<img src="https://user-images.githubusercontent.com/98916125/233488361-74296e7f-e278-4c91-91ae-df39ef13b20a.jpg"  width="700" />

### Delivery and Package diagram
<img src="https://user-images.githubusercontent.com/98916125/233622128-e3211c65-8c42-4c74-80dc-1c9f771fb20e.jpg"  width="700" />

### Exceptions diagram
Since all of the previous packages use customized exceptions, here it is the diagram for them.
<img src="https://user-images.githubusercontent.com/98916125/233626033-cc3bbecc-586f-4762-8739-e44f7451dd5e.jpg"  width="700" />

### Database diagram
<img src="https://user-images.githubusercontent.com/98916125/233628544-26455090-c344-453d-8eec-6ca081ffb446.jpg"  width="700" />

## Endpoints

### Client related operations
With the following endpoints you can execute all of the CRUD (create, read, update, delte) operations. 

#### POST: api/v1/client
To create a client on the database you must provide an id (number max 10 digits),  name (string), last name (string), phone number (number), email (string), address (string) and city (string). 

**Request example:**
```json
{
	"id": 123,
	"name": "Sofia",
	"lastName": "Millan",
	"phoneNumber": 123123,
	"email": "isabella@gmail.com",
	"address": "Cll26",
	"city": "Medellín"
}
```
**Expected response:**
```json
{
	"id": 123,
	"name": "Sofia",
	"lastName": "Millan",
	"phoneNumber": 123123,
	"email": "isabella@gmail.com",
	"address": "Cll26",
	"city": "Medellín"
}
```

#### GET: api/v1/client/{clientId}
To retrieve an existent client's information from the database just indicate the client's id in the path.

**Request example:**
```
http://localhost:8080/api/v1/client/123
```
**Expected response:**
```json
{
	"id": 123,
	"name": "Sofia",
	"lastName": "Millan",
	"phoneNumber": 123123,
	"email": "isabella@gmail.com",
	"address": "Cll26",
	"city": "Medellín"
}
```

#### DELETE: api/v1/client/{clientId}
To delete an existent client from the database just indicate the client's id in the path.

**Request example:**
```
http://localhost:8080/api/v1/client/123
```
**Expected response:**
```json
{
	"message": "Client with id 123 deleted successfully"
}
```

#### PUT: api/v1/client/{clientId}
To update an existent client's information indicate the client's id in the path and provide the updated information.

**Request example:**
```
http://localhost:8080/api/v1/client/123
```
```json
{
	"id": 123,
	"name": "Isabella",
	"lastName": "Millan",
	"phoneNumber": 123123,
	"email": "isabella@gmail.com",
	"address": "Cll85",
	"city": "Medellín"
}
```
**Expected response:**
```json
{
	"id": 123,
	"name": "Isabella",
	"lastName": "Millan",
	"phoneNumber": 123123,
	"email": "isabella@gmail.com",
	"address": "Cll85",
	"city": "Medellín"
}
```
---
### Employee related operations
With the following endpoints you can execute all of the CRUD (create, read, update, delte) operations. \
<br>

#### POST: api/v1/employee
To create a client on the database you must provide an id (number max 10 digits),  name (string), last name (string), phone number (number), email (string), address (string), city (string), seniority (number), blood type (string) and type of employee (string).

**Request example:**
```json
{
	"id":456,
	"name":"Sofia",
	"lastName":"Millan",
	"phoneNumber":123123,
	"email":"isabella@gmail.com",
	"address":"Cll26",
	"city":"Medellín",
	"seniority":1,
	"bloodType":"o+",
	"type":"coordinator"
}
```
**Expected response:**
```json
{
	"id":456,
	"name":"Sofia",
	"lastName":"Millan",
	"phoneNumber":123123,
	"email":"isabella@gmail.com",
	"address":"Cll26",
	"city":"Medellín",
	"seniority":1,
	"bloodType":"o+",
	"type":"coordinator"
}
```

#### GET: api/v1/employee/{employeeId}
To retrieve an existent employee's information from the database just indicate the employee's id in the path.

**Request example:**
```
http://localhost:8080/api/v1/employee/456
```
**Expected response:**
```json
{
	"id":456,
	"name":"Sofia",
	"lastName":"Millan",
	"phoneNumber":123123,
	"email":"isabella@gmail.com",
	"address":"Cll26",
	"city":"Medellín",
	"seniority":1,
	"bloodType":"o+",
	"type":"coordinator"
}
```

#### DELETE: api/v1/employee/{employeeId}
To delete an existent employee from the database just indicate the employee's id in the path.

**Request example:**
```
http://localhost:8080/api/v1/employee/456
```
**Expected response:**
```json
{
	"message": "Employee with id 456 deleted successfully"
}
```

#### PUT: api/v1/employee/{employeeId}
To update an existent employee's information indicate the employee's id in the path and provide the updated information.

**Request example:**
```
http://localhost:8080/api/v1/employee/456
```
```json
{
	"id":456,
	"name":"Sofia",
	"lastName":"Millan",
	"phoneNumber":123123,
	"email":"isabella@gmail.com",
	"address":"Cll26",
	"city":"Bogotá",
	"seniority":2,
	"bloodType":"o+",
	"type":"coordinator"
}
```
**Expected response:**
```json
{
	"id":456,
	"name":"Sofia",
	"lastName":"Millan",
	"phoneNumber":123123,
	"email":"isabella@gmail.com",
	"address":"Cll26",
	"city":"Bogotá",
	"seniority":2,
	"bloodType":"o+",
	"type":"coordinator"
}
```
---
### Delivery related operations
With the following endpoints you can create a new delivery (a client can order multiple deliveries), update a delivery status, filter deliveries by status and get a specific delivery's information. \
<br>

#### POST: api/v1/delivery
To create a delivery on the database you must provide an existent client's id (number max 10 digits), origin city (string), destination city (string), the name of the person who will receive the package (string) and their phone number (number), the declared value of the package (number), the package's weight (number) and the destination address (string).

**Request example:**
```json
{
	"idClient":1,
	"originCity":"Armenia",
	"destinationCity":"Medellin",
	"receiverName":"Ricky",
	"receiverPhoneNumber":900900,
	"packageDeclaredValue":19000,
	"weight":1,
	"destinationAddress":"cll26"
}
```
**Expected response:**
The service will generate a guide number to identify the delivery and the initial status will always be Received.
```json
{
	"guideNumber": "6a483bc0-2e77-4b80-87dd-eccd81ade143",
	"deliveryStatus": "Received"
}
```

#### GET: api/v1/delivery/{deliveryGuideNumber}
To retrieve an existent delivery's information from the database just indicate the delivery's guide number in the path.

**Request example:**
```
http://localhost:8080/api/v1/delivery/6a483bc0-2e77-4b80-87dd-eccd81ade143
```
**Expected response:**
```json
{
	"idClient": 1,
	"originCity": "Armenia",
	"destinationCity": "Medellin",
	"destinationAddress": "cll26",
	"receiverName": "Ricky",
	"receiverPhoneNumber": 900900,
	"packageDeclaredValue": 19000.0,
	"weight": 1.0,
	"deliveryValue": 30000.0,
	"status": "Received",
	"guideNumber": "6a483bc0-2e77-4b80-87dd-eccd81ade143"
}
```
#### GET: api/v1/delivery?status={status}&employeeId={employeeId}
To filter deliveries by status  just indicate the status and an existent employee's id.

**Request example:**
```
http://localhost:8080/api/v1/delivery?status=Received&employeeId=1
```
**Expected response:**
The service will return a list of the deliveries that satisfy that condition.
```json
[
	{
		"idClient": 1,
		"originCity": "Armenia",
		"destinationCity": "Medellin",
		"destinationAddress": "cll26",
		"receiverName": "Ricky",
		"receiverPhoneNumber": 900900,
		"packageDeclaredValue": 19000.0,
		"weight": 1.0,
		"deliveryValue": 30000.0,
		"status": "Received",
		"guideNumber": "6a483bc0-2e77-4b80-87dd-eccd81ade143"
	},
	{
		"idClient": 1,
		"originCity": "Armenia",
		"destinationCity": "Medellin",
		"destinationAddress": "cll86",
		"receiverName": "Matthew",
		"receiverPhoneNumber": 800800,
		"packageDeclaredValue": 22000.0,
		"weight": 2.0,
		"deliveryValue": 30000.0,
		"status": "Received",
		"guideNumber": "1a773bc0-2b77-5a80-99dd-eaad81aed143"
	}	
]
```

#### PUT: api/v1/delivery
To update an existent delivery's status indicate the employee's id, the delivery's guide number and the updated status. 
(Note: the flow is Received -> On Route -> Delivered)

**Request example:**
```json
{
	"idEmployee":1,
	"guideNumber":"6a483bc0-2e77-4b80-87dd-eccd81ade143",
	"deliveryStatus":"On route"
}
```
**Expected response:**
```json
{
	"guideNumber": "6a483bc0-2e77-4b80-87dd-eccd81ade143",
	"lastStatus": "On route"
}
```
