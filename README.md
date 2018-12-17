# warriors-party
云服务项目&lt;学习>



### 项目搭建中版本参阅：
    
    https://www.oschina.net/news/97226/spring-cloud-finchley-released
    https://blog.csdn.net/qq_37170583/article/details/80704904
    
    
    springcloud ---Finchley.RELEASE和springboot 2.0.6似乎有一些小问题
    如果出现问题 降低版本  Finchley.SR1和2.0.3



### 在spring-cloud 分布式配置中
    
        存在一个小的注意点，云端的配置文件中一点要也一定要指定注册中心的地址
    否则会报找不到注册中心，当然如果配置的是8761端口，默认是可以省略的。