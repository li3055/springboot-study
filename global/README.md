springboot 加入全局异常管理

1、创建exceptionHandler类，加上泪注解@ControllerAdvice 

2、创建异常处理方法  加上注解@ExceptionHandler(value=Exception.class)
 	