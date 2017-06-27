springboot  引入ehcache 缓存

1: 加入ehcache 支持
	   <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-context-support</artifactId>
        </dependency>
        
		<!-- 集成ehcache需要的依赖 -->
		<dependency>
			<groupId>net.sf.ehcache</groupId>
			<artifactId>ehcache</artifactId>
		</dependency>

2: 配置ehcache.xml 配置文件
 

3：配置redis 缓存管理器
类注解 @Configuration  @EnableCaching // 启用缓存，这个注解很重要；		
类继承 CachingConfigurerSupport 
注册缓存管理器 EhCacheCacheManager
注入redisTemplate ，同时设置序列化和反序列化的接口实现，有jdk 有jackson
实现自己的keygenerate

4: 在service层注解方法@Cacheable(value = "cat"), value表示缓存目录,以类为单位
5:更新后要消除注解,@CacheEvict(value = "cat",allEntries =true)  表示删除cat换出目录下的所有缓存
