# MensajeriaExpress

## Endpoints

#### Client related operations
With the following endpoints you can execute all of the CRUD (create, read, update, delte) operations. \
<br>
##### POST: api/v1/client
To create a client on the database you must provide an id (number max 10 digits),  name (string), last name (string), phone number (number), email (string), address (string) and city (string). 

**Request example:**
```
{
	"id": 1,
	"name": "Sofia",
	+ "lastName": "Millan",
	"phoneNumber": 123123,
	"email": "isabella@gmail.com",
	"address": "Cll26",
	"city": "Medellín"
}
```
