package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties property;
	
	public ReadConfig() {
		File src = new File("./ConfigurationFiles/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			property = new Properties();
			property.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is "+ e.getMessage());
		}
	}

	
	public String getApplicationURL() {
		String url = property.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String username = property.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String password = property.getProperty("password");
		return password;
	}
	
	public String getChromepath() {
		String chromepath = property.getProperty("chromepath");
		return chromepath;
	}
	
	public String getEdgepath() {
		String edgepath = property.getProperty("edgepath");
		return edgepath;
	}
	
	
	
	
	
	
}
