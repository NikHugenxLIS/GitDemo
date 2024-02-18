package com.framework.web.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
static Properties properties;
	
	public String getPropertyKeyValue(String Key) throws IOException
	{
		FileInputStream fis =new FileInputStream("./CommonData/CommonData.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		
		String value =pobj.getProperty(Key);
		
		return value;
	}
	
     
	public static String getProperty(String keyvalue)
	{
		String key = properties.getProperty(keyvalue);
		return key;
	}

}
