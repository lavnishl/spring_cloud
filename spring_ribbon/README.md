RIBBON
Its a client side load balancer.
you need different instance of service and idea is ribbon will route the reques to different instances. ribbon will route different requests to different instances so that it is able to balance the load.

It can be configured to work with Eureka

Root Context Path @RequestMapping("/") is used to check whether or not the particular service is running or not.

To explain bottoms up
1) you want to call following from client : restTemplate.getForObject("http://basic-service/run", String.class);
2) in client you need to specify properties like 'basic-service.ribbon.listOfServers' + 'ServerRefreshInterval' + ''
3) in client you need to declare a ServerConfiguration.java with interfaces like IClientConfig & IPing & IRule