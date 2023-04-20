# MensajeriaExpress

## Endpoints

### Client related operations
With the following endpoints you can execute all of the CRUD (create, read, update, delte) operations. \

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
http://localhost:8080/api/v1/employee/123
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
