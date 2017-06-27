springboot  加载配置文件

1、 加入properties文件，创建文件对应的bean，bean的属性对应properties的key名，

2、@ConfigurationProperties(prefix = "redis", locations = "classpath:redis.properties")  用于指定加载哪个文件，key的前缀名 

3 app.class  @EnableConfigurationProperties({RedisProperties.class})  
