/*This Class will have al the Asset, ACPI, Application, Subscription etc values
Author: Meenak
Project: IoT*/


package com.org.iot.test.smoke;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class Config{

	FileInputStream fis;
	Properties prop;

	public double randomRI(){

		double random = Math.random();
		return random;
	}

	public String getBaseUri() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("baseuri");

	}

	public String getBasepath() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("basepath");

	}
	
	
	public String getPort() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return (prop.getProperty("port"));

	}
	
	public String getAsset() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return (prop.getProperty("assetname"));

	}

	public String getOrigin() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("origin");

	}
	
	public String getOrigin_1() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("origin_1");

	}
	public String getAuthorization() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("authorization");
	}

	public String getAuthorization_1() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("authorization_1");

	}

	public String getContentype_AE() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("contenttype_AE");

	}
	
	public String getContentype_GRP() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("contenttype_GRP");

	}
	
	public String getContentype_CNT() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("contenttype_CNT");

	}
	
	public String getContentype_SUBS() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("contenttype_SUB");

	}


	public String getSyncrequest() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("sync");

	}

	public String getAsyncrequest() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("async");

	}

	public String getAccept() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("accept");
	}
	public String getNodelink() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("nodelink");
	}
	
	public String getconnectionURL() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("connectionurl");
	}

	public String getdbPort() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("dbport");
	}
	
	public String getdbHost() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("host");
	}
	
	public String getdbpassword() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("password");
	}
	
	public String getdbLogin() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("login");
	}
	public String getdbName() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("databasename");
	}
	
	public String gettunnelHost() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("tunnelhost");
	}
	
	
	public String gettunnelLogin() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("tunnellogin");
	}
	
	public String gettunnelPassword() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty("tunnelpassword");
	}
	
	public int gettunnelsourcePort() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return Integer.parseInt(prop.getProperty("tunneldbsourceport"));
	}
	
	public int gettunnelremotePort() throws IOException{

		fis= new FileInputStream("config.properties");
		prop=new Properties();
		prop.load(fis);
		return Integer.parseInt(prop.getProperty("tunneldbremoteport"));
	}
	
}




