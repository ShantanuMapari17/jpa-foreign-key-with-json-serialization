# APIS
- GET {url}/api/persons
  - return list of all persons
- GET {url}/api/persons/{id}
  - return list of specific person
- PUT {url}/api/persons/{id}
  - updates the person
- POST {url}/api/persons
  - add new person
- DELETE {url}/api/persons/{id}
  - deletes person with specifies id

## DB used H2


### expected input
```
{
    "name": "John Doe",
    "age": 30,
    "address": "123 Main St",
    "phone": "555-1234",
    "email": "john.doe@example.com"
}
```

### expected output
```
{
    "name": "John Doe",
    "age": 30,
    "address": "123 Main St",
    "phone": "555-1234",
    "email": "john.doe@example.com"
}
```
