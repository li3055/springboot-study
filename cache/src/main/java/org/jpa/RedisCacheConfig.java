package org.jpa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * redis 缓存配置;
 *
 * 
 * 
 * 注意：RedisCacheConfig这里也可以不用继承 ：CachingConfigurerSupport，也就是直接一个普通的Class就好了；
 *
 * 
 * 
 * 这里主要我们之后要重新实现 key的生成策略，只要这里修改KeyGenerator，其它位置不用修改就生效了。
 *
 * 
 * 
 * 普通使用普通类的方式的话，那么在使用@Cacheable的时候还需要指定KeyGenerator的名称;这样编码的时候比较麻烦。
 *
 * 
 * 
 * @author Angel(QQ:412887952)
 * 
 * @version v.0.1
 * 
 */

@Configuration
@EnableCaching // 启用缓存，这个注解很重要；
public class RedisCacheConfig extends CachingConfigurerSupport {

	@Override
	public KeyGenerator keyGenerator() {

		System.out.println("RedisCacheConfig.keyGenerator()");

		return new KeyGenerator() {

			@Override

			public Object generate(Object o, Method method, Object... objects) {

				// This willgenerate a unique key of the class name, the method
				// name

				// and allmethod parameters appended.

				Class cal = (Class) o.getClass();
				
				StringBuilder sb = new StringBuilder();

				sb.append(cal.getName());

			//	sb.append(method.getName());
				
			//	 Field[] fields = cal.getDeclaredFields();  

				for (Object obj : objects) {
					sb.append(obj.toString());
				}

				System.out.println("keyGenerator=" + sb.toString());

				return sb.toString();

			}

		};

	}

	/**
	 * 
	 * 缓存管理器.
	 * 
	 * @param redisTemplate
	 * 
	 * @return
	 * 
	 */

	@Bean
	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {

		CacheManager cacheManager = new RedisCacheManager(redisTemplate);

		return cacheManager;

	}

	/**
	 * 
	 * redis模板操作类,类似于jdbcTemplate的一个类;
	 *
	 * 
	 * 
	 * 虽然CacheManager也能获取到Cache对象，但是操作起来没有那么灵活；
	 *
	 * 
	 * 
	 * 这里在扩展下：RedisTemplate这个类不见得很好操作，我们可以在进行扩展一个我们
	 *
	 * 
	 * 
	 * 自己的缓存类，比如：RedisStorage类;
	 *
	 * 
	 * 
	 * @param factory
	 *            : 通过Spring进行注入，参数在application.properties进行配置；
	 * 
	 * @return
	 * 
	 */

	@Bean
	public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(connectionFactory);
		setMySerializer(template);
		template.afterPropertiesSet();
		System.out.println(
				"template{---------------------------------------------------------------------------------------}");
		// System.out.println("template{}"
		// +ReflectionToStringBuilder.toString(template,
		// ToStringStyle.SHORT_PREFIX_STYLE));
		return template;
	}

	/**
	 * 设置序列化方法
	 */
	private void setMySerializer(RedisTemplate template) {
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
				Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(template.getStringSerializer());
		template.setValueSerializer(jackson2JsonRedisSerializer);
	}

}