springboot  引入redissession 作为分布式缓存

1: 加入redissession 支持
	<dependency>
			<groupId>org.springframework.session</groupId>
			<artifactId>spring-session-data-redis</artifactId>
		</dependency>


2: 声明启用redissession 
@Configuration  
@EnableRedisHttpSession

3：配置redis 
# server host1

spring.redis.host=127.0.0.1  

# server password

#spring.redis.password=

#connection port

spring.redis.port=6379
 
