# location-code
REST API for fetching Swedish counties, municipalities and congregations based on their respective codes.

# Setup
You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

# Running

To start a web server for the application, run:

```bash
lein ring server
```

# API
```bash
GET /counties
GET /counties/:id
GET /municipalities
GET /municipalities/:id
GET /congregations
GET /congregations/:id
```

# Examples
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

```bash
GET /municipalities/0183
{
  "success": true,
  "data": {
    "Sundbyberg"
  }
}
```

```bash
GET /municipalities/9876
{
  "success": false
}
```
