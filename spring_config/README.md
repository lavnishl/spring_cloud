A basic Spring Cloud Config Client & Server

MAKE A CONFIG SERVER
1) When starting spring book project include a spring ‘cloud config server’
2) Make a local git repo … add any properties file with sample message
3) In main spring application add add annotation @EnableConfigServer
4) In spring boot ‘cloud config server’ properties file add 
spring.cloud.config.server.git.uri=C:/Users/llalc2/git/configuration
server.port=8888
5) Commit properties file in git
6) Use URL : localhost:8888/config-client-development.properties OR localhost:8888/config-client-development.json

MAKE A CONFIG CLIENT
1) When starting spring book project include a spring ‘cloud config client’ + ‘web’ + ‘actuator’
2) Write Client
3) Write bootstrap.properties , it is loaded before application.properties
spring.profiles.active=development
spring.application.name=config-client
spring.cloud.config.uri=http://localhost:8888
4) Note … How spring.application.name & spring.profile.active combine to form file name in git
 
Can modify the configuration using rest apis exposed by actuator
1) Add @RefreshScope to our client
2) Change & Commit git file ( source of our config server ) 
3) Send POST request curl to refresh client … curl --data ‘’ http://localhost:8080/refresh
4) So you can modify a property in your application without restart
 
Can use Encrypted Properties
1) Using Cryptography Extension (i) local_policy.jar & (ii) US_export_policy.jar
2) use pre configured urls