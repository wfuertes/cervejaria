# cervejaria [![wfuertes](https://circleci.com/gh/wfuertes/cervejaria.svg?style=shield)](https://github.com/wfuertes/cervejaria)
Example REST project using (jersey 1.19 + guice 3.0) 

# Running
(com hsqlbd e tomcat7) 
```
$ mvn hsqldb:start tomcat7:run 
```

# Curls
    
## GET 
```
curl -v -X GET 'http://localhost:8080/cervejaria/api/beer' 
```

## POST 
```
 curl -v -X POST 'http://localhost:8080/cervejaria/api/beer' -H 'Content-Type:application/json' -d '{"name" : "A outra", "price" : "9.00"}'
``` 
 
 ```
 curl -v -X POST 'http://localhost:8080/cervejaria/api/beer' -H 'Content-Type:application/json' -d '{"NAME" : "Devassa", "pRice" : "5.00"}'
 ``` 
