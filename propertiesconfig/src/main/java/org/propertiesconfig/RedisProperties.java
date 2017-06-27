package org.propertiesconfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "redis", locations = "classpath:redis.properties")
public class RedisProperties {

	private String ip;
	private int port;
	private String user;
	private List<String> whiteList;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	 

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<String> getWhiteList() {
		return whiteList;
	}

	public void setWhiteList(List<String> whiteList) {
		this.whiteList = whiteList;
	}

	@Override
	public String toString() {
		return "RedisProperties [ip=" + ip + ", port=" + port + ", user=" + user + ", whiteList=" + whiteList + "]";
	}

}
