# location-code
REST API for fetching Swedish counties, municipalities and congregations based on their respective codes.

# Setup
You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

# Running

Start the server with:

```bash
lein ring server
```

# API
Resources are fetched through:
```bash
GET /counties
GET /counties/:id
GET /municipalities
GET /municipalities/:id
GET /congregations
GET /congregations/:id
```

## Examples

### Listing resources

```bash
GET /counties
{
  "success": true,
  "data": {
    "01": "Stockholms län",
    "03": "Uppsala län",
    "04": "Södermanlands län",
    "05": "Östergötlands län",
    ...
  }
}
```

### Individual resources

```bash
GET /municipalities/0183
{
  "success": true,
  "data": {
    "Sundbyberg"
  }
}
```

### Missing resources

```bash
GET /municipalities/9876
{
  "success": false
}
```
