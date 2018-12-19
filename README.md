# warriors-party
云服务项目&lt;学习>

## 项目搭建中版本参阅:
    
    ·https://www.oschina.net/news/97226/spring-cloud-finchley-released
    ·https://blog.csdn.net/qq_37170583/article/details/80704904
    
    springcloud ---Finchley.RELEASE和springboot 2.0.6似乎有一些小问题如果出现问题,请降低版本  Finchley.SR1和2.0.3
    
### springboot热部署参阅:

    https://www.cnblogs.com/winner-0715/p/6666579.html#_label0
    
## Eureka-Server 注册中心: 

        如果在Eureka Server的首页看到以下这段提示，则说明Eureka已经进入了保护模式:
    
        EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN 
    THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.
    
        保护模式主要用于一组客户端和服务端(注册中心Eureka-Server)之间存在网络分区场景下的保护。一旦进入保护模式，Eureka Server将会尝试保护其
    服务注册表中的信息，不再删除服务注册表中的数据（也就是不会注销任何微服务）
    
        多个Eureka-Server之间也会互相注册为服务，当服务提供者注册到Eureka集群中的某个节点时，该节点会把服务的信息同步给集群中的每个节点，从而实
    现数据同步。因此，无论客户端访问到Eureka Server集群中的任意一个节点，都可以获取到完整的服务列表信息。服务提供者在启动时，会检测配置属性中的：
    eureka.client.register-with-erueka=true参数是否正确，默认就是true。如果值确实为true，则会向EurekaServer发起一个Rest请求，并携带自
    己的元数据信息，Eureka Server会把这些信息保存到一个双层Map结构中。第一层Map的Key就是服务名称，第二层Map的key是服务的实例id.

## Config-Server 配置中心

### http请求地址和资源文件映射如下:
    
    /{application}/{profile}/{label}
    /{application}-{profile}.yml
    /{label}/{application}-{profile}.yml
    /{application}-{profile}.properties
    /{label}/{application}-{profile}.properties


### 子服务中的配置文件说明参阅:
    
    ·https://blog.csdn.net/xx326664162/article/details/80048704
    
        上述我们提到Eureka-Server不止一个。因此我们再注册配置注册中心的地址就可以配置多个，以逗号分隔，当然也可以配置一个，因为Eureka集群中的节
    点都是相互同步的。
                lease-expiration-duration-in-seconds：服务失效时间，默认值90秒
                lease-renewal-interval-in-seconds：服务续约的间隔，默认为30秒
        就是说，默认情况下每隔30秒服务会向注册中心发送一次心跳，证明自己还活着。如果超过90秒没有发送心跳，EurekaServer就会认为该服务宕机，会从服
    务列表中移除，把它保护起来，暂时停止服务。
    