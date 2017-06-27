springboot  引入redis 缓存

1: 加入redis 支持
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-redis</artifactId>
		</dependency>

2: 配置redis 参数
spring.redis.database=0

# server host1

spring.redis.host=127.0.0.1  

# server password

#spring.redis.password=

#connection port

spring.redis.port=6379

3：配置redis 缓存管理器
类注解 @Configuration  @EnableCaching // 启用缓存，这个注解很重要；		
类继承 CachingConfigurerSupport 
注册缓存管理器 CacheManager
注入redisTemplate ，同时设置序列化和反序列化的接口实现，有jdk 有jackson
实现自己的keygenerate

4: 在service层注解方法@Cacheable(value = "cat"), value表示缓存目录,以类为单位
5:更新后要消除注解,@CacheEvict(value = "cat",allEntries =true)  表示删除cat换出目录下的所有缓存
