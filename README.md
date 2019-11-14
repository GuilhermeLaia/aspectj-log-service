# aspectj-log-service
Microservices by AspectJ native for logs 

### Setup

```
mvn clean package
mvn spring-boot:run
```

### vm arguments

-javaagent:${user.home}/.m2/repository/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar

### API LOGGER

```
GET LOGGER -> http://localhost:8080/aspectj/api/v1/loggers
```

```
POST LOGGER -> http://localhost:8080/aspectj/api/v1/service.monitor
Payload ->
{
    "configuredLevel": "OFF",
    "effectiveLevel": "OFF"
}
```