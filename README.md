# graphql-workshop

Endpoint:
http://localhost:8080/graphql

Test-client:
http://localhost:8080/graphiql

Browse database:
http://localhost:8080/h2-console/

## Queries

```graphql
{
    athletes(count: 10) {
        id,
        firstName,
        lastName
    }
}
```
```graphql
query {
    clubs {
        id,
        name,
        athletes{
            id,
            firstName,
            lastName,
            clubs{
                id,
                name
            }
            activities{
                id,
                name
            }
        }
    }
}
```

## Mutations
```graphql
mutation {
    createAthlete(lastName: "Tyson", firstName: "Mike"){
        id,
        firstName,
        lastName
    }
}
```
