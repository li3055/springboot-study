 配置返回数据的json处理包
 
 1、App启动类继承WebMvcConfigurerAdapter  然后重写 
 public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter convert = new FastJsonHttpMessageConverter();
		FastJsonConfig jsonConfig = new FastJsonConfig();
		jsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		convert.setFastJsonConfig(jsonConfig);
		converters.add(convert);
	}
	
	
方式二： 通过@Bean 注解，注入json依赖设置
@Bean
	public HttpMessageConverters fastJsonHttpMessageConverter(){
		FastJsonHttpMessageConverter convert = new FastJsonHttpMessageConverter();
		FastJsonConfig jsonConfig = new FastJsonConfig();
		jsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		convert.setFastJsonConfig(jsonConfig);
		HttpMessageConverter<?> c = convert;
		return new HttpMessageConverters(c);
	}	
 