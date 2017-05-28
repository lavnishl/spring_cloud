HYSTERIX
Failures always Happens : MicroServices need to isolate that failure and prevent it from cascading it to othe MicroServices.
Avility to monitor all MicroServices via dashboard.

When setting up circuit breaking command you can setup properties that really fine tune when circuit breaking occurs so you can setup different latency rules etc (helpful to prevent long running commands).

Stream on Information how 

When MicroService goes down hystrix starts rerouting the traffic via circuit breaker. when microservice is back hystrix will go back to normal. 

MAKE A SIMPLE SERVICE
MAKE A HYSTRIX APPLICATION that Calls Simple Service + specifies a failover using @EnableCircuitBreaker + @HystrixCommand(fallbackMethod="failover")
NOTE : failover should have the same signature

Can also use @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="500")
So any request that takes more than 500 milliseconds will goto failover 
See hysrix wiki for other configurations

DASHBOARD
1) inclue dependency in pom
2) For Dashboard use @EnableHystrix instead of @EnableCircuitBreaker
3) Add @EnableHystrixDashboard
Now start the application and see http://localhost:8884/hystrix.stream 	OR http://localhost:8884/hystrix


