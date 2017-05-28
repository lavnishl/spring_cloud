ZUUL
Also called EdgeService , GateKeeper , API gateWay.

Acts as a simple routing layer that sits in front of microservices within our distributed system
This relieves of our client to be aware of latest microservices instances & locations
request come from clients -> to proxy server (edge server) -> routed to appropriate microservices based on configuration
So Zuul is kind of reverse proxy , it encapsulates all services so that clients are not aware whom they are communicating with.

Zuul is ideal location to setup security as its single point of entry for all of our clients

Benefits of this proxy is 
1) clients are not aware of server details, it remains static for them
2) in background we can take down services for maintainence , redirect them to different instances, redirect etc

To enable ZUUL , Just add @EnableZuulProxy and then modify application.properties
zuul.routes.somePath.url=http://localhost:5551
After adding above if i enter url http://localhost:5552/somePath/run -> http://localhost:5551/run

Can make it more exclusive , by adding
zuul.routes.somePath.url=http://localhost:5551
zuul.routes.somePath.path=/otherPath/**
So now if i enter url http://localhost:5552/otherPath/run -> http://localhost:5551/run

If i add 
zuul.prefix=/apiV1
http://localhost:5552/apiV1/otherPath/run -> http://localhost:5551/run

FILTERS
This is a great place to do common operations needed in your application
There are many routing filters within zuul that control the flow to our gateWay

1) Make a class that extends com.netflix.zuul.ZuulFilter
2) Override methods as needed
3) Define this new filter class as a Bean in Main Class