 1、 springboot 整合logback
 因为springboot 默认整合的是logback ,  需要另外配置log4j2
 

3 xml配置
三个部分 appenders  定义记录哪些包下的日志，以及日志级别，以及定义文件输出 以及控制台日志
loggers 日志的入口，appenders要想生效，必须配置进这里
 Properties 定义自己的参数
		