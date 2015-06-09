# cervejaria
Projeto exemplo: REST (jersey 1.19 + guice 3.0)

# Rodando
// (isto vai executar o goal default com hsqlbd e tomcat7)
$ mvn 

# Curls de exemplo

private String name;
    private BigDecimal price;
    
#GET 
curl -v -X GET 'http://localhost:8080/cervejaria/api/beer'

#POST
 curl -v -X POST 'http://localhost:8080/cervejaria/api/beer' -H 'Content-Type:application/json' -d '{"name" : "A outra", "price" : "9.00"}'
 
 curl -v -X POST 'http://localhost:8080/cervejaria/api/beer' -H 'Content-Type:application/json' -d '{"NAME" : "Devassa", "pRice" : "5.00"}'