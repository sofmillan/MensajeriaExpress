# MensajeriaExpress

## Endpoints

### Client related operations
With the following endpoints you can execute all of the CRUD (create, read, update, delte) operations. \
<br>
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
