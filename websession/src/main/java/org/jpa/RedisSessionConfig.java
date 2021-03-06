package org.jpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration  
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 180)
public class RedisSessionConfig {

}
