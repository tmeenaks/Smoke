/*Description : This Class is menat for taking up all the tunneling activity
Author:Meenak
Project :IoT*/

package com.org.iot.test.smoke;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.jcraft.jsch.*;
public class Tunneling {
	
	public int allocatedport;
	final static Logger logger = Logger.getLogger(Tunneling.class);
	
	Config cnObj=new Config();
	public boolean dbserverTunnel() throws IOException{
		PropertyConfigurator.configure("log4j.properties");
		
		logger.info("Tunneling The DB server in the remote location");
		
		try {
	        JSch schobj = new JSch(); 
	        logger.info("Initiating SSH Session");
	        Session session = schobj.getSession(cnObj.gettunnelLogin(),cnObj.gettunnelHost(), 22);
	        session.setPassword(cnObj.gettunnelPassword());
	        java.util.Properties config = new java.util.Properties();
	        config.put("StrictHostKeyChecking", "no");
	        config.put("Compression", "yes");
	        config.put("ConnectionAttempts","2");
	        session.setConfig(config);
	        logger.info("SSH Session Connecting......");
	        session.connect();  
	        boolean sshconnect = session.isConnected();
	        if (sshconnect == true){
	        logger.info("SSH Session Connected Successfully");

	        }
	        
	        else
	        {
	        	logger.info("SSH Connection Failed");
	        }
	        
	        logger.info("Port Forwarding to local host is intiated");
	        	allocatedport=session.setPortForwardingL("0.0.0.0",cnObj.gettunnelsourcePort(), 
	        	cnObj.gettunnelHost(),cnObj.gettunnelremotePort());
	        		
	        		if(allocatedport != 0){
	        
	        		logger.info("Source Port in the Local Machine:\t"+allocatedport);
	        		logger.info("Port Fowarding Done Successfully");
	        		return true;
	        		}
	        		else{
	        			
	        			logger.info("Port Forwarding Failed");
	        			return false;
	        		}

	    } catch (JSchException e) {            
	        logger.error("Tunneling Unsussessful:\t" + e.getMessage());
	        return false;
	    }
	}

}
