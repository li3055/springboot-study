package org.jpa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Genrate {
	public static void main(String[] args) throws SQLException, IOException, InterruptedException, InvalidConfigurationException, XMLParserException, ClassNotFoundException{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		ConfigurationParser cp = new ConfigurationParser(warnings);
		
//		File file = new File("classpath:generatorConfig.xml");
//		InputStream is = new FileInputStream(file);
		InputStream is = Class.forName(Genrate.class.getName()).getResourceAsStream("/generatorConfig.xml");
		Configuration config = cp.parseConfiguration(is);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}
}
